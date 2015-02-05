package org.usfirst.frc.team20.robot.subsystem.claw;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;
import org.usfirst.frc.team20.robot.subsystem.IClaw;
/**
 * 
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 *
 */
public class ClawIndeterminate implements RobotClaw {

	@Override
	public void open(double speed) {
	}

	@Override
	public void update() {
		if(Sensors.clawOpenedSwitch.get()){
			Robot.claw = new ClawOpen();
		}else if(Sensors.clawClosedSwitch.get()){
			Robot.claw = new ClawClosed();
		}
	}

}
