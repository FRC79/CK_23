/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


/*
...............................................................................

........................................................--.....................

.......................................................=WWWW@=:................

....................................................:@WWWWWWWWWWWW@*-..........

..................................................=WWWWWWWWWWWWWWWWWWWWW#+-....

...............................................+@WWWWWWWWWWWWWWWWWWWWWWWWW@....

............................................:@WWWWWWWWWWWWWWWWWWWWWWWWWWW#.....

.........................................-#WWWWWWWWWWWWWWWWWWWWWWWWWWWWW*......

......................................-#WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW=.......

...................................:#WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW:.......

...............................:#@WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW........

............................:@WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW#........

......................-+=#WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW+........

..................+WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW@.........

...............-#WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW:.........

.............*WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW+..........

..........:@WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW+...........

........:@WWWWWWWW@WWWWWWWWWWWWWWWWWWWWWW*.....:#WWWWWWWWWWWWWWWWW+............

.....-=WWWWWWW*-+WWWWWWWWWWWWWWWWWWWWWWW-..........+WWWWWWWWWWWWW=.............

.....@WWWW@*-.:@WWWWWWWWWWWWWWWWWWWWWW#.............-WWWWWWWWWWW@..............

......-.....-#WWWWWWWWWWWWWWWWWWWWWWWWW-.............#WWWWWWWWWW:..............

...........*WWWWWWWWWWWWWWWWWWWWWWWWWWW:.............@WWWWWWWWW#...............

.........:@WWWWWWW@+-WWWWWWWWWWWWWWWWWW-............+WWWWWWWWWW+...............

........#WWWWWWW#-..@WWWWWWWWWWWWWWWWW=............-WWWWWWWWWW@................

......-@WWWWWW@-...#WWWWWWWWWWWWWWWWWWWWW*.........@WWWWWWWWWW*................

.....+WWWWWWW:....*WWWWWWWW+.:@WWWWWWWWWWWW:......+WWWWWWWWWWW-................

...-@WWWWWW*.....:WWWWWWW@-.....-=WWWWWWWWWWW#:...#WWWWWWWWWW:.................

...=WWWWW=......-WWWWWWW#..........-=WWWWWWWWWWW*-WWWWWWWWW@-..................

....-::........-@WWWWWW#...............+WWWWWWWWWWWWWWWWWW*....................

...............@WWWWWW#...................:=@WWWWWWWWWWWW:.....................

..............=WWWWWW#........................-#WWWWWWW#.......................

..............#WWWWW@-............................-#W@:........................

.............+WWWWWW:..........................................................

............-WWWWWW+...........................................................

............+WWW@+.............................................................


   _____           _           _                    
  / ____|         | |         ( )                   
 | |  __    ___   | |_        |/    ___   _ __ ___  
 | | |_ |  / _ \  | __|            / _ \ | '_ ` _ \ 
 | |__| | | (_) | | |_            |  __/ | | | | | |
  \_____|  \___/   \__|            \___| |_| |_| |_|
                                                    
                                    
*/

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

    public static final int WOFMOTOR = 3; // WOF motor (victor)
    
		public static final int PISTONIN = 1; // piston for wof deployment 
    public static final int PISTONOUT = 0;

    public static final Color RED = new Color(0.5, 0.3, 0);
    public static final Color GREEN = new Color(0, 1, 0);
    public static final Color BLUE = new Color(0, 0, 1);
    public static final Color YELLOW = new Color(0.3, 0.5, 0);

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
    // currently set up for CK23 ports 
		public static final int LEFT_MOTOR1_PORT = 7; // victor
    public static final int LEFT_MOTOR2_PORT = 1; // talon
    
		public static final int RIGHT_MOTOR1_PORT = 13; // talon
    public static final int RIGHT_MOTOR2_PORT = 8; // victor

    // encoders
    public static final int LEFT_ENCODERS = 1; // ports
    public static final int RIGHT_ENCODERS = 2;

    public static final boolean LEFT_ENCODERS_REVERSE = false; // is reversed
    public static final boolean RIGHT_ENCODERS_REVERSE = true;
    
    // math garbage
    public static final double ENCODER_COUNT_PER_ROTATION = 360; // number of pulses per full rotation 
    public static final double WHEEL_DIAMETER = 0.1524; // size of the wheels in m

    // ultrasonic sensors
    public static final int USS_WALL = 0; // at the level of the wall
    public static final int USS_HOLE = 1; // at the level of the low goal

    // drive distance 
	  public static final double TIMEOUT_SPEED_THRESHOLD = 0; // speed in m/s that we should consider stopped
	    public static final long TIMEOUT_TIME_THRESHOLD = 0;

    }

    public static final class OIConstants {

      // joysticks
      public static final int DRIVER = 0;
      public static final int OPERATOR = 1;

      
      // driver buttons
        // ball conveyer
        public static final int INTAKE_ON = 1; // should be the same button
        public static final int INTAKE_OFF = 1;

        public static final int DUMP_ON = 2; // should be the same button
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

		public static final int INTAKE = 6;
		public static final int CLIP_LOW = 9;
		public static final int CLIP_HIGH = 12;
		public static final int DUMP = 11;

      

    }

    public static final class ClimbConstants{

		public static final int LEFT_TELESCOPE = 19; // left telescope motor
    public static final int RIGHT_TELESCOPE = 18; // right telescope motor
    
		public static final int WINCH_1 = 2; // motor for the winch
		public static final int WINCH_2 = 10; // 2nd winch motor

    }

    public static final class RGBConstants{

		public static final int RED_LED = 0;
		public static final int BLUE_LED = 1;
		public static final int GREEN_LED = 2;



    }
}
