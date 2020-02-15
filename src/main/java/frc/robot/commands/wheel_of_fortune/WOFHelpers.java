/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.wheel_of_fortune;

import edu.wpi.first.wpilibj.util.Color;
/**
 * Add your docs here.
 */
public class WOFHelpers {

    public static double aproximateColor(Color color1, Color color2){ // just returns the euclidean distance between a given color and the sensor's color

    // we multiply the diff in red so that we can tell similar RGBs like red and yellow apart
    double distS1 = (Math.pow( color1.red - color2.red,2)*10)+Math.pow( color1.blue - color2.blue,2)+Math.pow( color1.green - color2.green,2);
    double distS2 = Math.sqrt(distS1);

    return distS2;
  }

}
