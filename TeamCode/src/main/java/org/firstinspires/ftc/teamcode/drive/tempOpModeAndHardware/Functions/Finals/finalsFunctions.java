package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Finals;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Hardware.finalsHardware;

public class finalsFunctions extends finalsHardware {

    public static double X_TICKSTOINCHES = 1425;
    public static double Y_TICKSTOINCHES = 1725;

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

    public void intake(double velocity) {
        intakeOutake.setVelocity(velocity);
    }

    public void outake(double velocity) {
        intakeOutake.setVelocity(-velocity);
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
        leftFront.setPower(power);
        leftRear.setPower(-power);
        rightFront.setPower(-power);
        rightRear.setPower(power);
    }

    public void turn(double power) {
        leftFront.setPower(power);
        leftRear.setPower(power);
        rightFront.setPower(-power);
        rightRear.setPower(-power);
    }

    public boolean detectFreight1() {
        if (freightDetector1.red() > 1550) {
            return true;
        } else {
            return false;
        }
    }
    public boolean detectFreight2() {
        if (freightDetector2.red() > 1550) {
            return true;
        } else {
            return false;
        }
    }
    public boolean detectFreight3() {
        if (freightDetector3.red() > 1550) {
            return true;
        } else {
            return false;
        }
    }
    public boolean detectFreight4() {
        if (freightDetector3.red() > 1550) {
            return true;
        } else {
            return false;
        }
    }
    public boolean detectFreight5() {
        if (freightDetector3.red() > 1550) {
            return true;
        } else {
            return false;
        }
    }

    public void autoLiftUpDown(double speed) {
        autoLift.setPower(speed);
    }

    public void autoSpitOut() {
        autoSlide.setPosition(1);
    }

    public void resetConveyor2Position(double speed) {
        int target = 0;
        conveyor2.setTargetPosition(target);

        conveyor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        conveyor2.setPower(Math.abs(speed));

        if (conveyor2.isBusy()) {

        } else {
            conveyor2.setPower(0);
            conveyor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }

    public boolean checkDistance(double distance) {
        if (freightDistance1.getDistance(DistanceUnit.INCH) > distance) {
            return false;
        } else {
            return true;
        }
    }
}