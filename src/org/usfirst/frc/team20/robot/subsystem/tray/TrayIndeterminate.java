package org.usfirst.frc.team20.robot.subsystem.tray;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;


public class TrayIndeterminate implements RobotTray {

	/**
	 * Update the state of the tray.  Possible next states include TrayExtended
	 * and TrayRetracted.
	 */
	@Override public void update() {
		if(Sensors.trayExtendedSwitch.get()){
			Robot.tray = new TrayExtended();
		}else if(Sensors.trayRetractedSwitch.get()){
			Robot.tray = new TrayRetracted();
		}
	}
}
