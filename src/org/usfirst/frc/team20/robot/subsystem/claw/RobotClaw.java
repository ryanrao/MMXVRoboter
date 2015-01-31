package org.usfirst.frc.team20.robot.subsystem.claw;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.subsystem.IClaw;

/**
 * Interface with default behaviors defined for a claw dependent on the
 * Robot and Sensors code of this particular setup.  This class is provided
 * for convenience to avoid locking the IClaw interface to the Robot class
 * and also to provide the default behaviors nonetheless.
 * 
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 *
 */
public interface RobotClaw extends IClaw{
	
	@Override default void open(double speed){
		Robot.clawLeftSC.set(speed);
		Robot.clawRightSC.set(speed);
	}
	
	@Override default void close(double speed){
		Robot.clawLeftSC.set(-speed);
		Robot.clawRightSC.set(-speed);
	}
	
	@Override void update();
}
