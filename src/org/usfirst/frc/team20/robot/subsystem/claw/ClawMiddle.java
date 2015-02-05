package org.usfirst.frc.team20.robot.subsystem.claw;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.subsystem.IClaw;
/**
 * 
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 *
 */
public class ClawIndeterminate implements IClaw {

	@Override
	public void open(double speed) {
		Robot.clawLeftSC.set(speed);
		Robot.clawRightSC.set(speed);
	}

	@Override
	public void close(double speed) {
		Robot.clawLeftSC.set(-speed);
		Robot.clawRightSC.set(-speed);
	}

	@Override
	public void update() {
		
	}

}
