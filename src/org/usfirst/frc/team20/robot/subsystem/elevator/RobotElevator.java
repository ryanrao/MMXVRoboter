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

	static boolean isElevatorAtTop(){
		return Utils.epsilonEquals(Sensors.elevatorEncoder.getDistance(), 
			Constants.ELEVATOR_HEIGHT, 0.1f);
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
	 * Update the state of the elevator.
	 * @see Robot#elevator
	 */
	@Override void update();
}