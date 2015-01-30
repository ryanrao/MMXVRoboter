
package org.usfirst.frc.team20.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	SpeedController frontLeft;
	SpeedController backLeft;
	SpeedController frontRight;
	SpeedController backRight;
	SpeedController clawLeft;
	SpeedController clawRight;
	SpeedController elevatorOne;
	SpeedController elevatorTwo;
	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//TODO actually assign real ports based on robot configuration
    			frontLeft = new CANTalon(0);
    			frontRight = new CANTalon(0);
    			backLeft = new CANTalon(0);
    			backRight = new CANTalon(0);
    			clawLeft = new CANTalon(0);
    			clawRight = new CANTalon(0);
    			elevatorOne = new CANTalon(0);
    			elevatorTwo = new CANTalon(0);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
