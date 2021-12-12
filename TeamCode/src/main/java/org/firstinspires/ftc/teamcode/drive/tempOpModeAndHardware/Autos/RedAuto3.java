package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.robotFunctions;

@Autonomous(name="RedAuto3", group="Pushbot")
public class RedAuto3 extends LinearOpMode {

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
            robot.moveForwardBack(.45);
            sleep(1350);
            robot.stopDrive();
            robot.capper.setPower(-.8);
            sleep(3000);
            robot.capper.setPower(.8);
            sleep(2000);
            robot.capper.setPower(0);
            robot.moveForwardBack(-.45);
            sleep(1250);
            robot.stopDrive();
            robot.turn(-.75);
            sleep(400);
            robot.stopDrive();
            robot.moveLeftRight(-.6);
            sleep(1300);
            robot.stopDrive();
            robot.moveForwardBack(-.55);
            sleep(2250);
            break;
        }
    }
}