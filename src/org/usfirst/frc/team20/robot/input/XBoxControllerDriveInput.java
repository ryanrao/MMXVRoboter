package org.usfirst.frc.team20.robot.input;

import org.usfirst.frc.team20.robot.Utils;

import edu.wpi.first.wpilibj.Joystick;


public class XBoxControllerDriveInput implements DriveInput {

	private Joystick controller;
	
	public XBoxControllerDriveInput(int slot){
		this.controller = new Joystick(slot);
	}
	
	@Override public double getForward() {
		return -controller.getRawAxis(1);
	}

	@Override public double getLateral() {
		return controller.getRawAxis(0);
	}

	@Override public double getTurn() {
		double turn = -controller.getRawAxis(3) 
			+ controller.getRawAxis(2)
			+ controller.getRawAxis(4);
		return Utils.limit(turn);
	}
}
