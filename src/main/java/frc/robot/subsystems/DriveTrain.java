/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

import edu.wpi.first.wpilibj.AnalogInput; // for USS

// import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class DriveTrain extends SubsystemBase {
  // The motors on the left side of the drive.
  private final TalonSRX frontLeftMotor = new TalonSRX(DriveConstants.LEFT_MOTOR1_PORT);
  private final TalonSRX backLeftMotor = new TalonSRX(DriveConstants.LEFT_MOTOR2_PORT);

  // The motors on the right side of the drive.
  private final TalonSRX frontRightMotor = new TalonSRX(DriveConstants.RIGHT_MOTOR1_PORT);
  private final TalonSRX backRightMotor = new TalonSRX(DriveConstants.RIGHT_MOTOR2_PORT);

  // ultrasonic sensors
  private final AnalogInput m_US = new AnalogInput(DriveConstants.USS_PORT);
	
  // encoders

  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
  }
	 
  // USS reads between 25cm - 765cm   
  // https://www.andymark.com/products/ultrasonic-proximity-sensor-ez0-mb1200-maxbotix
  public double GetDistance() {
    double sensorValue = m_US.getVoltage();
    final double scaleFactor = 1/(5./1024.); //scale converting voltage to distance
    double distance = 5*sensorValue*scaleFactor; //convert the voltage to distance
    return distance; 
  }
	
  public void arcadeDrive(double fwd, double rot) {
    System.out.print("arcade drive");
    /* Gamepad processing */
		double forward = Deadband(fwd);
		double turn = Deadband(rot);

		/* Arcade Drive using PercentOutput along with Arbitrary Feed Forward supplied by turn */
    frontLeftMotor.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, turn);
    backLeftMotor.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, turn);
    
    frontRightMotor.set(ControlMode.PercentOutput, -forward, DemandType.ArbitraryFeedForward, turn);
    backRightMotor.set(ControlMode.PercentOutput, -forward, DemandType.ArbitraryFeedForward, turn);
  }
  double Deadband(double value) {
		/* Upper deadband */
		if (value >= +0.05) 
			return value;
		
		/* Lower deadband */
		if (value <= -0.05)
			return value;
		
		/* Outside deadband */
		return 0;
	}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}

