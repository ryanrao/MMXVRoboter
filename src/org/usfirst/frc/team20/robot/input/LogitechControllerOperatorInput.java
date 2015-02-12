package org.usfirst.frc.team20.robot.input;

import java.util.ArrayDeque;
import java.util.Deque;

import org.usfirst.frc.team20.robot.Constants;
import org.usfirst.frc.team20.robot.Utils;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechControllerOperatorInput implements OperatorInput {

	private Joystick gamepad;
	private int level;
	private Deque<Integer> events;
	private boolean levelUpPressed;
	private boolean levelDownPressed;

	public LogitechControllerOperatorInput(int gamepad) {
		this.gamepad = new Joystick(gamepad);
		events = new ArrayDeque<>();
		level = 0;
	}

	@Override public void run() {
		if (!Utils.epsilonEquals(gamepad.getRawAxis(6), 0, .1f)) {
			if (gamepad.getRawAxis(6) > .5) {
				levelDownPressed = false;
				if (!levelUpPressed) {
					levelUpPressed = true;
					createLevelUpEvent();
				}
			} else {
				levelUpPressed = false;
				if (!levelDownPressed) {
					levelDownPressed = true;
					createLevelDownEvent();
				}
			}
		} else {
			levelUpPressed = false;
			levelDownPressed = false;
		}
		if (gamepad.getRawButton(11)) {
			pack(Constants.Input.BUTTON_TRAY_RETRACT,
				Constants.Input.EVENT_BUTTON_PRESSED);
		} else if (gamepad.getRawButton(12)) {
			pack(Constants.Input.BUTTON_TRAY_EXTEND,
				Constants.Input.EVENT_BUTTON_PRESSED);
		}
		if (gamepad.getRawButton(10)) {
			pack(Constants.Input.BUTTON_CLAW_CLOSE,
				Constants.Input.EVENT_BUTTON_PRESSED);
		} else if (gamepad.getRawButton(11)) {
			pack(Constants.Input.BUTTON_CLAW_OPEN,
				Constants.Input.EVENT_BUTTON_PRESSED);
		}
	}

	private void createLevelUpEvent() {
		switch (level) {
		case 0:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_1,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		case 1:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_2,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		case 2:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_3,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		case 3:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_4,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		case 4:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_5,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		case 5:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_6,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		}
	}

	private void createLevelDownEvent() {
		switch (level) {
		case 1:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_BOTTOM,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		case 2:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_1,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		case 3:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_2,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		case 4:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_3,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		case 5:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_4,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		case 6:
			events.add(pack(Constants.Input.BUTTON_ELEVATOR_LEVEL_5,
				Constants.Input.EVENT_BUTTON_PRESSED));
			break;
		}
	}

	@Override public int getEvent() {
		if (events.size() != 0)
			return events.remove();
		return 0;
	}

	@Override public boolean isChanged() {
		return true;
	}

	private int pack(byte source, byte event) {
		return (source << 8) | event;
	}

}
