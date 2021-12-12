package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.lang.*;

@TeleOp(name="teleOPPPPPP", group="Iterative Opmode")

public class teleOPPPPPPP extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    robotFunctions robot = new robotFunctions();
    boolean mechanisms = true;
    double deadzone = .4;
    double maxSpeed = .8;



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
    }


    @Override
    public void loop() {

        double frontLeftPower;
        double backLeftPower;
        double frontRightPower;
        double backRightPower;


        double x = -gamepad1.left_stick_y * .7; // Remember, this is reversed!
        double y = gamepad1.left_stick_x * .85;
        double rx = gamepad1.right_stick_x * .8;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        if (mechanisms) {
            frontLeftPower = (y + x + rx) / denominator;
            backLeftPower = (y*1.2 - x - rx) / denominator;
            frontRightPower = (y - x + rx) / denominator;
            backRightPower = (y*1.2 + x - rx) / denominator;
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

        if (gamepad1.b) {
            robot.intake(2500);
        } else if (gamepad1.x) {
            robot.outake(2500);
        } else if (gamepad2.left_trigger > deadzone) {
            robot.tape.setVelocity(8000);
        } else if (gamepad2.right_trigger > deadzone) {
            robot.tape.setVelocity(-8000);
        } else if (gamepad1.left_bumper) {
            robot.spinner.setVelocity(20000);
        } else if (gamepad1.right_bumper) {
            robot.spinner.setVelocity(-20000);
        } else if (gamepad1.dpad_up) {
            robot.conveyor.setPower(1);
        } else if (gamepad1.dpad_down) {
            robot.conveyor.setPower(0);
        } else if (gamepad2.y) {
            robot.capper.setPower(.8);
        } else if (gamepad2.a) {
            robot.capper.setPower(-.8);
        } else if (gamepad2.b) {
            robot.hand.setPower(.8);
        } else if (gamepad2.x) {
            robot.hand.setPower(-.8);
        } else if (gamepad2.dpad_up) {
            maxSpeed = .8;
        } else if (gamepad2.dpad_down) {
            maxSpeed = 1.0;
        } else {
            robot.hand.setPower(0);
            robot.capper.setPower(0);
            robot.spinner.setPower(0);
            robot.intakeOutake.setPower(0);
            robot.tape.setPower(0);
        }

        if (robot.sensorColor.red() > 400) {
            robot.flag.setPower(1);
        } else {
            robot.flag.setPower(0);
        }

        telemetry.addData("Alpha ", robot.sensorColor.alpha());
        telemetry.addData("Red  ", robot.sensorColor.red());
        telemetry.addData("Green ", robot.sensorColor.green());
        telemetry.addData("Blue ", robot.sensorColor.blue());
    }

    @Override
    public void stop() {
    }

}
