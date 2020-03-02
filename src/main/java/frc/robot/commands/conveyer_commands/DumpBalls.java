/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.conveyer_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.BallConveyer;

public class DumpBalls extends CommandBase {
  private final BallConveyer m_BallConveyer;
  /**
   * Creates a new DumpBalls.
   */
  public DumpBalls(BallConveyer ballConveyer) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_BallConveyer = ballConveyer;
    addRequirements(m_BallConveyer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_BallConveyer.setIntakeMotors(1);
    m_BallConveyer.setClipLowMotor(1);
    m_BallConveyer.setClipHighMotor(1);
    m_BallConveyer.setDumpMotors(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_BallConveyer.setIntakeMotors(0);
    m_BallConveyer.setClipLowMotor(0);
    m_BallConveyer.setClipHighMotor(0);
    m_BallConveyer.setDumpMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
