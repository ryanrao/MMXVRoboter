package org.usfirst.frc.team20.robot.subsystem;

import org.usfirst.frc.team20.robot.Robot;
import org.usfirst.frc.team20.robot.Sensors;

public class ElevatorAtTop implements IElevator{

	@Override public void lift(double speed) {
		
	}

	@Override public void drop(double speed) {
		Robot.elevatorSCOne.set(speed);
		Robot.elevatorSCTwo.set(speed);
	}

	@Override public void update() {
		if(!Sensors.elevatorRaisedSwitch.get()){
			Robot.elevator = new ElevatorInMiddle();
		}
		
	}

}
