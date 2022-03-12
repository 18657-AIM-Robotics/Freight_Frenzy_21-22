package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.FinalsAuto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.EOCV_Functions;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Feb6.robotFunctions;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Finals.finalsFunctions;

@Autonomous(name="Rack Test", group="Pushbot")
public class RackTest extends LinearOpMode {


    @Override
    public void runOpMode() {
        finalsFunctions robot = new finalsFunctions();
        EOCV_Functions EOCV = new EOCV_Functions();

        robot.init(hardwareMap);

        EOCV.initWebcam(hardwareMap);
        EOCV.initPipeline();
        EOCV.webcamStream();

        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);



        waitForStart();
        while (opModeIsActive()) {
            EOCV.processImage();
            robot.autoLift.setPower(-.75);
            sleep(950);
            sleep(750 * EOCV.liftHeight);
            robot.autoLift.setPower(0);
            robot.autoSlide.setPosition(1);
            sleep(1500);
            robot.autoSlide.setPosition(-1);
            sleep(1500);
            break;
        }
    }
}