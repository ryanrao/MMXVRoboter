package org.usfirst.frc.team20.robot.input;

import static org.usfirst.frc.team20.robot.Constants.Input.*;
import org.usfirst.frc.team20.robot.Robot;

public class RobotOperatorController implements OperatorController {

	private Runnable dropAction, trayExtendAction, trayRetractAction,
		pickupAction, interruptAction, clawCloseAction, clawOpenAction;

	private LevelAction gotoAction;

	@Override public void setDropAction(Runnable action) {
		this.dropAction = action;
	}

	@Override public void setTrayExtendAction(Runnable action) {
		this.trayExtendAction = action;
	}

	@Override public void setTrayRetractAction(Runnable action) {
		this.trayRetractAction = action;
	}

	@Override public void setPickupAction(Runnable action) {
		this.pickupAction = action;
	}

	@Override public void setInterruptAction(Runnable action) {
		this.interruptAction = action;
	}

	@Override public void setGotoLevelAction(LevelAction action) {
		this.gotoAction = action;
	}

	@Override public void setClawCloseAction(Runnable action) {
		this.clawCloseAction = action;
	}

	@Override public void setClawOpenAction(Runnable action) {
		this.clawOpenAction = action;
	}

	@Override public void update() {
		if (Robot.operatorInput.isChanged()) {
			int eventData = Robot.operatorInput.getEvent();
			int source = eventData >> 8;
			int event = eventData & 0x00FF;
			if (event != EVENT_BUTTON_PRESSED) {
				return;
			}

			switch (source) {
			case BUTTON_ELEVATOR_BOTTOM:
				gotoAction.perform(0);
				break;
			case BUTTON_ELEVATOR_LEVEL_1:
				gotoAction.perform(1);
				break;
			case BUTTON_ELEVATOR_LEVEL_2:
				gotoAction.perform(2);
				break;
			case BUTTON_ELEVATOR_LEVEL_3:
				gotoAction.perform(3);
				break;
			case BUTTON_ELEVATOR_LEVEL_4:
				gotoAction.perform(4);
				break;
			case BUTTON_ELEVATOR_LEVEL_5:
				gotoAction.perform(5);
				break;
			case BUTTON_ELEVATOR_LEVEL_6:
				gotoAction.perform(1);
				break;
			case BUTTON_CLAW_OPEN:
				clawOpenAction.run();
				break;
			case BUTTON_CLAW_CLOSE:
				clawCloseAction.run();
				break;
			case BUTTON_TRAY_EXTEND:
				trayRetractAction.run();
				break;
			case BUTTON_TRAY_RETRACT:
				trayExtendAction.run();
				break;
			case BUTTON_INTERRUPT:
				interruptAction.run();
				break;
			case BUTTON_DROP:
				dropAction.run();
				break;
			case BUTTON_PICKUP:
				pickupAction.run();
				break;
			}
		}
	}
}
