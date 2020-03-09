/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.wheel_of_fortune;

import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants.WOFConstants;
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

  public enum WOFColors{
    YELLOW("Y"),
    GREEN("G"),
    BLUE("B"),
    RED("R");
    private final String WOFString;

    private WOFColors(String WOFString){
      this.WOFString = WOFString;
    }
  }

  public static WOFColors guessColor(Color color){


    double distRed = aproximateColor(color, WOFConstants.RED);
    double distBlue = aproximateColor(color, WOFConstants.BLUE);
    double distGreen = aproximateColor(color, WOFConstants.GREEN);
    double distYellow = aproximateColor(color, WOFConstants.YELLOW);

    WOFColors guess = WOFColors.RED;
    double guessDist = distRed;

    if(distBlue < guessDist){
      guess = WOFColors.BLUE;
      guessDist = distBlue;
    }
    if(distGreen < guessDist){
      guess = WOFColors.GREEN;
      guessDist = distGreen;
    }
    if(distYellow < guessDist){
      guess = WOFColors.YELLOW;
      guessDist = distYellow;
    }

    return guess;
  }
}
