package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class hardware {

    /* Public OpMode members. */
    public HardwareMap hwMap = null;
    public DcMotorEx leftFront = null;
    public DcMotorEx rightFront = null;
    public DcMotorEx leftRear = null;
    public DcMotorEx rightRear = null;
//    public DcMotorEx leftLift = null;
//    public DcMotorEx rightLift = null;
//    public DcMotor spinner = null;

    private ElapsedTime runtime = new ElapsedTime();

    public DcMotorEx xEncoder = null;
    public DcMotorEx yEncoder = null;

    /* local OpMode members. */
    static final double     COUNTS_PER_MOTOR_REV    = 28 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 20.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 3.5 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);

    /* Constructor */
    public hardware() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftFront = hwMap.get(DcMotorEx.class, "front_left_drive");
        rightFront = hwMap.get(DcMotorEx.class, "front_right_drive");
        leftRear = hwMap.get(DcMotorEx.class, "back_left_drive");
        rightRear = hwMap.get(DcMotorEx.class, "back_right_drive");
//        leftLift = hwMap.get(DcMotorEx.class, "left_lift");
//        rightLift = hwMap.get(DcMotorEx.class, "right_lift");

//        spinner = hwMap.get(DcMotor.class, "spinner");

//        xEncoder = hwMap.get(DcMotorEx.class, "xEncoder");
//        yEncoder = hwMap.get(DcMotorEx.class, "yEncoder");
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear.setDirection(DcMotor.Direction.REVERSE);
        rightRear.setDirection(DcMotor.Direction.REVERSE);
//        leftLift.setDirection(DcMotor.Direction.FORWARD);
//        rightLift.setDirection(DcMotor.Direction.FORWARD);


    }
}

