package org.usfirst.frc.team20.robot.subsystem;
/**
 *
 * @author Jared Gentner
 */
public interface IDrivebase{
    
    /**
     * This method should use some set of inputs to drive the robot.
     * A struct of inputs driveInputs can be found in the Robot class,
     * and will be updated each cycle either by an auto mode or by
     * a controller.
     */
    void drive();
}
