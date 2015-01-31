package org.usfirst.frc.team20.robot.subsystem.drivebase;

import org.usfirst.frc.team20.robot.DriveInput;
import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.subsystem.IDrivebase;

/**
 * Implementation of a robotcentric mecanum drivebase.  This Drivebase will 
 * apply the forward input in the forward direction relative to the front of
 * the robot.
 * 
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 *
 */
public class RobotcentricMecanumDrivebase implements IDrivebase{

	@Override public void drive() {
		DriveInput input = Robot.driveInput;
		double speed = input.forward;
		double lateral = input.lateral;
		double turn = input.turn;
		Robot.frontLeftSC.set(limit(-(speed + turn - lateral)));
		Robot.backLeftSC.set(limit(-(speed + turn + lateral)));
		Robot.frontRightSC.set(limit(speed + turn + lateral));
		Robot.backRightSC.set(limit(speed + turn - lateral));
	}

	@Override public void update() {
		/*
		 * unimplemented because, although a drivebase might
		 * change state, this particular drivebase is always
		 * going to be some type of mecanum.
		 * 
		 * Possible implementations for the future could be
		 * to switch between Fieldcentric and Robotcentric
		 * if we REALLY want to (kind of extraneous)
		 */
	}
	
	private double limit(double voltage) {
		if (voltage >= 1)
			return 1;
		if (voltage <= -1)
			return -1;
		return voltage;
	}
}
