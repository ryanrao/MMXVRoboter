package org.usfirst.frc.team20.robot.subsystem;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;

public class ElevatorAtBottom implements IElevator{

	@Override public void lift(double speed) {
		Robot.elevatorSCOne.set(speed);
		Robot.elevatorSCTwo.set(speed);
	}

	@Override public void drop(double speed) {
		
	}

	@Override public void update() {
		if(!Sensors.elevatorLoweredSwitch.get()){
			Robot.elevator = new ElevatorInMiddle();
		}
	}

}
