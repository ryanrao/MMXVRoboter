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
		Robot.clawLeftSC.set(speed);
		Robot.clawRightSC.set(speed);
	}

	public void close(double speed) {
	}

	public void update() {
		if (!Sensors.clawClosedSwitch.get()) {
			Robot.claw = new ClawMiddle();
		}
	}
}
