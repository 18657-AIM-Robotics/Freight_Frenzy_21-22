package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.robotFunctions;

@Autonomous(name="RedAuto2", group="Pushbot")
public class RedAuto2 extends LinearOpMode {

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
            sleep(950);
            robot.stopDrive();
            robot.capper.setPower(-.8);
            sleep(3000);
            robot.capper.setPower(.8);
            sleep(2000);
            robot.capper.setPower(0);
            robot.moveLeftRight(.55);
            sleep(2800);
            robot.stopDrive();
            robot.moveForwardBack(.35);
            sleep(1400);
            robot.stopDrive();
            robot.spinner.setPower(.8); // Spin Duck
            sleep(5000);
            robot.spinner.setPower(0);
            robot.moveForwardBack( -.5);
            sleep(500);
            robot.stopDrive();
            break;
        }
    }
}