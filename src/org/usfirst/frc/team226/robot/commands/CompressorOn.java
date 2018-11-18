package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;


import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CompressorOn extends InstantCommand {

    public CompressorOn() {
    	requires(Robot.pneumatics);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.pneumatics.openCompressor();
    }

 
}
