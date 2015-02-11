package org.usfirst.frc.team20.robot;

import org.usfirst.frc.team20.robot.input.DriveInput;
import org.usfirst.frc.team20.robot.input.OperatorController;
import org.usfirst.frc.team20.robot.input.OperatorInput;
import org.usfirst.frc.team20.robot.input.XBoxControllerDriveInput;
import org.usfirst.frc.team20.robot.subsystem.claw.ClawClosed;
import org.usfirst.frc.team20.robot.subsystem.claw.ClawIndeterminate;
import org.usfirst.frc.team20.robot.subsystem.claw.RobotClaw;
import org.usfirst.frc.team20.robot.subsystem.elevator.ElevatorAtBottom;
import org.usfirst.frc.team20.robot.subsystem.elevator.RobotElevator;
import org.usfirst.frc.team20.robot.subsystem.tray.RobotTray;
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
	
	public static RobotClaw claw;
	public static RobotTray tray;
    public static RobotElevator elevator;
    
	public static DriveInput driveInput;
	public static OperatorInput operatorInput;
	
	public static OperatorController controller;
	
	private static final int DRIVER_JOYSTICK_SLOT= 0;

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
		elevator = new ElevatorAtBottom();
		driveInput = new XBoxControllerDriveInput(DRIVER_JOYSTICK_SLOT);
	}

	/**
	 * Method to initialize the robot.
	 */
	@Override public void robotInit() {
		controller.setClawCloseAction(()->{
			claw.close(.1);
		});
		
		controller.setClawOpenAction(()->{
			claw.open(.1);
		});
		
		controller.setDropAction(()->{
			if(elevator == ElevatorAtBottom.getInstance()){
				claw.open(.1);
			}else{
				elevator.drop(.1);
			}
		});
		
		controller.setGotoLevelAction((int i)->{
			int level = elevator.getLevel();
			if(level < i){
				elevator.lift(.1);
			}else if(level > i){
				elevator.drop(.1);
			}else{
			}
		});
		
		controller.setInterruptAction(()->{
			
		});
		
		controller.setPickupAction(()->{
			int level = elevator.getLevel();
			if(level > 1){
				elevator.drop(.1);
			}else if(level < 1){
				elevator.lift(.1);
			}else{
				
				if(elevator == ElevatorAtBottom.getInstance()){
					claw.close(.1);
					if(claw == ClawClosed.getInstance()){
						tray.retract(.1);
					}
				}else{
					claw.open(.1);
					elevator.drop(.1);
				}
			}
		});
		
		controller.setTrayExtendAction(()->{
			tray.extend(.1);
		});
		
		controller.setTrayRetractAction(()->{
			tray.retract(.1);
		});
	}

	/**
	 * Called in a loop during autonomous.s
	 */
	@Override public void autonomousPeriodic() {

	}

	/**
	 * Called in a loop during teleop. Used to update each Subsystem state.  Oh, also
	 * updates the operator controller state.
	 */
	@Override public void teleopPeriodic() {
		claw.update();
		elevator.update();
		tray.update();
		controller.update();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override public void testPeriodic() {

	}
}