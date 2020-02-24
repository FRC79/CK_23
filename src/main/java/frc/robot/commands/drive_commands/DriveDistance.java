/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class DriveDistance extends CommandBase {
  private final DriveTrain m_DriveTrain;
  private final RobotContainer m_RobotContainer;
  private double leftDistToTravel;
  private double rightDistToTravel;
  private double m_speed;

  /**
   * Creates a new DriveDistance.
   */
  public DriveDistance(DriveTrain subsystem, RobotContainer roboContainer, double leftDistance, double rightDistance, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    leftDistToTravel = leftDistance;
    rightDistToTravel = rightDistance;
    m_speed = speed;

    m_RobotContainer = roboContainer;
    m_DriveTrain = subsystem;
    addRequirements(m_DriveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_DriveTrain.getLeftEncoderDist() < leftDistToTravel){
      m_DriveTrain.leftDrive(m_speed);
    }else{
      m_DriveTrain.leftDrive(0);
    }
    
    if(m_DriveTrain.getRightEncoderDist() < rightDistToTravel){
      m_DriveTrain.rightDrive(m_speed);
    }else{
      m_DriveTrain.rightDrive(0);
    }
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
