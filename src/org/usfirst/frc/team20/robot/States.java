package org.usfirst.frc.team20.robot;

import org.usfirst.frc.team20.robot.subsystem.IClaw;
import org.usfirst.frc.team20.robot.subsystem.IElevator;
import org.usfirst.frc.team20.robot.subsystem.ITray;
import org.usfirst.frc.team20.robot.subsystem.claw.ClawClosed;
import org.usfirst.frc.team20.robot.subsystem.claw.ClawOpen;
import org.usfirst.frc.team20.robot.subsystem.elevator.ElevatorAtBottom;
import org.usfirst.frc.team20.robot.subsystem.elevator.ElevatorAtLevel;
import org.usfirst.frc.team20.robot.subsystem.elevator.ElevatorAtTop;
import org.usfirst.frc.team20.robot.subsystem.tray.TrayExtended;
import org.usfirst.frc.team20.robot.subsystem.tray.TrayRetracted;

public class States {

	public static IElevator ElevatorAtBottom = new ElevatorAtBottom(),
		ElevatorAtTop = new ElevatorAtTop(),
		ElevatorAtLevel1 = new ElevatorAtLevel(1),
		ElevatorAtLevel2 = new ElevatorAtLevel(2),
		ElevatorAtLevel3 = new ElevatorAtLevel(3),
		ElevatorAtLevel4 = new ElevatorAtLevel(4),
		ElevatorAtLevel5 = new ElevatorAtLevel(5),
		ElevatorAtLevel6 = new ElevatorAtLevel(6);

	public static IClaw ClawClosed = new ClawClosed(),
		ClawOpen = new ClawOpen();

	public static ITray TrayExtended = new TrayExtended(),
		TrayRetracted = new TrayRetracted();

}
