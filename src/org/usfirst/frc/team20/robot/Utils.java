package org.usfirst.frc.team20.robot;

public class Utils {
	
	public static boolean epsilonEquals(double eq1, double eq2, float epsilon){
		return ((eq1 - epsilon) < eq2 && (eq1 + epsilon) > eq2);
	}
	
	public static double limit(double voltage) {
		if (voltage >= 1)
			return 1;
		if (voltage <= -1)
			return -1;
		return voltage;
	}
}
