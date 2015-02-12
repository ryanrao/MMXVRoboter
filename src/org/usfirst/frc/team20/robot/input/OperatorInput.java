package org.usfirst.frc.team20.robot.input;

/**
 * Interface defining a simple protocol to receive operator input.
 * Implementations should be prepared to run their own thread and constantly be
 * pushing data, made accessible by getSource() and getEvent(). Additionally, a
 * flag should be implemented to indicate that if the data is fresh.
 * 
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 *
 */
public interface OperatorInput extends Runnable {

	/**
	 * Get the source and event key of the most recent event. This is guaranteed
	 * to be an unsigned 16 bit integer key (8 for the source and 8 for the
	 * event key)
	 * 
	 * @return an event key
	 */
	int getEvent();

	/**
	 * Determine if the event data is changed, most likely by checking if the
	 * most recent event has already been read or not.
	 * 
	 * @return true if the event is new
	 */
	boolean isChanged();
}
