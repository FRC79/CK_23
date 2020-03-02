/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

import edu.wpi.first.wpilibj.AnalogInput; // for USS

//import edu.wpi.first.wpilibj.Joystick; // for testing collision avoidence stuff

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class DriveTrain extends SubsystemBase {
// The motors on the left side of the drive.
  private final TalonSRX frontLeftMotor = new TalonSRX(DriveConstants.LEFT_MOTOR1_PORT);
  private final VictorSPX backLeftMotor = new VictorSPX(DriveConstants.LEFT_MOTOR2_PORT);

  // The motors on the right side of the drive.
  private final TalonSRX frontRightMotor = new TalonSRX(DriveConstants.RIGHT_MOTOR1_PORT);
  private final VictorSPX backRightMotor = new VictorSPX(DriveConstants.RIGHT_MOTOR2_PORT);

  // ultrasonic sensors
  private final AnalogInput m_US_WALL = new AnalogInput(DriveConstants.USS_WALL);
  private final AnalogInput m_US_HOLE = new AnalogInput(DriveConstants.USS_HOLE);

   private double[] wallArray = new double[20]; // list of uss distances over a short period of time
   private double[] holeArray = new double[20];
	
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
    // config encoders
    frontLeftMotor.configFactoryDefault();
    frontRightMotor.configFactoryDefault();

    // set encoders to relative
    frontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    frontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  /** 
   * @return returns the velocity in m/s
   */
  public double getLeftEncoderVelocity(){
    int rawVelocity = frontLeftMotor.getSelectedSensorVelocity(); // encoder units per 100 ms
    int rawVelPerSecond = rawVelocity*10;
    double rotationsPerSecond = rawVelPerSecond/4096d;
    double velocity = rotationsPerSecond*DriveConstants.WHEEL_DIAMETER*Math.PI;
    return velocity;
  }
  /** 
   * @return returns the velocity in m/s
   */
  public double getRightEncoderVelocity(){
    int rawVelocity = frontRightMotor.getSelectedSensorVelocity(); // encoder units per 100 ms
    int rawVelPerSecond = rawVelocity*10;
    double rotationsPerSecond = rawVelPerSecond/4096d;
    double velocity = rotationsPerSecond*DriveConstants.WHEEL_DIAMETER*Math.PI;
    return velocity;
  }

	 
  // USS reads between 30cm - 765cm   
  // https://www.andymark.com/products/ultrasonic-proximity-sensor-ez-mb1013-maxbotix
  public double getUssDistanceWALL() {
    double sensorValue = m_US_WALL.getVoltage();
    final double scaleFactor = 1/(5./1024.); //scale converting voltage to distance
    double distance = (5/4)*sensorValue*scaleFactor; //convert the voltage to distance
    return distance; 
  }
  public double getUssDistanceHOLE() {
    double sensorValue = m_US_HOLE.getVoltage();
    final double scaleFactor = 1/(5./1024.); //scale converting voltage to distance
    double distance = (5/4)*sensorValue*scaleFactor; //convert the voltage to distance
    return distance; 
  }

  // public static int[] addX(int n, int arr[], double x) 
  // { 
  //     int i; 

  //     // create a new array of size n+1 
  //     int newarr[] = new int[n + 1]; 

  //     // insert the elements from 
  //     // the old array into the new array 
  //     // insert all elements till n 
  //     // then insert x at n+1 
  //     for (i = 0; i < n; i++) 
  //         newarr[i] = arr[i]; 

  //     newarr[n] = x; 

  //     return newarr; 
  // } 

  /**
   * called to shift every element down by 1,
   * calling this function will erase the data in element 0,
   * the final element will be left alone, it should be overided later
   * 
   * @param arr the array you want to shift
   * 
   * @return the shifted array
   */
  private int[] shiftArray(int[] arr){ // like a ziplock bag ;))))
    int i;
    for(i = 0; i>arr.length-1; i++){
      arr[i] = arr[i+1];
    }
    return arr;
  }

  // private double smoothUSSHOLE(){
  //   // shift the array
  //   holeArray = shiftArray(holeArray);
  //   // set the last element to current reading
  //   holeArray = addX(19, holeArray, getUssDistanceHOLE());
  //   // return 
  //   return -1.0;
  // }
  public double calcStopingSpeed(){
    // // find velocity 
    double vel = 5; // in m/s
    // // find distance 
    double dist = getUssDistanceWALL();
    m_number.putNumber("ultrasonic", dist); // drain bramage
    // // calculate time till impact
    double timeTillImpact = dist/vel;
    // // use time to determine new safe speed
    double safeSpeed = timeTillImpact;
    // // return new safe speed
     return safeSpeed;
  }

  public void arcadeDrive(double fwd, double rot) {
    /* Gamepad processing */ // game

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

  public void leftDrive(double speed){
    double fwd = Deadband(speed);
    frontLeftMotor.set(ControlMode.PercentOutput, fwd);
    backLeftMotor.set(ControlMode.PercentOutput, fwd);
  }

  public void rightDrive(double speed){
    double fwd = Deadband(speed);
    frontRightMotor.set(ControlMode.PercentOutput, fwd);
    backRightMotor.set(ControlMode.PercentOutput, fwd);
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
  
  private long lastTime = System.currentTimeMillis();
  private double totalDistanceLeft;
  private double totalDistanceRight;

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // add small steps of distance to the total
    long timeDifference = lastTime - System.currentTimeMillis();
    double advjVelocityLeft = getLeftEncoderVelocity();
    double advjVelocityRight = getRightEncoderVelocity();
    totalDistanceLeft+=timeDifference*advjVelocityLeft;
    totalDistanceRight+=timeDifference*advjVelocityRight;
    lastTime = System.currentTimeMillis();
  }

  public void clearDistance(){
    totalDistanceLeft = 0;
    totalDistanceRight = 0;
  }

  public double getLeftEncoderDist(){
    return totalDistanceLeft;
  }
  public double getRightEncoderDist(){
    return totalDistanceRight;
  }
  

}

