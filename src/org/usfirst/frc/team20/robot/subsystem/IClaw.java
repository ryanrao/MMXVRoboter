package org.usfirst.frc.team20.robot.subsystem;
/**
 *
 * @author Jared Gentner
 */
public interface IClaw{
    
    /**
     * Open the claw at some fixed rate.  Implementations should
     * be similar to states, in that if the claw is fully open (in
     * the 'open claw' state), the open() method should do nothing.
     */
    void open();

    /**
     * Close the claw at some fixed rate.  Implementations should
     * be similar to states, in that if the claw is fully closed (in
     * the 'closed claw' state), the close() method should do nothing.
     */
    void close();
}
