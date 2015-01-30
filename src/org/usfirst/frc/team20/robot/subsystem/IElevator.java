package org.usfirst.frc.team20.robot.subsystem;

/**
 *
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 */
public interface IElevator extends ISubsystem {

	/**
	 * Raise the elevator at some fixed rate. Implementations should be similar
	 * to states, in that if the elevator is fully up (in the 'elevator up'
	 * state), the lift() method should do nothing.
	 */
	void lift();

	/**
	 * Lower the elevator at some fixed rate. Implementations should be similar
	 * to states, in that if the elevator is fully down (in the 'elevator down'
	 * state), the drop() method should do nothing.
	 */
	void drop();

	/**
	 * {@inheritDoc}
	 */
	@Override void update();
}