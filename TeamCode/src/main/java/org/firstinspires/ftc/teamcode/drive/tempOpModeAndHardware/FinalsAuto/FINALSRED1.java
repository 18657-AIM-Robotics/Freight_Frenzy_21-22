package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.FinalsAuto;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.EOCV_Functions;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Finals.finalsFunctions;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous(name="FINALSRED1", group="Iterative Opmode")
public class FINALSRED1 extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        finalsFunctions robot = new finalsFunctions();
        EOCV_Functions EOCV = new EOCV_Functions();

        robot.init(hardwareMap);
        EOCV.initWebcam(hardwareMap);
        EOCV.initPipeline();
        EOCV.webcamStream();


        Pose2d startPose = new Pose2d(-36, -65, Math.toRadians(180));

        drive.setPoseEstimate(startPose);

        TrajectorySequence myTrajectory = drive.trajectorySequenceBuilder(startPose)
                .strafeTo(new Vector2d(-10, -39.5))
                .addDisplacementMarker(() -> {
                    robot.autoLift.setPower(-75);
                    sleep(950);
                    sleep(1150 * EOCV.liftHeight);
                    robot.autoLift.setPower(0);
                    robot.autoSlide.setPosition(.8);
                    sleep(600);
                })
                .strafeLeft(20)
                .turn(Math.toRadians(-90))
                .build();

        waitForStart();

        while (opModeIsActive()) {
            //SET UP INCLUDING EOCV READ IMAGE
            robot.autoSlide.setPosition(.36);
            EOCV.processImage();
            drive.followTrajectorySequence(myTrajectory);
            robot.moveForwardBack(-.2);
            sleep(500);
            robot.stopDrive();
            robot.moveLeftRight(-.8);
            sleep(2500);
            robot.moveForwardBack(-.5);
            sleep(1200);
            robot.stopDrive();
            robot.spinner.setPower(-0.4);
            sleep(2500);
            robot.spinner.setVelocity(0);
            robot.moveForwardBack(.5);
            sleep(700);
            robot.stopDrive();
            break;
        }
    }
}