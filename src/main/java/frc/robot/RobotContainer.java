/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


import frc.robot.commands.ExampleCommand;
import frc.robot.commands.conveyer_commands.*;
import frc.robot.commands.wheel_of_fortune.*;
import frc.robot.commands.climb_commands.*;

import frc.robot.subsystems.BallConveyer;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.RGBWOOOOOOYEAHHH;
import frc.robot.subsystems.WheelOfFortune;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final WheelOfFortune m_WheelOfFortune = new WheelOfFortune();
  private final BallConveyer m_BallConveyer = new BallConveyer();
  private final Climb m_Climb = new Climb();
  //private final RGBWOOOOOOYEAHHH m_rgb = new RGBWOOOOOOYEAHHH();


  SendableChooser<Command> m_chooser = new SendableChooser<>(); // allows the drivers to choose auto mode in driver station.

  // joysticks
  public Joystick driver = new Joystick(Constants.OIConstants.DRIVER);
  public GenericHID operator = new Joystick(Constants.OIConstants.OPERATOR);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // driver buttons
      // ball conveyer
      new JoystickButton(driver, Constants.OIConstants.INTAKE_ON) // turn on intake
        .whenPressed(new IntakeBalls(m_BallConveyer));
      new JoystickButton(driver, Constants.OIConstants.INTAKE_OFF) // turn off intake
        .whenReleased(new StopIntake(m_BallConveyer));
      new JoystickButton(driver, Constants.OIConstants.DUMP_ON) // turn on dumper
        .whenPressed(new DumpBalls(m_BallConveyer));
      new JoystickButton(driver, Constants.OIConstants.DUMP_OFF) // turn off dumper
        .whenReleased(new StopDump(m_BallConveyer));

    // operatior buttons
      //Climb buttons
      new JoystickButton(operator, Constants.OIConstants.MOVE_TELESCOPE) // move telescope
        .whileHeld(new MoveTelescope(m_Climb));
        
      // WOF
      new JoystickButton(operator, Constants.OIConstants.EXTEND_WOF) // extend
        .whenPressed(new ExtendWOF(m_WheelOfFortune));
      new JoystickButton(operator, Constants.OIConstants.RETRACT_WOF) // retract
        .whenPressed(new RetractWOF(m_WheelOfFortune));
      new JoystickButton(operator, Constants.OIConstants.SPIN_WOF) // spin 3 times
        .whenPressed(new SpinWOF(m_WheelOfFortune));
      new JoystickButton(operator, Constants.OIConstants.HOLD_WOF) // hold on color
        .whenPressed(new WOFHoldOnColor(m_WheelOfFortune));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
