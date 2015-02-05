package org.usfirst.frc.team20.robot.subsystem.elevator;

import org.usfirst.frc.team20.robot.Constants;
import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;
import org.usfirst.frc.team20.robot.Utils;
import org.usfirst.frc.team20.robot.subsystem.IElevator;
import org.usfirst.frc.team20.robot.subsystem.ISubsystem;

/**
 * Interface with default behaviors defined for an elevator dependent on the
 * Robot and Sensors code of this particular setup.  This class is provided
 * for convenience to avoid locking the IElevator interface to the Robot class
 * and also to provide the default behaviors nonetheless.
 * 
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 *
 */
public interface RobotElevator extends IElevator, ISubsystem{

	/**
	 * Check if the elevator is at the top of the lift.
	 * @return if the elevator is at the top of the lift.
	 */
	static boolean isElevatorAtTop(){
		return Utils.epsilonEquals(Sensors.elevatorEncoder.getDistance(), 
			Constants.ELEVATOR_HEIGHT, 0.1f);
	}
	
	/**
	 * Get a state corresponding to the current level of the robot or an
	 * indeterminate state.
	 * @return the current state of the elevator
	 */
	static RobotElevator getLevelState(){
		ElevatorLevel level = getElevatorLevel();
		if(level.atLevel)
			return new ElevatorAtLevel(level.level);
		return new ElevatorIndeterminate(level.level);
	}
	
	/**
	 * Get an object representing the level of the elevator currently.
	 * @return the level the elevator is at
	 */
	static ElevatorLevel getElevatorLevel(){
		ElevatorLevel level = new ElevatorLevel();
		double distance = Sensors.elevatorEncoder.getDistance();
		level.height = distance;
		if(Sensors.elevatorLoweredSwitch.get()){
			level.atLevel = true;
			level.level = 0;
			level.height = 0;
			Sensors.elevatorEncoder.reset();
		}
		if(isElevatorAtTop()){
			level.atLevel = true;
			level.level = Constants.ELEVATOR_MAX_LEVEL;
			return level;
		}
		for(int i = 0; i < Constants.ELEVATOR_MAX_LEVEL - 1; ++i){
			double levelHeight = Constants.ELEVATOR_HEIGHT / Constants.ELEVATOR_MAX_LEVEL;
			double min = i * levelHeight;
			double max = (i+1) * levelHeight;
 			if(distance >= min && distance < max){
 				level.level = i;
 				level.atLevel = Utils.epsilonEquals(distance, min, .1f);
 				return level;
  			}
		}
		return null;
	}
	
	/**
	 * A 'struct' of sorts to combine all data needed to uniquely identify the 
	 * state of the elevator.
	 */
	static class ElevatorLevel{
		double height;
		int level;
		boolean atLevel;
	}
	
	/**
	 * A default implementation for lift.  Some elevator states might override
	 * this with a no-op.
	 * @param speed the voltage to set
	 */
	default void lift(double speed){
		Robot.elevatorSCOne.set(speed);
		Robot.elevatorSCTwo.set(speed);
	}
	
	/**
	 * A default implementation for drop.  Some elevator states might override
	 * this with a no-op.
	 * @param speed the voltage to set
	 */
	default void drop(double speed){
		Robot.elevatorSCOne.set(-speed);
		Robot.elevatorSCTwo.set(-speed);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override int getLevel();
	
	/**
	 * Update the state of the elevator.
	 * @see Robot#elevator
	 */
	@Override void update();
}