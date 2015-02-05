package org.usfirst.frc.team20.robot.subsystem.elevator;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;
import org.usfirst.frc.team20.robot.subsystem.IElevator;

/**
 * State representing an elevator that is at the bottom of its path.
 * 
 * @author Sandra Wiedmann
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 *
 */
public class ElevatorAtBottom implements RobotElevator{

	/**
	 * Override the default lift to prohibit lifting on an elevator that is
	 * at the maximum height.
	 * @param speed not used
	 */
	@Override public void drop(double speed) {
	}
	
	@Override public int getLevel(){
		return 0;
	}

	/**
	 * Update the state of the elevator.  The next state will be
	 * ElevatorIndeterminate.
	 */
	@Override public void update() {
		if(!Sensors.elevatorLoweredSwitch.get()){
			Robot.elevator = new ElevatorIndeterminate(0);
		}
	}

	public static IElevator getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
