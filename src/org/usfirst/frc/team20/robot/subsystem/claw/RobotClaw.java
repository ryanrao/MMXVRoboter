package org.usfirst.frc.team20.robot.subsystem.claw;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.subsystem.IClaw;

public interface RobotClaw extends IClaw {

	@Override default void open(double speed) {
		Robot.clawLeftSC.set(speed);
		Robot.clawRightSC.set(speed);
	}

	@Override default void close(double speed) {
		Robot.clawLeftSC.set(-speed);
		Robot.clawRightSC.set(-speed);
	}

	@Override void update();
}
