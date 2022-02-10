package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Comp1Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Feb6.robotFunctions;

@Autonomous(name="BlueAuto1", group="Pushbot")
public class BlueAuto1 extends LinearOpMode {

    robotFunctions robot = new robotFunctions();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap, false, true);
        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        waitForStart();
        while (opModeIsActive()) {
//            robot.moveForwardBack(.45);
//            sleep(1450);
//            robot.stopDrive();
//            robot.capper.setPower(-.8);
//            sleep(3000);
//            robot.capper.setPower(.8);
//            sleep(2000);
//            robot.capper.setPower(0);
//            robot.moveLeftRight(.55);
//            sleep(1000);
//            robot.stopDrive();
//            robot.turn(.6);
//            sleep(1100);
//            robot.stopDrive();
//            robot.moveLeftRight(-.5);
//            sleep(3000);
//            robot.stopDrive();
//            robot.moveForwardBack(.35);
//            sleep(1100);
//            robot.stopDrive();
//            robot.rightFront.setPower(.5);
//            sleep(600);
//            robot.stopDrive();
//            robot.spinner.setPower(-.8); // Spin Duck
//            sleep(5000);
//            robot.spinner.setPower(0);
//            robot.rightFront.setPower(-.7);
//            sleep(200);
//            robot.stopDrive();
//            robot.moveForwardBack( -.5);
//            sleep(300);
//            robot.stopDrive();
//            sleep(1000);
//            robot.moveLeftRight( .75);
//            sleep(1100);
//            robot.stopDrive();
//            sleep(1000);
//            robot.turn(.65);
//            sleep(475);
//            robot.stopDrive();
//            sleep(1000);
//            robot.moveLeftRight( -.6); // Move Left
//            sleep(1200);
//            robot.stopDrive();
//            sleep(1000);
//            robot.rightRear.setPower(-.7);
//            sleep(550);
//            robot.stopDrive();
//            robot.moveLeftRight( -.6); // Move Left
//            sleep(400);
//            robot.stopDrive();
//            robot.moveForwardBack( .5);
//            sleep(5000);
//            robot.stopDrive();
//            break;
        }
    }
}