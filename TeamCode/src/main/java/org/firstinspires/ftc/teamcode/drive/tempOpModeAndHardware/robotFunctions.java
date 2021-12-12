package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class robotFunctions extends hardware{

    public boolean conveyorON = false;
    public static double X_TICKSTOINCHES = 1425;
    public static double Y_TICKSTOINCHES = 1725;
    final double COLOR_SCALE_FACTOR = 255;

//    public double encoderToIn(String encoder) {
//
//        return ticksToInches(encoder);
//    }

//     TO MAKE IT MOVE THE INVERTED DIRECTION IT IS OPPOSITE POWER NOT DISTANCE
//    public void moveIn(String xy, double power) { //TODO: READD DISTANCE
////        xEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////        yEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////        xEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
////        yEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
////        if (xy == "x") {
////            while (Math.abs(encoderToIn(xy)) < distance) {
////                leftFront.setPower(.1);
////                leftRear.setPower(.1);
////                rightFront.setPower(.1);
////                rightRear.setPower(.1);
////            }
////        } else if (xy == "y") {
////            while (Math.abs(encoderToIn(xy)) < distance) {
////                leftFront.setPower(power);
////                leftRear.setPower(-power);
////                rightFront.setPower(-power);
////                rightRear.setPower(power);
////            }
////        }
////        leftFront.setPower(0);
////        leftRear.setPower(0);
////        rightFront.setPower(0);
////        rightRear.setPower(0);
//        if (xy == "x") {
//            leftFront.setPower(power);
//            leftRear.setPower(power);
//            rightFront.setPower(power);
//            rightRear.setPower(power);
//        } else if (xy == "y") {
//            leftFront.setPower(power);
//            leftRear.setPower(-power);
//            rightFront.setPower(-power);
//            rightRear.setPower(power);
//        }
//    }

//    public double ticksToInches(String encoder) {
//        if (encoder == "x") {
//            return (xEncoder.getCurrentPosition() / X_TICKSTOINCHES);
//        } else if (encoder == "y") {
//            return (yEncoder.getCurrentPosition() / Y_TICKSTOINCHES);
//        }
//        return 0;
//    }

//    public void turn(double degrees, double power) {
//        yEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        yEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        double target =  (degrees * .1396);
//        while (Math.abs(encoderToIn("y")) < target) {
//            leftFront.setPower(power);
//            leftRear.setPower(power);
//            rightFront.setPower(-power);
//            rightRear.setPower(-power);
//        }
//        leftFront.setPower(0);
//        leftRear.setPower(0);
//        rightFront.setPower(0);
//        rightRear.setPower(0);
//    }

//    public void liftUpDown(double velocity) { // Negative power to lower height
//        leftLift.setVelocity(-velocity);
//        rightLift.setVelocity(velocity);
//    }

    public void intake(double velocity) {
        intakeOutake.setVelocity(velocity);
    }

    public void outake(double velocity) {
        intakeOutake.setVelocity(-velocity);
    }

    public void stopMotors() {
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
        tape.setPower(0);
        spinner.setPower(0);
        intakeOutake.setPower(0);
        conveyor.setPower(0);
    }

    public void stopDrive() {
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }

    public void moveForwardBack(double power) {
        leftFront.setPower(power);
        leftRear.setPower(power);
        rightFront.setPower(power);
        rightRear.setPower(power);
    }

    public void moveLeftRight(double power) {
        leftFront.setPower(power * .85);
        leftRear.setPower(-power * 1.4);
        rightFront.setPower(-power * .85);
        rightRear.setPower(power * 1.2);
    }

    public void turn(double power) {
        leftFront.setPower(power);
        leftRear.setPower(power);
        rightFront.setPower(-power);
        rightRear.setPower(-power);
    }
}