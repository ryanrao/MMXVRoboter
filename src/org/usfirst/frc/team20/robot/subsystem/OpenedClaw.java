package org.usfirst.frc.team20.robot.subsystem;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;

/**
 * 
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 *
 */
public class OpenedClaw implements IClaw {

	public void open(double speed) {
		// Leave Empty
	}

	public void close(double speed) {
		Robot.clawLeftSC.set(-speed);
		Robot.clawRightSC.set(-speed);

	}

	public void update() {
		if (!Sensors.clawOpenedSwitch.get()) {
			Robot.claw = new ClawMiddle();
		}
	}
}
