package org.usfirst.frc.team20.robot.subsystem.elevator;

import org.usfirst.frc.team20.robot.Constants;
import org.usfirst.frc.team20.robot.Robot;

/**
 * State representing an elevator that is at the top of its path.
 * 
 * @author Sandra Wiedmann
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 *
 */
public class ElevatorAtTop implements RobotElevator{

	/**
	 * Override the default lift to prohibit lifting on an elevator that is
	 * at the maximum height.
	 * @param speed not used
	 */
	@Override public void lift(double speed) {
	}
	
	@Override public int getLevel(){
		return Constants.ELEVATOR_MAX_LEVEL;
	}

	/**
	 * Update the state of the elevator.  The next state will be
	 * ElevatorIndeterminate.
	 */
	@Override public void update() {
		//check if the elevator is approximately at maximum height
		if(!RobotElevator.isElevatorAtTop()){
			Robot.elevator = new ElevatorIndeterminate(Constants.ELEVATOR_MAX_LEVEL);
		}
		
	}
}
