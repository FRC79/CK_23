/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveTime extends CommandBase {
  private DriveTrain m_drive;
  private long timeToFinish;
  private long stopTime;
  private double forward;
  private double rotation;
  /**
   * Creates a new DriveTime.
   */
  public DriveTime(DriveTrain subsystem, double fwd, double rot, long time) {
    timeToFinish = time;
    m_drive = subsystem;
    forward = fwd;
    rotation = rot;
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    stopTime = System.currentTimeMillis() + timeToFinish*1000;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(forward, rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() >= stopTime;
  }
}
