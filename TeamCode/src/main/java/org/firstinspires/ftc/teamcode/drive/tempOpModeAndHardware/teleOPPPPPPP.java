package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="teleOPPPPPP", group="Iterative Opmode")

public class teleOPPPPPPP extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    robotFunctions robot = new robotFunctions();
    boolean frontLeftON = true;
    boolean frontRightON = true;
    boolean backLeftON = true;
    boolean backRightON = true;
    boolean mechanisms = true;



    @Override
    public void init() {
        robot.init(hardwareMap, mechanisms);
        telemetry.addData("Status", "Initialized");
        robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.leftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.rightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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

        // Setup a variable for each drive wheel to save power level for telemetry
        double y = -gamepad1.left_stick_y * 1.2; // Remember, this is reversed!
        double x = gamepad1.left_stick_x * .8;
        double rx = gamepad1.right_stick_x * .8;

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        if (mechanisms) {
            frontLeftPower = (y + x + rx) / denominator;
            backLeftPower = (y - x - rx) / denominator;
            frontRightPower = (y - x + rx) / denominator;
            backRightPower = (y + x - rx) / denominator;
        } else {
            frontLeftPower = (y + x - rx) / denominator;
            backLeftPower = (y - x + rx) / denominator;
            frontRightPower = (y - x - rx) / denominator;
            backRightPower = (y + x - rx) / denominator;
        }

        robot.leftFront.setPower(frontLeftPower * .8);
        robot.leftRear.setPower(backLeftPower * .8);
        robot.rightFront.setPower(frontRightPower * .8);
        robot.rightRear.setPower(backRightPower * .8);

        if (gamepad1.a) {
            robot.liftUpDown(2000);
        } else if (gamepad1.y) {
            robot.liftUpDown(-2000);
        } else if (gamepad1.b) {
            robot.intake(2500);
        } else if (gamepad1.x) {
            robot.outake(2500);
        } else if (gamepad1.left_bumper) {
            robot.push.setPower(-1);
        } else if (gamepad1.right_bumper) {
            robot.push.setPower(1);
        } else {
            robot.liftUpDown(0);
            robot.intake(0);
            robot.push.setPower(0);
        }

        // Show the elapsed game time and wheel power.
    }

    @Override
    public void stop() {
    }

}
