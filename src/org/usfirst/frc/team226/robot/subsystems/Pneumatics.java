package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Compressor compressor = new Compressor(RobotMap.PCM);
	
	public void openCompressor() {
		compressor.setClosedLoopControl(true);
		compressor.start();
	}
	
	public void closedCompressor() {
		compressor.setClosedLoopControl(false);
		compressor.stop();
	}
	
	public Pneumatics() {
		compressor.start();
	}
	
	private DoubleSolenoid intake = new DoubleSolenoid(RobotMap.PCM, RobotMap.ps_intake_in, RobotMap.ps_intake_out);
	
	private DoubleSolenoid.Value intake_state = DoubleSolenoid.Value.kForward;
	
	public void shiftIntake() {
		if (intake_state == DoubleSolenoid.Value.kForward) {
			intake_state = DoubleSolenoid.Value.kReverse;
		} else {
			intake_state = DoubleSolenoid.Value.kForward;
		}
		intake.set(intake_state);
		System.out.println(intake_state);
	}
	public void initDefaultCommand() {
       
    }
}

