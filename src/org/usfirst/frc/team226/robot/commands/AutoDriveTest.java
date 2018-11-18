package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveTest extends CommandGroup {

	
	
    public AutoDriveTest() {
    	

    	addSequential(new AutoTimeDrive(7));
    	addSequential(new Wait(5));
    	addSequential(new AutoTimeTurn(7, 1, 1, true));
    	
;    	
 
    }
}