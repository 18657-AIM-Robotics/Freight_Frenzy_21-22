package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.FinalsAuto;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class FINALSRED2 extends LinearOpMode {
    @Override
    public void runOpMode() {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        Pose2d startPose = new Pose2d(-36, -60, Math.toRadians(180));

        drive.setPoseEstimate(startPose);

        Trajectory myTrajectory = drive.trajectoryBuilder(startPose)
                .splineTo(new Vector2d(-12, -38), Math.toRadians(0))
                //DROP BLOCK
                .splineTo(new Vector2d(-68, -62), Math.toRadians(90))
                .back(3)
                //SPIN DUCK
                .splineTo(new Vector2d(-66, -36), Math.toRadians(0))
                .forward(42)
                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectory(myTrajectory);
    }
}