package org.usfirst.frc.team20.robot.subsystem;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;
/**
 * 
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 *
 */
public class ClawMiddle implements IClaw {

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
		if(Sensors.clawClosedSwitch.get()){
			Robot.claw = new ClosedClaw();
		}else if(Sensors.clawOpenedSwitch.get()){
			Robot.claw = new OpenedClaw();
		}
	}

}
