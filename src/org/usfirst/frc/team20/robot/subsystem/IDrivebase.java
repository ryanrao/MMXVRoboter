package org.usfirst.frc.team20.robot.subsystem;

/**
 *
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 */
public interface IDrivebase extends ISubsystem {

	/**
	 * This method should use some set of inputs to drive the robot. A struct of
	 * inputs driveInputs can be found in the Robot class, and will be updated
	 * each cycle either by an auto mode or by a controller.
	 */
	void drive();

	/**
	 * {@inheritDoc}
	 */
	void update();
}