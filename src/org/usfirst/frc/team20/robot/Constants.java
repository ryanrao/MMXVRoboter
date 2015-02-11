package org.usfirst.frc.team20.robot;

public class Constants {
	
	public static final double ELEVATOR_HEIGHT = 1;
	
	public static final int ELEVATOR_MAX_LEVEL = 8;
	
	public static class Input{
		public static final int EVENT_BUTTON_PRESSED= 0xFE,
			EVENT_BUTTON_RELEASED= 0xFF;
		
		public static final int BUTTON_ELEVATOR_BOTTOM = 0,
			BUTTON_ELEVATOR_LEVEL_1 = 1,
			BUTTON_ELEVATOR_LEVEL_2 = 2, 
			BUTTON_ELEVATOR_LEVEL_3 = 3,
			BUTTON_ELEVATOR_LEVEL_4 = 4,
			BUTTON_ELEVATOR_LEVEL_5 = 5,
			BUTTON_ELEVATOR_LEVEL_6 = 6;
		
		public static final int BUTTON_TRAY_EXTEND = 7,
			BUTTON_TRAY_RETRACT = 8;
		
		public static final int BUTTON_CLAW_OPEN = 9,
			BUTTON_CLAW_CLOSE = 10;
		
		public static final int BUTTON_INTERRUPT = 11;
		public static final int BUTTON_DROP = 12;
		public static final int BUTTON_PICKUP = 13;
	}
}
