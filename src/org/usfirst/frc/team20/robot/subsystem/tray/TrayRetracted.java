package org.usfirst.frc.team20.robot.subsystem.tray;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;

/**
 * State representing a tray that is fully retracted.
 * 
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 *
 */
public class TrayRetracted implements RobotTray {

	/**
	 * Override the default retract to prohibit retracting on a tray that is
	 * fully retracted.
	 * @param speed not used
	 */
	@Override public void retract(double speed) {
	}

	/**
	 * Update the state of the tray.  The next state will be TrayIndeterminate.
	 */
	@Override public void update() {
		if(!Sensors.trayRetractedSwitch.get()){
			Robot.tray = new TrayIndeterminate();
		}
	}
}
