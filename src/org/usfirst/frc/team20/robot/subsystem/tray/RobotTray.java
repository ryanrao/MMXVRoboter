package org.usfirst.frc.team20.robot.subsystem.tray;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.subsystem.ITray;

/**
 * Interface with default behaviors defined for a tray dependent on the Robot
 * and Sensors code of this particular setup. This class is provided for
 * convenience to avoid locking the ITray interface to the Robot class and also
 * to provide the default behaviors nonetheless.
 * 
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 *
 */
public interface RobotTray extends ITray {

	/**
	 * A default implementation for extend. Some tray states might override this
	 * with a no-op.
	 * 
	 * @param speed
	 *            the voltage to set
	 */
	@Override default void extend(double speed) {
		Robot.traySC.set(speed);
	}

	/**
	 * A default implementation for retract. Some tray states might override
	 * this with a no-op.
	 * 
	 * @param speed
	 *            the voltage to set
	 */
	@Override default void retract(double speed) {
		Robot.traySC.set(-speed);
	}

	/**
	 * Update the state of the tray.
	 * 
	 * @see Robot#tray
	 */
	@Override void update();
}
