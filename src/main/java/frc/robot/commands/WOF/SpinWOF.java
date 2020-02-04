/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.WOF;

import com.revrobotics.ColorSensorV3.RawColor;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.WheelOfFortune;

public class SpinWOF extends CommandBase {
  
  private final WheelOfFortune m_WheelOfFortune;
  private RawColor sensorColor;
  private int rotations;


  public void colorChange(){// count the number of times we switch TO yellow.
    RawColor yellow = Constants.WOFConstants.YELLOW; // 

    boolean isYellow = WOFHelpers.aproximateColor(yellow, sensorColor) < Constants.WOFConstants.COLOR_THRESHOLD; // if the color sensor is close to pure yellow

    boolean temp = false; 
    if(isYellow != temp){ // switch temp back and forth, counting up one each time.
      if(isYellow){
        rotations += 1;
      }
      temp = isYellow;
    } 
  }

  /**
   * Creates a new SpinWOF.
   */
  public SpinWOF(WheelOfFortune subsystem) {
    m_WheelOfFortune = subsystem;
    addRequirements(m_WheelOfFortune);
  }




  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_WheelOfFortune.WOFmotor.set(0.5);     // spin up the WOF motor to 50%
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sensorColor = m_WheelOfFortune.colorSensor.getRawColor(); // to set this to the output of the sensor
    colorChange();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_WheelOfFortune.WOFmotor.set(0);// turn off the WOF motor
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // once we have seen yellow 7 times (spun 3.25 times) 
    return rotations >= 7;
  }
}
