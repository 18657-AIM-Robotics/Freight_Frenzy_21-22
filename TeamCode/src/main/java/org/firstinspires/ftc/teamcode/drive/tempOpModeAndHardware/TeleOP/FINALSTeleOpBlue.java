package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Finals.finalsFunctions;

import java.lang.*;

@TeleOp(name="FinalsBlueTele", group="Iterative Opmode")

public class FINALSTeleOpBlue extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    finalsFunctions robot = new finalsFunctions();
    boolean mechanisms = true;
    double deadzone = .3;
    double maxSpeed = .8;
    double x = 0;
    double y = 0;
    double rx = 0;
    boolean obtained = false;
    boolean staged = false;
    boolean inAction = false;
    boolean inPosition = true;




    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.conveyor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
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

        if (gamepad1.b || obtained || staged) {
            robot.intake(2500); // intake
        } else if (gamepad1.x && !staged) {
            robot.outake(2500); // outtake
        }else if (gamepad1.left_bumper) {
            robot.spinner.setVelocity(200); // spinner
        } else if (gamepad1.right_bumper) {
            robot.spinner.setVelocity(-200); // spinner
        } else if (gamepad1.dpad_up) {
            robot.rightGate.setPosition(-1);
            robot.rightSlide.setPosition(-1);
            inAction = true;
        } else if (gamepad1.dpad_left) {
            staged = false;
            obtained = false;
            inAction = false;
        } else {
            inAction = false;
            robot.rightGate.setPosition(0.5);
            robot.rightSlide.setPosition(0.5);
            robot.intakeOutake.setPower(0);
            robot.spinner.setVelocity(0);
        }

        if (robot.detectFreight1()) { // CS gate 1
            obtained = true;
        }

        if ((robot.detectFreight4() || robot.detectFreight5()) && !inAction) { // CS gate 2
            staged = true;
        } else {
            staged = false;
        }

        if (robot.detectFreight3() && !inAction) { // CS prep 1
            robot.conveyor2.setPower(1);
        } else {
            robot.resetConveyor2Position(1);
        }

        if (runtime.toString() == "85") { // Endgame warning
            gamepad1.rumble(1000);
            gamepad2.rumble(1000);
        }
        if (runtime.toString() == "115") { // End of Match warning
            gamepad1.rumble(1000);
            gamepad2.rumble(1000);
        }

        inPosition = robot.checkDistance(0.5);

        if (obtained) { // ConveyorSystem
            robot.conveyor1.setPower(-1);
        } else if (!inPosition && !obtained) {
            robot.conveyor1.setPower(1);
        } else {
            robot.conveyor1.setPower(0);
        }

        if (!staged) {
            robot.conveyor2.setPower(1);
        } else {
            robot.conveyor2.setPower(0);
        }

        double yawVal;
        double pitchVal;
        yawVal = gamepad2.left_stick_x * .5;
        pitchVal = gamepad2.right_stick_y * .5;

        robot.YAW.setPower(yawVal);
        robot.PITCH.setPower(pitchVal);
        if (gamepad2.right_trigger > deadzone) {
            robot.tape.setPower(1);
        } else if (gamepad2.left_trigger > deadzone) {
            robot.tape.setPower(-1);
        }


        telemetry.addData("Red  ", robot.freightDetector1.red());
        telemetry.addData("Green ", robot.freightDetector1.green());
        telemetry.addData("Blue ", robot.freightDetector1.blue());
        telemetry.addData("Red  ", robot.freightDetector2.red());
        telemetry.addData("Green ", robot.freightDetector2.green());
        telemetry.addData("Blue ", robot.freightDetector2.blue());
    }

    @Override
    public void stop() {
    }

}
