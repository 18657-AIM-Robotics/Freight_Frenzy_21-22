package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="firstAuto", group="Pushbot")
public class firstAuto extends LinearOpMode {

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
            robot.moveIn("x", .1, 12); // Moves 12 inches to the Right
            sleep(5000);
            robot.moveIn("x", -.1, 12); // Moves 12 inches to the Left
            sleep(5000);
            robot.moveIn("y", .1, 12); // Moves 12 inches Forward
            sleep(5000);
            robot.moveIn("y", -.1, 12); // Moves 12 inches Backward
            sleep(5000);
            break;
        }
    }
}