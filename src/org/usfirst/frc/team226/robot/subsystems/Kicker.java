package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.Robot;
import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.EndKicker;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Kicker extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	TalonSRX kicker = new TalonSRX(RobotMap.Kicker);
	
	public void initDefaultCommand() {
		setDefaultCommand(new EndKicker());
    }
	
	
	public void windKicker() {
		if (Robot.m_oi.driver.getAButtonPressed()) {
			kicker.set(ControlMode.PercentOutput, 1);
		} else {
			kicker.set(ControlMode.PercentOutput, 0);
		}
		
		
	}
	
	public void endKicker() {
		kicker.set(ControlMode.PercentOutput, 0);
		
	}
	
    
}

