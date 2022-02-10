package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Feb6.robotFunctions;

import java.lang.*;

@TeleOp(name="FinalsRedTele", group="Iterative Opmode")

public class FINALSTeleOpRed extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    robotFunctions robot = new robotFunctions();
    boolean mechanisms = true;
    double deadzone = .3;
    double maxSpeed = .8;
    double x = 0;
    double y = 0;
    double rx = 0;
    double spinnerVelo = 0;
    boolean spinnerRunning = false;
    boolean obtained = false;
    boolean staged = false;
    boolean inAction = false;
    boolean transition = false;
    int maxSpinnerSpeed = 20000;




    @Override
    public void init() {
        robot.init(hardwareMap, mechanisms, false);
        telemetry.addData("Status", "Initialized");
        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
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
            x = -gamepad1.left_stick_y * .63;
        } else {
            x = 0;
        }
        if (Math.abs(gamepad1.left_stick_x) > deadzone) {
            y = gamepad1.left_stick_x * .55;
        } else {
            y = 0;
        }
        if (Math.abs(gamepad1.right_stick_x) > deadzone) {
            rx = gamepad1.right_stick_x * .75;
        } else {
            rx = 0;
        }

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        if (mechanisms) {
            frontLeftPower = (y + x + rx) / denominator;
            backLeftPower = (y*1.15 - x - rx) / denominator;
            frontRightPower = (y - x + rx) / denominator;
            backRightPower = (y*1.15 + x - rx) / denominator;
        } else {
            frontLeftPower = (y + x - rx) / denominator;
            backLeftPower = (y - x + rx) / denominator;
            frontRightPower = (y - x - rx) / denominator;
            backRightPower = (y + x - rx) / denominator;
        }

        robot.leftFront.setPower(frontLeftPower * maxSpeed);
        robot.leftRear.setPower(backLeftPower * maxSpeed);
        robot.rightFront.setPower(frontRightPower * maxSpeed);
        robot.rightRear.setPower(backRightPower * maxSpeed);

        if (gamepad1.b || obtained || staged) {
            robot.intake(2500);
        } else if (gamepad1.x && !staged) {
            robot.outake(2500);
        } else if (gamepad2.left_trigger > deadzone) {
//            robot.tape.setVelocity(8000);
        } else if (gamepad2.right_trigger > deadzone) {
//            robot.tape.setVelocity(-8000);
        } else if (gamepad1.left_bumper) {
//            if (!spinnerRunning) {
//                spinnerRunning = true;
//                spinnerVelo = 1000;
//            }
            robot.spinner.setVelocity(200);
        } else if (gamepad1.right_bumper) {
//            if (!spinnerRunning) {
//                spinnerRunning = true;
//                spinnerVelo = -1000;
//            }
            robot.spinner.setVelocity(-200);
        } else if (gamepad2.y) {
            robot.capper.setPower(.8);
        } else if (gamepad2.a) {
            robot.capper.setPower(-.8);
        } else if (gamepad2.dpad_up) {
            maxSpeed = .8;
        } else if (gamepad2.dpad_down) {
            maxSpeed = 1.0;
        } else {
//            robot.hand.setPower(0);
            robot.capper.setPower(0);
            robot.intakeOutake.setPower(0);
            robot.spinner.setVelocity(0);
//            robot.tape.setPower(0);
        }
//        if (spinnerVelo != 0) {
//            spinnerVelo = robot.rampUp(spinnerRunning);
//        } else if (Math.abs(spinnerVelo) > maxSpinnerSpeed) {
//            spinnerVelo = 0;
//            spinnerRunning = false;
//        }
//        robot.spinner.setVelocity(spinnerVelo);

        if (robot.detectFreight1()) {
            obtained = true;
        }

        if (robot.detectFreight2() && !inAction) {
            staged = true;
            obtained = false;
        } else {
            staged = false;
        }

        if (gamepad1.dpad_up) {
            robot.leftLifter.setPosition(-1);
            inAction = true;
        } else {
            inAction = false;
            robot.leftLifter.setPosition(0.5);
        }

        if (runtime.toString() == "85") {
            gamepad1.rumble(1000);
        }
        if (runtime.toString() == "115") {
            gamepad1.rumble(1000);
        }
        if (staged) {
            robot.conveyor.setPower(0);
        } else {
            robot.conveyor.setPower(-1);
        }
        if (gamepad1.dpad_left) {
            staged = false;
            obtained = false;
            inAction = false;
        }


        telemetry.addData("Red  ", robot.freightDetector1.red());
        telemetry.addData("Green ", robot.freightDetector1.green());
        telemetry.addData("Blue ", robot.freightDetector1.blue());
        telemetry.addData("Red  ", robot.freightDetector2.red());
        telemetry.addData("Green ", robot.freightDetector2.green());
        telemetry.addData("Blue ", robot.freightDetector2.blue());
        telemetry.addData("Obtained ", obtained);
        telemetry.addData("Staged ", staged);
        telemetry.addData("RightTrigger ", gamepad1.right_trigger);
        telemetry.addData("ServoPos ", robot.leftLifter.getPosition());
        telemetry.addData("DPD UP ", gamepad1.dpad_up);
    }

    @Override
    public void stop() {
    }

}
