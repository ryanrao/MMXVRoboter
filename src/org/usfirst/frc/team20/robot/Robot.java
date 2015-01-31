package org.usfirst.frc.team20.robot;

import org.usfirst.frc.team20.robot.subsystem.IClaw;
import org.usfirst.frc.team20.robot.subsystem.IElevator;
import org.usfirst.frc.team20.robot.subsystem.ITray;
import org.usfirst.frc.team20.robot.subsystem.claw.ClawIndeterminate;
import org.usfirst.frc.team20.robot.subsystem.elevator.ElevatorIndeterminate;
import org.usfirst.frc.team20.robot.subsystem.tray.TrayIndeterminate;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
/**
 * Robot class. If you could say, the robot 'has a' blank, then it's probably
 * defined here. I'm no more a fan of globals than the next guy, but for
 * guaranteed synchronous, single threaded code, it's easier to work with than
 * parameterizing each subsystem with the sensors it needs, and easier to code
 * than lazy singletons or what not.
 * 
 * @author Hiren 'bhavtsar' Bhavsar <bhavsar.hsb@gmail.com>
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 */
public class Robot extends IterativeRobot {

	private Robot(){}
	
	public static final SpeedController frontLeftSC, backLeftSC, frontRightSC,
		backRightSC, clawLeftSC, clawRightSC, elevatorSCOne, elevatorSCTwo, traySC;
	
	public static IClaw claw;
	public static ITray tray;
    public static IElevator elevator;
    
	public static DriveInput driveInput;

	/*
	 * Initialize all static members (subsystems and speed controllers.)
	 */
	static {
		// TODO actually assign real ports based on robot configuration
		frontLeftSC = new CANTalon(0);
		frontRightSC = new CANTalon(0);
		backLeftSC = new CANTalon(0);
		backRightSC = new CANTalon(0);
		clawLeftSC = new CANTalon(0);
		clawRightSC = new CANTalon(0);
		elevatorSCOne = new CANTalon(0);
		elevatorSCTwo = new CANTalon(0);
		traySC = new CANTalon(0);
		
		claw = new ClawIndeterminate();
		tray = new TrayIndeterminate();
		elevator = new ElevatorIndeterminate();
		
		driveInput = new DriveInput();
	}

	/**
	 * Method to initialize the robot. Don't ask me why it exists and why it's
	 * any better than an initializer (sigh) but I do what I'm told.
	 */
	public void robotInit() {

	}

	/**
	 * Called in a loop during autonomous. Not really that helpful.
	 */
	public void autonomousPeriodic() {

	}

	/**
	 * Called in a loop during teleop. Used to update each Subsystem state.
	 */
	public void teleopPeriodic() {

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}
}
