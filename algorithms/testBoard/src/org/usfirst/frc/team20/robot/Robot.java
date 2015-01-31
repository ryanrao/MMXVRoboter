package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	Gyro g1;
	Joystick stick = new Joystick(0);
	CANTalon tal1 = new CANTalon(2);
	
	double g1value;
	double p = 4;
	double i = 0.0005;
	double d = 5;
	double ramp = 6;
	double test;
	double position = 0;


	public void robotInit() {
		tal1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		tal1.changeControlMode(CANTalon.ControlMode.Position);
		tal1.setPosition(0);
		tal1.setPID(p, i, d);
		tal1.setCloseLoopRampRate(6);
		tal1.enableControl();
		
		g1 = new Gyro(1);
		g1.initGyro();
		g1.reset();
	}


	public void teleopPeriodic() {
		
		if (stick.getRawButton(1))
			tal1.set(85000 * .25);
		if (stick.getRawButton(2))
			tal1.set(85000 * .50);
		if (stick.getRawButton(4))
			tal1.set(85000 * .75);
		if (stick.getRawButton(3))
			tal1.set(85000);
		if (stick.getRawButton(5))
			tal1.set(0);

		SmartDashboard.putString("Position", "" + stick.getRawAxis(0) * 1);
		SmartDashboard.putString("Enc Position", "" + tal1.getEncPosition());
		SmartDashboard.putString("Current Position", "" + tal1.getPosition());
		g1value = Math.round(g1.getAngle() * 100) / 100;
		SmartDashboard.putString("angle = ", "" + g1value);	
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {

	}

}
