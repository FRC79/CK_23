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
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class BallConveyer extends SubsystemBase {
  // intake talons
  private final TalonSRX intakeMotor = new TalonSRX(ConveyerConstants.INTAKE);
  //private final TalonSRX intakeRightMotor = new TalonSRX(ConveyerConstants.INTAKE_RIGHT);
  // ball clip talons
  private final TalonSRX clipLowMotor = new TalonSRX(ConveyerConstants.CLIP_LOW);
  private final TalonSRX clipHighMotor = new TalonSRX(ConveyerConstants.CLIP_HIGH);
  // ball dump talons
  private final TalonSRX dumpMotor = new TalonSRX(ConveyerConstants.DUMP);
  //private final TalonSRX dumpRightMotor = new TalonSRX(ConveyerConstants.DUMP_RIGHT);

  /**
   * Creates a new BallConveyer.
   */
  public BallConveyer() {

  }

  public void setIntakeMotors(double speed){
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setClipLowMotor(double speed){
    clipLowMotor.set(ControlMode.PercentOutput, speed);
  }
  public void setClipHighMotor(double speed){
    clipHighMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setDumpMotors(double speed){
    dumpMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
