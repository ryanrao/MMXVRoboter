package org.usfirst.frc.team20.robot.subsystem;
/**
 *
 * @author Jared Gentner
 */
public interface ITray{

    /**
     * Extend the tray at some fixed rate.  Implementations should
     * be similar to states, in that if the tray is fully out (in
     * the 'tray out' state), the extend() method should do nothing.
     */
    void extend();

    /**
     * Retract the tray at some fixed rate.  Implementations should
     * be similar to states, in that if the tray is fully in (in
     * the 'tray in' state), the retract() method should do nothing.
     */
    void retract();
}
