package org.usfirst.frc.team20.robot.subsystem.tray;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;

/**
 * State representing a fully extended tray.
 * 
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 *
 */
public class TrayExtended implements RobotTray{
	
	/**
	 * Override the default extend to prohibit extending on a tray that is
	 * fully extended.
	 * @param speed not used
	 */
	@Override public void extend(double speed){
	}

	/**
	 * Update the state of the tray.  The next state will be TrayIndeterminate.
	 */
	@Override public void update() {
		if(!Sensors.trayExtendedSwitch.get()){
			Robot.tray = new TrayIndeterminate();
		}
	}

}
