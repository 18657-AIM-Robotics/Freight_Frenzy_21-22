package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Feb6Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.EOCV_Functions;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Feb6.robotFunctions;

@Autonomous(name="RedAutoPath2", group="Pushbot")
public class RedAutoPath2 extends LinearOpMode {

    robotFunctions robot = new robotFunctions();
    EOCV_Functions EOCV = new EOCV_Functions();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap, false, true);
        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        EOCV.initWebcam(hardwareMap);
        EOCV.initPipeline();
        EOCV.webcamStream();


        waitForStart();

        if(isStopRequested()) return;

        while (opModeIsActive()) {
            EOCV.processImage();
            robot.moveLeftRight(-0.55);
            sleep(200);
            robot.stopDrive();
            robot.moveLeftRight(0.25);
            sleep(650);
            robot.stopDrive();
            robot.moveForwardBack(0.2);
            sleep(100);
            robot.stopDrive();
            robot.moveLeftRight(-0.2);
            sleep(300);
            robot.stopDrive();
            robot.moveForwardBack(-0.38);
            sleep(2050);
            robot.stopDrive();
            sleep(300);
            robot.capper.setPower(.8);
            sleep(3000);
            robot.capper.setPower(-0);
            sleep(1300);
            robot.capper.setPower(-.8);
            sleep(3000);
            robot.turn(.5);
            sleep(1150);
            robot.stopDrive();
            robot.moveLeftRight(-0.6);
            sleep(2600);
            robot.stopDrive();
            robot.moveForwardBack(-0.3);
            sleep(2300);
            robot.stopDrive();
            robot.moveLeftRight(-0.15);
            sleep(400);
            robot.stopDrive();
            robot.moveForwardBack(-0.2);
            sleep(200);
            robot.stopDrive();
            robot.spinner.setVelocity(-300);
            sleep(2000);
            robot.spinner.setVelocity(0);
            robot.moveForwardBack(0.4);
            sleep(1000);
            robot.stopDrive();
            break;
        }
    }
}