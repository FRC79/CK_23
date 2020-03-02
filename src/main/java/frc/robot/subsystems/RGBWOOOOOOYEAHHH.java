/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants.RGBConstants;

public class RGBWOOOOOOYEAHHH extends SubsystemBase {

  public PWM redLED;
  public PWM blueLED;
  public PWM greenLED;

  //private SmartDashboard m_dash;
  /**
   * Creates a new RGBWOOOOOOYEAHHH.
   */
  public RGBWOOOOOOYEAHHH() {
    redLED = new PWM(RGBConstants.RED_LED);
    blueLED = new PWM(RGBConstants.BLUE_LED);
    greenLED = new PWM(RGBConstants.GREEN_LED);
  }

  // private double IntToPWN(int input){
  //   if(input > 255){ input = 255;}
  //   if(input < 0){ input = 0;}
    
  //   return input/255;
  // }

  /**
   * 
   * sets the rgb lights to a given red green blue values
   * 
   * @param red   red component 0-1
   * @param green  blue component 0-1
   * @param blue  green component 0-1
   */

  public void SetRGBColor(int red, int green, int blue){
    redLED.setRaw(Math.abs(red*255));
    greenLED.setRaw(Math.abs(green*255));
    blueLED.setRaw(Math.abs(blue*255));

    // m_dash.putNumber("red", redLED.getRaw());
    // m_dash.putNumber("green", greenLED.getRaw());
    // m_dash.putNumber("blue", blueLED.getRaw());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}