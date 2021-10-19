package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="firstAuto", group="Pushbot")
public class firstAuto extends LinearOpMode {

    autoFunctions robot = new autoFunctions();

    @Override
    public void runOpMode() {
//        robot.init(hardwareMap);
//        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//        robot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//        robot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        waitForStart();
        while (opModeIsActive()) {
            robot.moveIn("x", .5, 12); // Moves 12 inches to the Right
            robot.moveIn("x", -.5, 12); // Moves 12 inches to the Left
            robot.moveIn("y", .5, 12); // Moves 12 inches Forward
            robot.moveIn("y", -.5, 12); // Moves 12 inches Backward
            break;
        }
    }
}