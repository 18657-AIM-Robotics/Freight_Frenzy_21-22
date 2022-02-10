package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Feb6Autos.Tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Feb6.TFODFunctions;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Feb6.robotFunctions;

@Autonomous(name="testTFOD", group="Griffy")
public class testTFOD extends LinearOpMode {

    robotFunctions robot = new robotFunctions();
    TFODFunctions tFOD = new TFODFunctions();


    @Override
    public void runOpMode() {
        robot.init(hardwareMap, false, true);
        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
//        robot.lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        tFOD.initProcesses();
        tFOD.TfodOnZoom();
        tFOD.checkForStuff();


        waitForStart();
        while (opModeIsActive()) {
//            robot.liftToPosition(0.5, tFOD.height);

        }
    }
}
