package org.usfirst.frc.team20.robot.subsystem.claw;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;
import org.usfirst.frc.team20.robot.subsystem.IClaw;

/**
 * 
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 *
 */
public class ClawClosed implements RobotClaw {
	
	public void close(double speed) {
	}

	public void update() {
		if (!Sensors.clawClosedSwitch.get()) {
			Robot.claw = new ClawIndeterminate();
		}
	}
}
