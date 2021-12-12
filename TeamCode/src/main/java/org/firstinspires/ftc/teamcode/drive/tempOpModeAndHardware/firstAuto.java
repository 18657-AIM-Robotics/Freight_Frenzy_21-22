package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="firstAuto", group="Pushbot")
public class firstAuto extends LinearOpMode {

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
            robot.moveLeftRight(.5);
            sleep(3000);
            robot.stopDrive();
            break;
        }
    }
}