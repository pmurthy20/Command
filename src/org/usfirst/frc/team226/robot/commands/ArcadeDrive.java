package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeDrive extends Command {

    public ArcadeDrive() {
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//Stick Drive
    	Robot.drivetrain.arcadeDrive(Robot.m_oi.driver.getLeftJoystick_Y(), Robot.m_oi.driver.getRightJoystick_X());
    	
    	//Trigger Drive
    	//Robot.drivetrain.arcadeDrive(Robot.m_oi.driver.getLeftTrigger(), Robot.m_oi.driver.getRightTrigger());
    	
    	
    	// FIX Robot.drivetrain.tankDrive(Robot.m_oi.driver.getLeftJoystick_Y(), Robot.m_oi.driver.getRightJoystick_Y());
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}