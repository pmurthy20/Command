package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.Constants;
import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.ArcadeDrive;
import org.usfirst.frc.team226.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public TalonSRX DT_FL = new TalonSRX(RobotMap.DT_FL);
	public TalonSRX DT_FR = new TalonSRX(RobotMap.DT_FR);
	public TalonSRX DT_BL = new TalonSRX(RobotMap.DT_BL);
	public TalonSRX DT_BR = new TalonSRX(RobotMap.DT_BR);
	
	public DriveTrain() {
		
		//Follower Talons
		DT_BL.follow(DT_FL);
		DT_BR.follow(DT_FR);
		
		//Current Limits
		DT_FL.configContinuousCurrentLimit(Constants.DT_CURRENT_LIMIT, Constants.DT_CURRENT_TIMEOUT);
		DT_FR.configContinuousCurrentLimit(Constants.DT_CURRENT_LIMIT, Constants.DT_CURRENT_TIMEOUT);
		DT_BL.configContinuousCurrentLimit(Constants.DT_CURRENT_LIMIT, Constants.DT_CURRENT_TIMEOUT);
		DT_BR.configContinuousCurrentLimit(Constants.DT_CURRENT_LIMIT, Constants.DT_CURRENT_TIMEOUT);
		
		DT_FL.enableCurrentLimit(Constants.DT_CURRENT_ENABLE);
		DT_FR.enableCurrentLimit(Constants.DT_CURRENT_ENABLE);
		DT_BL.enableCurrentLimit(Constants.DT_CURRENT_ENABLE);
		DT_BR.enableCurrentLimit(Constants.DT_CURRENT_ENABLE);
	
		//Invert Motors
		DT_FR.setInverted(true);
		DT_FL.setInverted(true);
		DT_BR.setInverted(true);
		DT_BL.setInverted(true);
		
		//Voltage Ramps
		DT_FL.configOpenloopRamp(Constants.DT_VOLTAGE_RAMP, Constants.DT_CURRENT_TIMEOUT);
		DT_FR.configOpenloopRamp(Constants.DT_VOLTAGE_RAMP, Constants.DT_CURRENT_TIMEOUT);
		DT_BL.configOpenloopRamp(Constants.DT_VOLTAGE_RAMP, Constants.DT_CURRENT_TIMEOUT);
		DT_BR.configOpenloopRamp(Constants.DT_VOLTAGE_RAMP, Constants.DT_CURRENT_TIMEOUT);
		
	}
	
	 public void setLeftRight(double LPower, double RPower) {
	    	DT_FL.set(ControlMode.PercentOutput, LPower);
	    	DT_FR.set(ControlMode.PercentOutput, RPower);
	    	
	    }

    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    //Not using this 
    public void tankDrive(double leftJoystick_Y, double rightJoystick_Y) {
		// TODO Auto-generated method stub
		DT_FL.set(ControlMode.PercentOutput, leftJoystick_Y);
		DT_FR.set(ControlMode.PercentOutput, rightJoystick_Y);
	}
   
    public void arcadeDrive(double moveValue, double rotateValue) {
		double leftMotorSpeed;
		double rightMotorSpeed;

		// Square inputs
		moveValue = Math.copySign(moveValue * moveValue, moveValue);
		rotateValue = Math.copySign(rotateValue * rotateValue, rotateValue);

		if (rotateValue > 0.0) {
			if (moveValue > 0.0) {
				leftMotorSpeed = rotateValue - moveValue;
				rightMotorSpeed = Math.max(rotateValue, moveValue);
			} else {
				leftMotorSpeed = Math.max(rotateValue, -moveValue);
				rightMotorSpeed = rotateValue + moveValue;
			}
		} else {
			if (moveValue > 0.0) {
				leftMotorSpeed = -Math.max(-rotateValue, moveValue);
				rightMotorSpeed = rotateValue + moveValue;
			} else {
				leftMotorSpeed = rotateValue - moveValue;
				rightMotorSpeed = -Math.max(-rotateValue, -moveValue);
			}
		}

		setLeftRight(leftMotorSpeed, rightMotorSpeed);
		
		SmartDashboard.putNumber("Left Current:", DT_FL.getOutputCurrent());
		SmartDashboard.putNumber("Right Current:", DT_FR.getOutputCurrent());
		SmartDashboard.putNumber("Total Current:", DT_FR.getOutputCurrent() + DT_FL.getOutputCurrent());
	}

	
   
	

	

	
}

