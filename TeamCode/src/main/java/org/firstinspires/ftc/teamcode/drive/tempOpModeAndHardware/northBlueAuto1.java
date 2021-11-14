package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="northBlueAuto1", group="Pushbot")
public class northBlueAuto1 extends LinearOpMode {

    robotFunctions robot = new robotFunctions();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap, false);
        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        waitForStart();
        while (opModeIsActive()) {
            robot.moveIn("y", .25, 24); // 24 inches to the left
            robot.moveIn("x", .25, 30); // 30 inches forward
            //DROPBOX
            robot.moveIn("x", -.25, 3); // 3 inches backward
            robot.moveIn("y", .25, 50); // 50 inches to the left
            robot.moveIn("x", .25, 3); // 3 inches forward
            break;
        }
    }
}