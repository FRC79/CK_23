/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive_commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class LeaveAuto extends SequentialCommandGroup {
  /**
   * Creates a new LeaveAuto.
   */
  public LeaveAuto(DriveTrain subsystem) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      // back up a bit
      new DriveTime( subsystem, -0.5, 0, 1),
      // turn our back to the wall
      new DriveTime( subsystem, 0, 0.5, 1),
      // drive backwards to get out of people's way
      new DriveTime( subsystem, -1, 0, 1)
    );
    
  }
}
