/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.rgb_xd;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RGBWOOOOOOYEAHHH;
import frc.robot.subsystems.WheelOfFortune;

public class WOF_ColorSync extends CommandBase {
  private Color m_sensorColor;
  private RGBWOOOOOOYEAHHH m_rgb;
  private WheelOfFortune m_wof;
  /**
   * Creates a new WOF_ColorSync.
   */
  public WOF_ColorSync(RGBWOOOOOOYEAHHH rgbsub, WheelOfFortune wofsub) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_wof = wofsub;
    m_rgb = rgbsub;
    addRequirements(m_rgb);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_sensorColor = m_wof.colorSensor.getColor();
    m_rgb.SetRGBColor(m_sensorColor.red, m_sensorColor.green, m_sensorColor.blue);  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
