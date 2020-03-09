/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive_commands;
import frc.robot.Constants.DriveConstants;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveDistance extends CommandBase {
  private final DriveTrain m_DriveTrain;

  private final double leftDistToTravel;
  private final double rightDistToTravel;
  private final double m_speed;

  private boolean leftFinished;
  private boolean rightFinished;
  private boolean bothFinished;

  private boolean timeout;
  private Long leftTime = null;
  private Long rightTime = null;
  private boolean hasStarted;


  /**
   * Creates a new DriveDistance.
   */
  public DriveDistance(DriveTrain subsystem, double leftDistance, double rightDistance, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    leftDistToTravel = leftDistance;
    rightDistToTravel = rightDistance;
    m_speed = speed;

    m_DriveTrain = subsystem;
    addRequirements(m_DriveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    leftFinished = false;
    rightFinished = false;
    m_DriveTrain.clearDistance();
  }

  private void driveTrainDist(){
    // if(leftDistToTravel > 0){
    //   if(m_DriveTrain.getLeftEncoderDist() < leftDistToTravel){
    //     m_DriveTrain.leftDrive(m_speed);
    //   }else{
    //     m_DriveTrain.leftDrive(0);
    //     leftFinished = true;
    //   }
    // }else{
    //   if(m_DriveTrain.getLeftEncoderDist() > leftDistToTravel){
    //     m_DriveTrain.leftDrive(-m_speed);
    //   }else{
    //     m_DriveTrain.leftDrive(0);
    //     leftFinished = true;
    //   }
    // }

    // if(rightDistToTravel > 0){
    //   if(m_DriveTrain.getRightEncoderDist() < rightDistToTravel){
    //     m_DriveTrain.rightDrive(m_speed);
    //   }else{
    //     m_DriveTrain.rightDrive(0);

    //     rightFinished = true;
    //   }
    // }else{
    //   if(m_DriveTrain.getRightEncoderDist() > rightDistToTravel){
    //     m_DriveTrain.rightDrive(-m_speed);
    //   }else{
    //     m_DriveTrain.rightDrive(0);
    //     rightFinished = true;
    //   }
    // }
  }


  // private void testTimeOut(){
  //   long curtime = System.currentTimeMillis()*1000; // get the current time in seconds
  //   double leftSpeed = Math.abs(m_DriveTrain.getLeftEncoderVelocity());
  //   double rightSpeed = Math.abs(m_DriveTrain.getRightEncoderVelocity());
  //   boolean leftWheelStopped = leftSpeed < DriveConstants.TIMEOUT_SPEED_THRESHOLD;
  //   boolean rightWheelStopped = rightSpeed < DriveConstants.TIMEOUT_SPEED_THRESHOLD;

  //   if(!leftWheelStopped & !rightWheelStopped){
  //     hasStarted = true;
  //   }

  //   if(hasStarted){  // has started when we're over the speed threshold
  //     if(leftTime == null & leftWheelStopped & !leftFinished){
  //       leftTime = curtime;
  //     }
  //     if(rightTime == null & rightWheelStopped & !rightFinished){
  //       // log the time the right wheel stopped
  //       rightTime = curtime;
  //     }
      
  //     if( ( leftTime != null &((curtime-leftTime) > DriveConstants.TIMEOUT_TIME_THRESHOLD)) || ( rightTime != null &((curtime-rightTime) > DriveConstants.TIMEOUT_TIME_THRESHOLD)) ){
  //       timeout = true;
  //     }
  //   }
  // }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //testTimeOut();
    if(!timeout){
      driveTrainDist();
    }else{
      // m_DriveTrain.leftDrive(0);
      // m_DriveTrain.rightDrive(0);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    bothFinished = rightFinished & leftFinished;
    return bothFinished & !timeout;
  }
}
