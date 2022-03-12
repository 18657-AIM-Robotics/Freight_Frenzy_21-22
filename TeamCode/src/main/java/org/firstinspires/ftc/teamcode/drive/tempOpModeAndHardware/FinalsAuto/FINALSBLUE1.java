package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.FinalsAuto;


import com.acmerobotics.roadrunner.drive.Drive;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequenceBuilder;

import com.acmerobotics.roadrunner.trajectory.constraints.AngularVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.MinVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.TrajectoryVelocityConstraint;
import com.acmerobotics.roadrunner.trajectory.constraints.TranslationalVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.EOCV_Functions;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Finals.finalsFunctions;

import java.util.Arrays;

@Autonomous(name="FINALSBLUE1", group="Iterative Opmode")

public class FINALSBLUE1 extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        finalsFunctions robot = new finalsFunctions();
        EOCV_Functions EOCV = new EOCV_Functions();

        robot.init(hardwareMap);
        EOCV.initWebcam(hardwareMap);
        EOCV.initPipeline();
        EOCV.webcamStream();


        Pose2d startPose = new Pose2d(-36, 63, Math.toRadians(0));

        drive.setPoseEstimate(startPose);

        TrajectorySequence myTrajectory = drive.trajectorySequenceBuilder(startPose)
                .strafeTo(new Vector2d(-12, 38.5), SampleMecanumDrive.getVelocityConstraint(15, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH), SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))
                .addDisplacementMarker(() -> {
                    robot.autoLift.setPower(-75);
                    sleep(950);
                    sleep(1150 * EOCV.liftHeight);
                    robot.autoLift.setPower(0);
                    robot.autoSlide.setPosition(.75);
                    sleep(800);
                })
                .strafeLeft(19)
                .back(46)
                .addDisplacementMarker(() -> {
                    robot.spinner.setPower(0.4);
                    sleep(2500);
                    robot.spinner.setVelocity(0);
                })
                .lineToLinearHeading(new Pose2d(-15, 62, Math.toRadians(0)), SampleMecanumDrive.getVelocityConstraint(15, DriveConstants.MAX_ANG_VEL, DriveConstants.TRACK_WIDTH), SampleMecanumDrive.getAccelerationConstraint(DriveConstants.MAX_ACCEL))
                .strafeLeft(3)
                .forward(45)
                .build();

        waitForStart();

        while (opModeIsActive()) {
            robot.autoSlide.setPosition(.357);
            EOCV.processImage();
            drive.followTrajectorySequence(myTrajectory);
            break;
        }
    }
}