/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class WOFConstants {

    public static final int WOFMOTOR = 16; // WOF motor (victor)
    
		public static final int PISTONIN = 0; // piston for wof deployment 
    public static final int PISTONOUT = 1;

    public static final Color RED = new Color(1, 0, 0);
    public static final Color GREEN = new Color(0, 1, 0);
    public static final Color BLUE = new Color(0, 0, 1);
    public static final Color YELLOW = new Color(0.5, 0.5, 0);

    public static final Color[] wheelColors ={ // the colors on the WOF in order 
      RED, // red
      GREEN, // green
      BLUE, // blue
      YELLOW // yellow
    };

	public static final double COLOR_THRESHOLD = 1.1; // how close the color sensor must be to a target color (TBD)

    }

    public static final class DriveConstants {

    // motors
		public static final int LEFT_MOTOR1_PORT = 1; // currently set up for protobot ports 
    public static final int LEFT_MOTOR2_PORT = 3;
    
		public static final int RIGHT_MOTOR1_PORT = 2;
    public static final int RIGHT_MOTOR2_PORT = 4;

    // encoders
    public static final int[] LEFT_ENCODERS = new int[]{0, 1};
    public static final int[] RIGHT_ENCODERS = new int[]{2, 3};

    public static final boolean LEFT_ENCODERS_REVERSE = false;
    public static final boolean RIGHT_ENCODERS_REVERSE = true;

    // https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages/blob/master/Java/VelocityClosedLoop/src/main/java/frc/robot/Constants.java
    /**
     * Which PID slot to pull gains from. Starting 2018, you can choose from
     * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
     * configuration.
     */
    public static final int kSlotIdx = 0;
    /**
     * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For
     * now we just want the primary one.
     */
    public static final int kPIDLoopIdx = 0;
    /**
     * Set to zero to skip waiting for confirmation, set to nonzero to wait and
     * report to DS if action fails.
     */
    public static final int kTimeoutMs = 30;
    /**
     * PID Gains may have to be adjusted based on the responsiveness of control loop.
     * kF: 1023 represents output value to Talon at 100%, 7200 represents Velocity units at 100% output
     * 
     * 	                                    			  kP   kI   kD   kF          Iz    PeakOut */
    public final static Gains kGains_Velocit = new Gains( 0.25, 0.001, 20, 1023.0/7200.0,  300,  1.00);
    
    // math garbage
    public static final double ENCODER_COUNT_PER_ROTATION = 360; // number of pulses per full rotation 
    public static final int WHEEL_DIAMETER = 6; // size of the wheels 
    public static final double kEncoderDistancePerPulse =
    // Assumes the encoders are directly mounted on the wheel shafts
    (WHEEL_DIAMETER * Math.PI) / (double) ENCODER_COUNT_PER_ROTATION;

    // ultrasonic sensors
     public static final int USS_PORT = 0; // 0 needs to be changed
    }

    public static final class OIConstants {

      // joysticks
      public static final int DRIVER = 0;
      public static final int OPERATOR = 1;

      
      // driver buttons
        // ball conveyer
        public static final int INTAKE_ON = 1;
        public static final int INTAKE_OFF = 1;

        public static final int DUMP_ON = 2;
        public static final int DUMP_OFF = 2;

      // operatior buttons 
        // WOF
        public static final int EXTEND_WOF = 1; // push up
        public static final int RETRACT_WOF = 2; // pull down
        public static final int SPIN_WOF = 3; // spin 3 times
        public static final int HOLD_WOF = 4; // hold on color

        // climb 
        public static final int EXTEND_TELESCOPE = 5; // send the telescopes up
        public static final int STOP_TELESCOPE = 5; // stop the telescopes
        public static final int CLIMB_UP = 7; // start the winch
        public static final int STOP_WINCH = 7; // stop the winch


    }
    public static final class ConveyerConstants{

      public static final int INTAKE_LEFT = 5;
      public static final int INTAKE_RIGHT = 5;
      
      public static final int CLIP_LEFT = 6;
      public static final int CLIP_RIGHT = 6;
      
      public static final int DUMP_LEFT = 7;
      public static final int DUMP_RIGHT = 7;

    }

    public static final class ClimbConstants{

		public static final int LEFT_TELESCOPE = 8; // left telescope motor
    public static final int RIGHT_TELESCOPE = 9; // right telescope motor
    
		public static final int WINCH_1 = 10; // motor for the winch
		public static final int WINCH_2 = 11; // 2nd winch motor

    }

    public static final class RGBConstants{

      // color components for the super cool rgb lights
		public static final int RED_LED = 0;
		public static final int BLUE_LED = 1;
		public static final int GREEN_LED = 2;

      
    }
}
