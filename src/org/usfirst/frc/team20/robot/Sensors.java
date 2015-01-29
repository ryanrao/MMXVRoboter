package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author Jared Gentner
 */
public class Sensors{
    
	//TODO actually assign real ports based on robot configuration
	
	/**
	 * Encoder on the left side of the robot.  This is only valid for driving
	 * straight and is only for use in autonomous mode.
	 */
    public static final Encoder leftEncoder = new Encoder(0,0);
    
    /**
     * Encoder on the right side of the robot.  This is only valid for driving
     * straight and is only for use in autonomous mode.
     */
    public static final Encoder rightEncoder = new Encoder(0,0);
    
    /**
     * Encoder on robot elevator to determine how high the claw is raised.  Implementations
     * of <code>IClaw</code> should set the encoder to 0 whenever the claw hits the 
     * elevatorLoweredSwitch and to the height of the lift whenever the claw hits the
     * elevatorRaisedSwitch.
     */
    public static final Encoder elevatorEncoder = new Encoder(0,0);
    
    /**
     * Gyro to determine angle of robot relative to field.  Possible uses could be
     * for fieldcentric drive or to maintain a specific angle.
     */
    public static final Gyro gyro = new Gyro(0);
    
    /**
     * Switch to determine if the tray to receive totes from the feeding station is in or out.
     */
    public static final DigitalInput traySwitch = new DigitalInput(0);
    
    /**
     * Switch to determine if the elevator is lowered fully, used for calibrating the encoder
     * and for changing states.
     */
    public static final DigitalInput elevatorLoweredSwitch = new DigitalInput(0);
    
    /**
     * Switch to determine if the elevator is raised fully, used for calibrating the encoder
     * and for changing states.
     */
    public static final DigitalInput elevatorRaisedSwitch = new DigitalInput(0);
    
    /**
     * Switch to determine if an object is in the claw.
     */
    public static final DigitalInput toteInClawSwitch = new DigitalInput(0);
}