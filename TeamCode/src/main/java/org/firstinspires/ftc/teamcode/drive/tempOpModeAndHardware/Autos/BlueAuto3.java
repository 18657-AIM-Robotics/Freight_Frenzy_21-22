package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.robotFunctions;

@Autonomous(name="BlueAuto3", group="Pushbot")
public class BlueAuto3 extends LinearOpMode {

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
            robot.moveForwardBack(-.45);
            sleep(1000);
            robot.stopDrive();
            robot.capper.setPower(-.8);
            sleep(3000);
            robot.capper.setPower(.8);
            sleep(2000);
            robot.capper.setPower(0);
            robot.moveForwardBack(.45);
            sleep(800);
            robot.stopDrive();
            robot.turn(.75);
            sleep(275);
            robot.stopDrive();
            sleep(1000);
            robot.moveLeftRight(-.45);
            sleep(2500);
            robot.stopDrive();
            robot.moveForwardBack( .5); // Move Forward
            sleep(2000);
            break;
        }
    }
}