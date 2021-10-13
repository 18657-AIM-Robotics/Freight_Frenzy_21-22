package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class autoFunctions {

    hardware robot = new hardware();

    public static double X_TICKSTOINCHES = 1425;
    public static double Y_TICKSTOINCHES = 1725;

    public double encoderToIn(String encoder) {

        return ticksToInches(encoder);
    }

    // TO MAKE IT MOVE THE INVERTED DIRECTION IT IS OPPOSITE POWER NOT DISTANCE
    public void moveIn(String xy, double power, double distance) {
        robot.xEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.yEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.xEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.yEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if (xy == "x") {
            while (Math.abs(encoderToIn(xy)) < distance) {
                robot.leftFront.setPower(power);
                robot.leftRear.setPower(power);
                robot.rightFront.setPower(power);
                robot.rightRear.setPower(power * 1.18);
            }
        } else if (xy == "y") {
            while (Math.abs(encoderToIn(xy)) < distance) {
                robot.leftFront.setPower(power);
                robot.leftRear.setPower(-power);
                robot.rightFront.setPower(-power);
                robot.rightRear.setPower(power * 1.1);
            }
        }
        robot.leftFront.setPower(0);
        robot.leftRear.setPower(0);
        robot.rightFront.setPower(0);
        robot.rightRear.setPower(0);
    }

    public double ticksToInches(String encoder) {
        if (encoder == "x") {
            return (robot.xEncoder.getCurrentPosition() / X_TICKSTOINCHES);
        } else if (encoder == "y") {
            return (robot.yEncoder.getCurrentPosition() / Y_TICKSTOINCHES);
        }
        return 0;
    }

    public void turn(double degrees, double power) {
        robot.yEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.yEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double target =  (degrees * .1396);
        while (Math.abs(encoderToIn("y")) < target) {
            robot.leftFront.setPower(power);
            robot.leftRear.setPower(power);
            robot.rightFront.setPower(-power);
            robot.rightRear.setPower(-power * 1.13);
        }
        robot.leftFront.setPower(0);
        robot.leftRear.setPower(0);
        robot.rightFront.setPower(0);
        robot.rightRear.setPower(0);
    }
}