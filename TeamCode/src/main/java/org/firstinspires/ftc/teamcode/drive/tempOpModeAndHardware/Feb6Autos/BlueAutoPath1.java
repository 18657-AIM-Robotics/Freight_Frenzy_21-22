package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Feb6Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.EOCV_Functions;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Feb6.robotFunctions;

@Autonomous(name="BlueAutoPath1", group="Pushbot")
public class BlueAutoPath1 extends LinearOpMode {

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
            robot.moveLeftRight(-0.25);
            sleep(800);
            robot.stopDrive();
            sleep(300);
            robot.intakeOutake.setPower(1);
            robot.moveForwardBack(-0.4);
            sleep(2000);
            robot.stopDrive();
            sleep(300);
            robot.intakeOutake.setPower(0);
            robot.moveLeftRight(0.2);
            sleep(1000);
            robot.stopDrive();
            robot.moveLeftRight(-0.2);
            sleep(550);
            robot.stopDrive();
            robot.moveLeftRight(-0.2);
            sleep(90);
            robot.stopDrive();
            robot.capper.setPower(.8);
            sleep(2400);
            robot.capper.setPower(0);
            sleep(1300);
            robot.capper.setPower(-.8);
            sleep(2400);
            robot.moveLeftRight(-0.2);
            sleep(525);
            robot.stopDrive();
            robot.moveForwardBack(0.5);
            sleep(2000);
            robot.stopDrive();
            sleep(300);
            robot.moveForwardBack(-0.4);
            sleep(100);
            robot.stopDrive();
            robot.turn(0.5);
            sleep(600);
            robot.stopDrive();
            robot.moveLeftRight(-0.5);
            sleep(600);
            robot.stopDrive();
            robot.moveForwardBack(0.5);
            sleep(1200);
            robot.stopDrive();
            robot.moveLeftRight(0.5);
            sleep(900);
            robot.stopDrive();
            robot.turn(0.5);
            sleep(1200);
            robot.stopDrive();
            robot.moveLeftRight(-0.5);
            sleep(1000);
            robot.stopDrive();
            break;
        }
    }
}