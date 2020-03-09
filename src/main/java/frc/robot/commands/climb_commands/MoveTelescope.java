/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climb_commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climb;

public class MoveTelescope extends CommandBase {
  private Climb m_climb;
  private RobotContainer m_container;

  /**
   * Creates a new MoveTelescope.
   */
  public MoveTelescope(Climb subsystem) {
    m_climb = subsystem;
    addRequirements(m_climb);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftY = m_container.operator.getY(Hand.kLeft);
    double rightY = m_container.operator.getY(Hand.kRight);
    m_climb.SetWinchMotors(-leftY);
    m_climb.SetTelescopeMotor(rightY);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_climb.SetTelescopeMotor(0);
    m_climb.SetWinchMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
