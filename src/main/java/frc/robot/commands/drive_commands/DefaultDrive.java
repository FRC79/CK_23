/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;

public class DefaultDrive extends CommandBase {

  private final DriveTrain m_DriveTrain;
  private final RobotContainer m_RobotContainer;

  /**
   * Creates a new DefaultDrive.
   */
  public DefaultDrive(DriveTrain subsystem, RobotContainer roboContainer) {
    // Use addRequirements() here to declare subsystem dependencies.
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
    double forward = -1.0  * m_RobotContainer.driver.getY(); //gets joystick values to move forward and back
    //"-" makes forward	go forward on the joystick
    double turn =  1.0 * m_RobotContainer.driver.getX();    //turns left and right
    m_DriveTrain.arcadeDrive(forward, turn); //passes joystick values into drive mechanism
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
