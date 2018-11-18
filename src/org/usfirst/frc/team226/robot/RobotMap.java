/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team226.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static  int PCM = 12;
	public static int ps_intake_in = (0);
	public static int ps_intake_out = (1);
	public static int DT_FL = (5);
	//DT Talon Front right
	public static int DT_FR = (4);
	//DT Talon Back left
	public static int DT_BL = (6);
	//DT Talon Back right
	public static int DT_BR = (3);
	//Intake Motor
	public static int Intake = (2);
	public static int Kicker = (1);
	
	
	/*
	//VALUES FOR POWERUP-1
	//DT Talon Front left
	public static int DT_FL = (17);
	//DT Talon Front right
	public static int DT_FR = (16);
	//DT Talon Back left
	public static int DT_BL = (18);
	//DT Talon Back right
	public static int DT_BR = (15);
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	 */
	 
}
