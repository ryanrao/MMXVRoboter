package org.usfirst.frc.team20.robot.subsystem.elevator;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;

/**
 * State representing an elevator that is in an unidentified position.
 * 
 * @author Sandra Wiedmann
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 *
 */
public class ElevatorIndeterminate implements RobotElevator{

	/**
	 * Update the state of the elevator.  Possible next states include ElevatorAtBottom
	 * and ElevatorAtTop.
	 */
	@Override public void update() {
		if(Sensors.elevatorLoweredSwitch.get()){
			Sensors.elevatorEncoder.reset();
			Robot.elevator = new ElevatorAtBottom();
		}else if(RobotElevator.isElevatorAtTop()){
			Robot.elevator = new ElevatorAtTop();
		}
	}
}
