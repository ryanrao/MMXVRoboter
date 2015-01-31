package org.usfirst.frc.team20.robot.subsystem;

/**
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 */
import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;

public class TrayMiddle implements ITray {

	@Override
	public void extend(double speed) {
		Robot.traySC.set(speed);

	}

	@Override
	public void retract(double speed) {
		Robot.traySC.set(speed);

	}

	@Override
	public void update() {
		if (Sensors.trayRetractedSwitch.get()) {
			Robot.tray = new RetractedTray();
		}else if (Sensors.trayExtendedSwitch.get()) {
			Robot.tray = new ExtendedTray();
		}

	}

}
