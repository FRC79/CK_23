/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.wheel_of_fortune;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.commands.wheel_of_fortune.WOFHelpers.WOFColors;
import frc.robot.subsystems.WheelOfFortune;

public class WOFHoldOnColor extends CommandBase {
  private final WheelOfFortune m_WheelOfFortune;
  private boolean isOnRightColor;

  /**
   * Creates a new WOFHoldOnColor.
   */
  public WOFHoldOnColor(WheelOfFortune subsystem) {
    m_WheelOfFortune = subsystem;
    addRequirements(m_WheelOfFortune);
  }


  private int findRightColor(){ // return the index of the color we want our color sensor to see
    String gameData;
    int colorID;
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
          //Blue case code
          colorID = 0;
          break;
        case 'G' :
          //Green case code
          colorID = 3;
          break;
        case 'R' :
          //Red case code
          colorID = 2;
          break;
        case 'Y' :
          //Yellow case code
          colorID = 1;
          break;
        default :
          //This is corrupt data
          colorID = -1;
          break;
      }
    } else {
      //Code for no data received yet
      colorID = -1;
    }
    return colorID;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int colorIndex = findRightColor();
    if(colorIndex == -1){
      // do nothing
      return;
    }
    WOFColors rightSensorColor = Constants.WOFConstants.wheelColors[colorIndex];
    Color sensorColor = m_WheelOfFortune.colorSensor.getColor(); // to set this to the output of the sensor

    isOnRightColor = WOFHelpers.guessColor(sensorColor) == rightSensorColor;
      m_WheelOfFortune.WOFmotor.set(ControlMode.PercentOutput, 1); // set WOF motor to 100% speed    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_WheelOfFortune.WOFmotor.set(ControlMode.PercentOutput, 0); // turn the WOF motor off
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isOnRightColor;
  }
}
