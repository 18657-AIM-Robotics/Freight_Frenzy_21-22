package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class robotFunctions extends hardware{


    public static double X_TICKSTOINCHES = 1425;
    public static double Y_TICKSTOINCHES = 1725;

    public double encoderToIn(String encoder) {

        return ticksToInches(encoder);
    }

//     TO MAKE IT MOVE THE INVERTED DIRECTION IT IS OPPOSITE POWER NOT DISTANCE
    public void moveIn(String xy, double power, double distance) {
//        xEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        yEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        xEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        yEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        if (xy == "x") {
            while (Math.abs(encoderToIn(xy)) < distance) {
                leftFront.setPower(power);
                leftRear.setPower(power);
                rightFront.setPower(power);
                rightRear.setPower(power);
            }
        } else if (xy == "y") {
            while (Math.abs(encoderToIn(xy)) < distance) {
                leftFront.setPower(power);
                leftRear.setPower(-power);
                rightFront.setPower(-power);
                rightRear.setPower(power);
            }
        }
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }

    public double ticksToInches(String encoder) {
        if (encoder == "x") {
            return (xEncoder.getCurrentPosition() / X_TICKSTOINCHES);
        } else if (encoder == "y") {
            return (yEncoder.getCurrentPosition() / Y_TICKSTOINCHES);
        }
        return 0;
    }

    public void turn(double degrees, double power) {
        yEncoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        yEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double target =  (degrees * .1396);
        while (Math.abs(encoderToIn("y")) < target) {
            leftFront.setPower(power);
            leftRear.setPower(power);
            rightFront.setPower(-power);
            rightRear.setPower(-power * 1.13);
        }
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
    }

//    public void liftUpDown(double power,  int ticks) {
//        leftLift.setTargetPosition(leftLift.getCurrentPosition() + ticks);
//        rightLift.setTargetPosition(rightLift.getCurrentPosition() + ticks);
//        while (leftLift.getCurrentPosition() < leftLift.getTargetPosition() && rightLift.getCurrentPosition() < rightLift.getTargetPosition()) {
//            leftLift.setVelocity(power);
//            rightLift.setVelocity(power);
//        }
//        leftLift.setPower(0);
//        rightLift.setPower(0);
//    }
}