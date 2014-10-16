package edu.wpi.first.wpilibj.base.commands.drive;

import edu.wpi.first.wpilibj.superclasses.CommandRC;

/**
 * @author Sean Zammit
 */
public class CommandTimedMove extends CommandRC {
    
    double speed;
    
    public CommandTimedMove(int requiredSystem, double time, double sp, CommandRC com) {
        super(requiredSystem);
        setTimeout(time);
        speed = sp;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {        
        double rotation = 0;
                
        driver.driveFront.arcadeDrive(speed, rotation);
        driver.driveRear.arcadeDrive(speed, rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut(); 
    }
}