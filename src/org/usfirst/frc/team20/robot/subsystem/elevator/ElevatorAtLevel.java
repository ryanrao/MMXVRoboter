package org.usfirst.frc.team20.robot.subsystem.elevator;

import org.usfirst.frc.team20.robot.Robot;

/**
 * State representing an elevator that is in an unidentified position.
 * 
 * @author Sandra Wiedmann
 * @author Jared 'jarebear' Gentner <jargen3d@yahoo.com>
 *
 */
public class ElevatorAtLevel implements RobotElevator {

	private int level;

	public ElevatorAtLevel(int level) {
		this.level = level;
	}

	@Override public int getLevel() {
		return this.level;
	}

	/**
	 * Update the state of the elevator. Possible next states include
	 * ElevatorAtBottom and ElevatorAtTop.
	 */
	@Override public void update() {
		Robot.elevator = RobotElevator.getLevelState();
	}
}
