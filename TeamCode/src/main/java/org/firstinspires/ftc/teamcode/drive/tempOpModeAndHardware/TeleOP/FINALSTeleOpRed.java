package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Finals.finalsFunctions;

import java.lang.*;

@TeleOp(name="FinalsRedTele", group="Iterative Opmode")

public class FINALSTeleOpRed extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    finalsFunctions robot = new finalsFunctions();
    boolean mechanisms = true;
    double deadzone = .1;
    double maxSpeed = .8;
    double x = 0;
    double y = 0;
    double rx = 0;
    boolean obtained = false;
    boolean staged = false;
    boolean inAction = false;
    boolean inPosition = true;
    boolean seen = false;
    boolean beltReset = true;
    boolean running = false;
    boolean runningDown = false;
    boolean runningForward = false;
    boolean runningOut = false;
    double servoPosition = 0.00;




    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.conveyor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.conveyor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.autoSlide.setPosition(.1);

    }


    @Override
    public void init_loop() {
    }


    @Override
    public void start() {
        runtime.reset();
    }


    @Override
    public void loop() {

        double frontLeftPower;
        double backLeftPower;
        double frontRightPower;
        double backRightPower;

        if (Math.abs(-gamepad1.left_stick_y) > deadzone) {
            y = -gamepad1.left_stick_y * .63;
        } else {
            y = 0;
        }
        if (Math.abs(gamepad1.left_stick_x) > deadzone) {
            x = gamepad1.left_stick_x * .55;
        } else {
            x = 0;
        }
        if (Math.abs(gamepad1.right_stick_x) > deadzone) {
            rx = gamepad1.right_stick_x * .75;
        } else {
            rx = 0;
        }

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        frontLeftPower = (y + x + rx) / denominator;
        backLeftPower = (y - x + rx) / denominator;
        frontRightPower = (y - x - rx) / denominator;
        backRightPower = (y + x - rx) / denominator;

        robot.leftFront.setPower(frontLeftPower * maxSpeed);
        robot.leftRear.setPower(backLeftPower * maxSpeed);
        robot.rightFront.setPower(frontRightPower * maxSpeed);
        robot.rightRear.setPower(backRightPower * maxSpeed);

        if (gamepad1.x) {
            robot.intake(2500); // intake
        } else if (gamepad1.b) {
            robot.outake(2500); // outtake
        }else if (gamepad1.left_bumper) {
            robot.spinner.setPower(.08); // spinner
        } else if (gamepad1.right_bumper) {
            robot.spinner.setPower(-.08); // spinner
        } else if (gamepad1.a) {
//            robot.conveyor1.setPower(0.4);
        } else if (gamepad1.y) {
//            robot.conveyor1.setPower(-0.4);
        } else if (gamepad1.dpad_up) { // & staged
//            robot.rightSlide.setPosition(-1);
//            robot.conveyor2.setPower(1);
        } else if (gamepad1.dpad_down) { // TEMP
//            robot.conveyor2.setPower(-1);
        } else {
//            robot.rightSlide.setPosition(0.5);
            robot.intakeOutake.setPower(0);
            robot.spinner.setVelocity(0);
//            robot.conveyor1.setPower(0);
//            robot.conveyor2.setPower(0); // TODO Possibly Temp
        }

        if (gamepad1.dpad_up) { // & staged
//            robot.rightSlide.setPosition(.9);
            robot.leftSlide.setPosition(.1);
//            robot.conveyor2.setPower(1);
            robot.Conveyor2Position(1, -500);
        } else {
            robot.rightSlide.setPosition(.37);
            robot.leftSlide.setPosition(.6);
            robot.Conveyor2Position(1, 0);
        }

        if (gamepad2.a) {
            robot.autoLift.setPower(-0.5);
        } else if (gamepad2.y) {
            robot.autoLift.setPower(0.5);
        } else {
            robot.autoLift.setPower(0);
        }


        // Checks for block on 1st Belt
        if (gamepad2.dpad_up) { // CS gate 1
            obtained = true;
        } else {
            obtained = false;
        }
//         Controls first conveyor
//        if ((obtained && !seen) || running) { // ConveyorSystem
//            robot.Conveyor1Position(.5, 1000);
//            running = true;
//            if (Math.abs(robot.conveyor1.getCurrentPosition()- robot.conveyor1.getTargetPosition()) < 2) {
//                running = false;
//            }
//        } else if (seen || runningDown) {
//            robot.Conveyor1Position(.5, 0);
//            runningDown = true;
//            if (Math.abs(robot.conveyor1.getCurrentPosition()- robot.conveyor1.getTargetPosition()) < 2) {
//                running = false;
//            }
//        } else {
//            robot.conveyor1.setPower(0);
//            running = false;
//            runningDown = false;
//        }

        if (obtained || running) {
            robot.Conveyor1Position(.5, 1070);
            running = true;
            if (Math.abs(robot.conveyor1.getCurrentPosition()- robot.conveyor1.getTargetPosition()) < 5) {
                running = false;
            }
        } else {
            robot.Conveyor1Position(.5,0);
            running = false;
        }
////
        if (robot.detectFreight2()) {
            seen = true;
        } else {
            seen = false;
        }



//
//        if (robot.detectFreight3()) {
//            staged = true;
//        }else {
//            staged = false;
//        }
//
//        // Detects when the block is in the staged position
//        if (seen || runningForward) { // CS gate 2
//            robot.Conveyor2Position(.5, 300);
//            runningForward = true;
//        } else if (gamepad1.dpad_up && staged) {
//            robot.rightSlide.setPosition(.5);
//            robot.Conveyor2Position(.5, 400);
//            runningOut = true;
//            if (Math.abs(robot.conveyor2.getCurrentPosition()- robot.conveyor2.getTargetPosition()) < 3) {
//                runningOut = false;
//            }
//        } else if (!staged && !seen) {
//            runningOut = false;
//            runningForward = false;
//            robot.Conveyor2Position(.5, 0);
//        }

        //TAPE MECHANISM VARS
        double yawVal;
        double pitchVal;
        yawVal = -gamepad2.left_stick_x * .375;
        pitchVal = gamepad2.right_stick_y * .5;

        //TAPE MECHANISM FUNCTIONALITY
        robot.YAW.setPower(yawVal);
        robot.PITCH.setPower(pitchVal);
        if (gamepad2.right_trigger > deadzone) {
            robot.tape.setPower(-1);
        } else if (gamepad2.left_trigger > deadzone) {
            robot.tape.setPower(1);
        } else {
            robot.tape.setPower(0);
        }



        if (runtime.toString() == "85") { // Endgame warning
            gamepad1.rumble(1000);
            gamepad2.rumble(1000);
        }
        if (runtime.toString() == "115") { // End of Match warning
            gamepad1.rumble(1000);
            gamepad2.rumble(1000);
        }

        telemetry.addData("Red 1 ", robot.freightDetector1.red());
        telemetry.addData("Red 2 ", robot.freightDetector2.red());
//        telemetry.addData("Red 3 ", robot.freightDetector3.red());
        telemetry.addData("Conveyor1 Position", robot.conveyor1.getCurrentPosition());
        telemetry.addData("Obtained", obtained);
        telemetry.addData("Seen", seen);
        telemetry.addData("Running", running);
        telemetry.addData("Running Down", runningDown);
        telemetry.addData("Running Forward", runningForward);
        telemetry.addData("Staged", staged);
        telemetry.addData("Conveyor2 Position", robot.conveyor2.getCurrentPosition());
        telemetry.addData("RSlide Position", robot.rightSlide.getPosition());
        telemetry.addData("LSlide Position", robot.leftSlide.getPosition());
    }

    @Override
    public void stop() {
    }

}
