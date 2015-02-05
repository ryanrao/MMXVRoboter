package org.usfirst.frc.team20.robot.subsystem.claw;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;
import org.usfirst.frc.team20.robot.subsystem.IClaw;

/**
 * 
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 *
 */
public class ClawOpened implements IClaw {

	@Override public void open(double speed) {
	}

	public void update() {
		if (!Sensors.clawOpenedSwitch.get()) {
			Robot.claw = new ClawMiddle();
		}
	}
}
