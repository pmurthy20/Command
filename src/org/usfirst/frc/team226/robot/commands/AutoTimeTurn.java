package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTimeTurn extends Command {

	private double m_seconds, m_LPower, m_RPower;
	private boolean m_left;
	
    public AutoTimeTurn(double seconds, double LPower, double RPower, boolean left_turn) {
        
    	m_seconds = seconds;
    	m_LPower = LPower;
    	m_RPower = RPower;
    	m_left = left_turn;
    	// Use requires() here to declare subsystem dependencies
    	
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(m_left == true) {
    		Robot.drivetrain.setLeftRight(-m_LPower, m_RPower);
    		
    	} else {
    		Robot.drivetrain.setLeftRight(m_LPower, -m_RPower);
    		
    	}
    	setTimeout(m_seconds);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setLeftRight(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
