package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.Robot;
import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.Control_Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX intake = new TalonSRX(RobotMap.Intake);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Control_Intake());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Intake() {
    	intake.setInverted(false);
    }
    private double m_in, m_out, m_total;
    public void driveIntake(double in, double out) {
    	
    	m_in = in;
    	m_out = -out;
    	m_total = m_in + m_out; 
    	intake.set(ControlMode.PercentOutput, m_total);
    	
    }
    

    
    public void neutralOutput() {
    	intake.neutralOutput();
    }
}

