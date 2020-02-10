/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ConveyerConstants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class BallConveyer extends SubsystemBase {
  // intake talons
  private final TalonSRX intakeLeftMotor = new TalonSRX(ConveyerConstants.INTAKE_LEFT);
  private final TalonSRX intakeRightMotor = new TalonSRX(ConveyerConstants.INTAKE_RIGHT);
  // ball clip talons
  private final TalonSRX clipLeftMotor = new TalonSRX(ConveyerConstants.CLIP_LEFT);
  private final TalonSRX clipRightMotor = new TalonSRX(ConveyerConstants.CLIP_RIGHT);
  // ball dump talons
  private final TalonSRX dumpLeftMotor = new TalonSRX(ConveyerConstants.DUMP_LEFT);
  private final TalonSRX dumpRightMotor = new TalonSRX(ConveyerConstants.DUMP_RIGHT);

  /**
   * Creates a new BallConveyer.
   */
  public BallConveyer() {

  }

  public void setIntakeMotors(double speed){
    intakeLeftMotor.set(ControlMode.PercentOutput, speed);
    intakeRightMotor.set(ControlMode.PercentOutput, -speed);
  }

  public void setClipMotors(double speed){
    clipLeftMotor.set(ControlMode.PercentOutput, speed);
    clipRightMotor.set(ControlMode.PercentOutput, -speed);
  }

  public void setDumpMotors(double speed){
    dumpLeftMotor.set(ControlMode.PercentOutput, speed);
    dumpRightMotor.set(ControlMode.PercentOutput, -speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
