package org.usfirst.frc.team20.robot.subsystem;

/**
 * Interface representing a subsystem to be used in an iterative robot. Any
 * subsystem will be able to react to inputs whenever it receives an update
 * call. Think of the subsystems as observers and the globals in Robot as the
 * subject I suppose.
 * 
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 */
public interface ISubsystem {

	/**
	 * Update the state of this subsystem. Note that the subsystem state object
	 * can be found in <code>Robot</code> like pretty much anything else.
	 */
	void update();
}
