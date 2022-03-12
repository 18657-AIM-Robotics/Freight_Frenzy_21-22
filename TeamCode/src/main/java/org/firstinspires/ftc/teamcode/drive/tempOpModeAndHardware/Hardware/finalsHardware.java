package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Hardware;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class finalsHardware {

    public HardwareMap hwMap = null;
    public DcMotorEx leftFront = null;
    public DcMotorEx rightFront = null;
    public DcMotorEx leftRear = null;
    public DcMotorEx rightRear = null;
    public DcMotorEx intakeOutake = null;
    public DcMotorEx spinner = null;
    public DcMotorEx conveyor1 = null;
    public DcMotorEx conveyor2 = null;
    public ColorSensor freightDetector1 = null;
    public ColorSensor freightDetector2 = null;
    public ColorSensor freightDetector3 = null;
    public ColorSensor freightDetector4 = null;
    public ColorSensor freightDetector5 = null;
    public DistanceSensor freightDistance1 = null;
    public Servo leftGate = null;
    public Servo rightGate = null;
    public Servo leftSlide = null;
    public Servo rightSlide = null;
    public CRServo YAW = null;
    public CRServo PITCH = null;
    public CRServo tape = null;
    public CRServo autoLift = null;
    public Servo autoSlide = null;


    /* Constructor */
    public finalsHardware() {

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
        intakeOutake = hwMap.get(DcMotorEx.class, "intake_outake");
        intakeOutake.setDirection(DcMotor.Direction.FORWARD);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftRear.setDirection(DcMotor.Direction.REVERSE);
        rightRear.setDirection(DcMotor.Direction.FORWARD);
        spinner = hwMap.get(DcMotorEx.class, "spinner");
        conveyor1 = hwMap.get(DcMotorEx.class, "conveyor1");
        conveyor2 = hwMap.get(DcMotorEx.class, "conveyor2");

        freightDetector1 = hwMap.get(ColorSensor.class, "FD1");
        freightDetector2 = hwMap.get(ColorSensor.class, "FD2");
//        freightDetector3 = hwMap.get(ColorSensor.class, "FD3");

        leftSlide = hwMap.get(Servo.class, "LSlide");
        rightSlide = hwMap.get(Servo.class, "RSlide");
        YAW = hwMap.get(CRServo.class, "yaw");
        PITCH = hwMap.get(CRServo.class, "pitch");
        tape = hwMap.get(CRServo.class, "tape");
        autoLift = hwMap.get(CRServo.class, "autoLift");
        autoSlide = hwMap.get(Servo.class, "autoSlide");
    }
}

