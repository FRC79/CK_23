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


    // multiply the diff in red so that we can tell similar RGBs like red and yellow apart
    double distS1red = (Math.pow( color1.red - color2.red,2)*10)+Math.pow( color1.blue - color2.blue,2)+Math.pow( color1.green - color2.green,2);
    double distred = Math.sqrt(distS1red);

    // multiply the diff in red so that we can tell similar RGBs like red and yellow apart
    double distS1blue = (Math.pow( color1.red - color2.red,2)*10)+Math.pow( color1.blue - color2.blue,2)+Math.pow( color1.green - color2.green,2);
    double distblue = Math.sqrt(distS1blue);

    // multiply the diff in red so that we can tell similar RGBs like red and yellow apart
    double distS1green = (Math.pow( color1.red - color2.red,2)*10)+Math.pow( color1.blue - color2.blue,2)+Math.pow( color1.green - color2.green,2);
    double distgreen = Math.sqrt(distS1green);

    // multiply the diff in red so that we can tell similar RGBs like red and yellow apart
    double distS1yellow = (Math.pow( color1.red - color2.red,2)*10)+Math.pow( color1.blue - color2.blue,2)+Math.pow( color1.green - color2.green,2);
    double distyellow = Math.sqrt(distS1yellow);

    // find the lowest diff 
    double lowestS1 = Math.min(distred, distblue);
    double lowestS2 = Math.min(distgreen, distyellow);
    double lowest = Math.min(lowestS1, lowestS2);

    if(distred == lowest){

    }else if(distblue == lowest){

    }else if(distgreen == lowest){

    }else if(distyellow == lowest){

    }

    return 5;
  }

}
