package org.usfirst.frc.team20.robot.input;

public interface OperatorController {

	/*
	 * Java lamdbas suck, so this silly interface needs to be here. Thanks
	 * Obama.
	 */
	interface LevelAction {
		void perform(int level);
	}

	void setDropAction(Runnable action);

	void setTrayExtendAction(Runnable action);

	void setTrayRetractAction(Runnable action);

	void setPickupAction(Runnable action);

	void setInterruptAction(Runnable action);

	void setGotoLevelAction(LevelAction action);

	void setClawCloseAction(Runnable action);

	void setClawOpenAction(Runnable action);

	void update();
}
