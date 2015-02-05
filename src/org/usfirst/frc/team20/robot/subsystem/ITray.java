package org.usfirst.frc.team20.robot.subsystem;

/**
 * The tray is a subsystem which allows totes to be loaded onto the robot from
 * the chute. A loaded tote will remain until it is added to the base of the
 * stack by the claw which will descend to pick up the new tote.
 * 
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 */
public interface ITray extends ISubsystem {

	/**
	 * Extend the tray at some fixed rate. Implementations should be similar to
	 * states, in that if the tray is fully out (in the 'tray out' state), the
	 * extend() method should do nothing.
	 */
	void extend(double speed);

	/**
	 * Retract the tray at some fixed rate. Implementations should be similar to
	 * states, in that if the tray is fully in (in the 'tray in' state), the
	 * retract() method should do nothing.
	 */
	void retract(double speed);

	/**
	 * {@inheritDoc}
	 */
	void update();
}