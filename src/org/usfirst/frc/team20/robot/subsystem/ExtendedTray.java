package org.usfirst.frc.team20.robot.subsystem;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;

/**
 * 
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 *
 */
public class ExtendedTray implements ITray{

	@Override
	public void extend(double speed) {
		// Leave Empty
		
	}

	@Override
	public void retract(double speed) {
		Robot.traySC.set(-speed);
		
	}

	@Override
	public void update() {
		if (!Sensors.trayExtendedSwitch.get()) {
			Robot.tray = new TrayMiddle();
		}
		
	}
	
}
