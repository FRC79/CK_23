/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.Constants.ClimbConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Victor;

public class Climb extends SubsystemBase {
  // motors for extending telescopes
  public Victor leftTelescopeMotor;
  public Victor rightTelescopeMotor;

  // motors that are part of the winch
  public Victor winchVictor1;
  public Victor winchVictor2;


  public Climb() {
    // if required configure the brakemode for the winch here
    leftTelescopeMotor = new Victor(ClimbConstants.LEFT_TELESCOPE);
    rightTelescopeMotor = new Victor(ClimbConstants.RIGHT_TELESCOPE);

    winchVictor1 = new Victor(ClimbConstants.WINCH_1);
    winchVictor2 = new Victor(ClimbConstants.WINCH_2);

  }

  public void SetTelescopeMotors(double speed){
    leftTelescopeMotor.set(speed);
    rightTelescopeMotor.set(speed);
  }

  public void SetWinchMotors(double speed){
    winchVictor1.set(speed);
    winchVictor2.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
