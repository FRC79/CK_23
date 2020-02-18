/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.commands.drive_commands.DefaultDrive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveConstants;

import edu.wpi.first.wpilibj.AnalogInput; // for USS

import edu.wpi.first.wpilibj.Joystick; // for testing collision avoidence stuff

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

  private SmartDashboard m_number;

  // test joystick
  // private Joystick m_stick;
  // private final RobotContainer m_RobotContainer;

  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    // m_stick = m_RobotContainer.driver;
    SetUpEncoders();
  }
  //https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/blob/master/Java/VelocityClosedLoop/src/main/java/frc/robot/Robot.java 
  private void SetUpEncoders(){
    /* Factory Default all hardware to prevent unexpected behaviour */
    frontLeftMotor.configFactoryDefault();

    /* Config sensor used for Primary PID [Velocity] */
    frontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                                                Constants.DriveConstants.kPIDLoopIdx, 
                                                Constants.DriveConstants.kTimeoutMs);

    /**
    * Phase sensor accordingly. 
    * Positive Sensor Reading should match Green (blinking) Leds on Talon
    */
    frontLeftMotor.setSensorPhase(true);

    /* Config the peak and nominal outputs */
    frontLeftMotor.configNominalOutputForward(0, Constants.DriveConstants.kTimeoutMs);
    frontLeftMotor.configNominalOutputReverse(0, Constants.DriveConstants.kTimeoutMs);
    frontLeftMotor.configPeakOutputForward(1, Constants.DriveConstants.kTimeoutMs);
    frontLeftMotor.configPeakOutputReverse(-1, Constants.DriveConstants.kTimeoutMs);

    /* Config the Velocity closed loop gains in slot0 */
    frontLeftMotor.config_kF(Constants.DriveConstants.kPIDLoopIdx, Constants.DriveConstants.kGains_Velocit.kF, Constants.DriveConstants.kTimeoutMs);
    frontLeftMotor.config_kP(Constants.DriveConstants.kPIDLoopIdx, Constants.DriveConstants.kGains_Velocit.kP, Constants.DriveConstants.kTimeoutMs);
    frontLeftMotor.config_kI(Constants.DriveConstants.kPIDLoopIdx, Constants.DriveConstants.kGains_Velocit.kI, Constants.DriveConstants.kTimeoutMs);
    frontLeftMotor.config_kD(Constants.DriveConstants.kPIDLoopIdx, Constants.DriveConstants.kGains_Velocit.kD, Constants.DriveConstants.kTimeoutMs);



    /* Factory Default all hardware to prevent unexpected behaviour */
    frontRightMotor.configFactoryDefault();

    /* Config sensor used for Primary PID [Velocity] */
    frontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
                                                  Constants.DriveConstants.kPIDLoopIdx, 
                                                  Constants.DriveConstants.kTimeoutMs);

    /**
     * Phase sensor accordingly. 
     * Positive Sensor Reading should match Green (blinking) Leds on Talon
     */
    frontRightMotor.setSensorPhase(true);

    /* Config the peak and nominal outputs */
    frontRightMotor.configNominalOutputForward(0, Constants.DriveConstants.kTimeoutMs);
    frontRightMotor.configNominalOutputReverse(0, Constants.DriveConstants.kTimeoutMs);
    frontRightMotor.configPeakOutputForward(1, Constants.DriveConstants.kTimeoutMs);
    frontRightMotor.configPeakOutputReverse(-1, Constants.DriveConstants.kTimeoutMs);

    /* Config the Velocity closed loop gains in slot0 */
    frontRightMotor.config_kF(Constants.DriveConstants.kPIDLoopIdx, Constants.DriveConstants.kGains_Velocit.kF, Constants.DriveConstants.kTimeoutMs);
    frontRightMotor.config_kP(Constants.DriveConstants.kPIDLoopIdx, Constants.DriveConstants.kGains_Velocit.kP, Constants.DriveConstants.kTimeoutMs);
    frontRightMotor.config_kI(Constants.DriveConstants.kPIDLoopIdx, Constants.DriveConstants.kGains_Velocit.kI, Constants.DriveConstants.kTimeoutMs);
    frontRightMotor.config_kD(Constants.DriveConstants.kPIDLoopIdx, Constants.DriveConstants.kGains_Velocit.kD, Constants.DriveConstants.kTimeoutMs);
  }

  // USS reads between 25cm - 765cm   
  // https://www.andymark.com/products/ultrasonic-proximity-sensor-ez-mb1013-maxbotix
  public double GetDistance() {
    double sensorValue = m_US.getVoltage();
    final double scaleFactor = 1/(5./1024.); //scale converting voltage to distance
    double distance = 5*sensorValue*scaleFactor; //convert the voltage to distance
    return distance; 
  }

  public double calcStopingSpeed(){
    // // find velocity 
    double vel = 5; // in m/s
    // // find distance 
    double dist = GetDistance();
    m_number.putNumber("ultrasonic", dist);
    // // calculate time till impact
    double timeTillImpact = dist/vel;
    // // use time to determine new safe speed
    double safeSpeed = timeTillImpact;
    // // return new safe speed
     return safeSpeed;
  }

  public void arcadeDrive(double fwd, double rot) {
    /* Gamepad processing */

    double stopingSpeed = calcStopingSpeed();
    //System.out.print(stopingSpeed/260+"      ");

		double forward = Deadband(fwd);
    double turn = Deadband(rot);
    
    double minSpeed = Math.min(forward, Math.abs(stopingSpeed));

		/* Arcade Drive using PercentOutput along with Arbitrary Feed Forward supplied by turn */
    frontLeftMotor.set(ControlMode.PercentOutput, minSpeed, DemandType.ArbitraryFeedForward, turn);
    backLeftMotor.set(ControlMode.PercentOutput, minSpeed, DemandType.ArbitraryFeedForward, turn);
    
    frontRightMotor.set(ControlMode.PercentOutput, -minSpeed, DemandType.ArbitraryFeedForward, turn);
    backRightMotor.set(ControlMode.PercentOutput, -minSpeed, DemandType.ArbitraryFeedForward, turn);
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
    System.out.println(frontLeftMotor.getSelectedSensorVelocity(Constants.DriveConstants.kPIDLoopIdx));
  }

}

