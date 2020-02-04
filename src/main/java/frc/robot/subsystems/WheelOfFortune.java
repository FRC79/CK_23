/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.Constants.WOFConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Victor;

public class WheelOfFortune extends SubsystemBase {
  // piston or soulinoid here
  public DoubleSolenoid WOFPiston;
  // motor(victor)
  public Victor WOFmotor;
  // color sensor
  public I2C.Port i2cPort;
  public ColorSensorV3 colorSensor; 


  public WheelOfFortune(){
    WOFPiston = new DoubleSolenoid(WOFConstants.PISTONOUT, WOFConstants.PISTONIN);
    WOFmotor = new Victor(WOFConstants.WOFMOTOR);
    i2cPort =  I2C.Port.kOnboard;
    colorSensor = new ColorSensorV3(i2cPort);
  }

  public void retract() {    // retract piston
    WOFPiston.set(DoubleSolenoid.Value.kReverse);
  }

  public void extend() {    // extend piston
    WOFPiston.set(DoubleSolenoid.Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
