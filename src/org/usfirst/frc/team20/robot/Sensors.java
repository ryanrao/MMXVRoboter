package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;


/**
 *
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 * @author Hiren 'BhavTsar' Bhavsar <bhavsar.hsb@gmail.com>
 */
public class Sensors {
	
	static{
		leftEncoder = new Encoder(0, 0);
		rightEncoder = new Encoder(0, 0);
		elevatorEncoder = new Encoder(0, 0);
		gyro = new Gyro(0);
		trayExtendedSwitch = new DigitalInput(0);
		trayRetractedSwitch = new DigitalInput(0);
		elevatorLoweredSwitch = new DigitalInput(0);
		toteInClawSwitch = new DigitalInput(0);
		clawOpenedSwitch= new DigitalInput(0);
		clawClosedSwitch = new DigitalInput(0);
	}

	// TODO actually assign real ports based on robot configuration

	/**
	 * Encoder on the left side of the robot. This is only valid for driving
	 * straight and is only for use in autonomous mode.
	 */
	public static final Encoder leftEncoder;

	/**
	 * Encoder on the right side of the robot. This is only valid for driving
	 * straight and is only for use in autonomous mode.
	 */
	public static final Encoder rightEncoder;

	/**
	 * Encoder on robot elevator to determine how high the claw is raised.
	 * Implementations of <code>IClaw</code> should set the encoder to 0
	 * whenever the claw hits the elevatorLoweredSwitch and to the height of the
	 * lift whenever the claw hits the elevatorRaisedSwitch.
	 */
	public static final Encoder elevatorEncoder;

	/**
	 * Gyro to determine angle of robot relative to field. Possible uses could
	 * be for fieldcentric drive or to maintain a specific angle.
	 */
	public static final Gyro gyro;

	/**
	 * Switch to determine if the tray to receive totes from the feeding station
	 * is fully extended.
	 */
	public static final DigitalInput trayExtendedSwitch;
	
	/**
	 * Switch to determine if the tray to receive totes from the feeding station
	 * is fully extended.
	 */
	public static final DigitalInput trayRetractedSwitch;

	/**
	 * Switch to determine if the elevator is lowered fully, used for
	 * calibrating the encoder and for changing states.
	 */
	public static final DigitalInput elevatorLoweredSwitch;

	/**
	 * Switch to determine if an object is in the claw.
	 */
	public static final DigitalInput toteInClawSwitch;
	
	/**
	 * Switch to determine if the claw is fully open.
	 */
	public static final DigitalInput clawOpenedSwitch;
	
	/**
	 * Switch to determine if the claw is fully closed.
	 */
	public static final DigitalInput clawClosedSwitch;
}