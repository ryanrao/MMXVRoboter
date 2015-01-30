package org.usfirst.frc.team20.robot.subsystem;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;

/**
 * 
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 *
 */
public class ClosedClaw implements IClaw {
	
	public void open(double speed) {
		// TODO actually assign real values based on robot configuration
		Robot.clawLeftSC.set(0);
		Robot.clawRightSC.set(0);
	}

	public void close(double speed) {
		//Leave Empty
	}

	public void update() {
		if (!Sensors.clawClosedSwitch.get()) {
			Robot.claw = new ClawMiddle();
		}
	}
}
