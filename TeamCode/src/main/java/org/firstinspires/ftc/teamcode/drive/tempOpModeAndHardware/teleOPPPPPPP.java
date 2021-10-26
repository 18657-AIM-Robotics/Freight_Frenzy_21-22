package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="teleOPPPPPP", group="Iterative Opmode")

public class teleOPPPPPPP extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    robotFunctions robot = new robotFunctions();


    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
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
        double x = -gamepad1.left_stick_x * 1.5;
        double rx = gamepad1.right_stick_x * .85;

        frontLeftPower = (y + x - rx);
        backLeftPower = (y - x - rx);
        frontRightPower = (y + x + rx);
        backRightPower = (y - x + rx);
        // Put powers in the range of -1 to 1 only if they aren't already (not
        // checking would cause us to always drive at full speed)

        if (Math.abs(frontLeftPower) > 1 || Math.abs(backLeftPower) > 1 ||
                Math.abs(frontRightPower) > 1 || Math.abs(backRightPower) > 1 ) {
            // Find the largest power
            double max = 0;
            max = Math.max(Math.abs(frontLeftPower), Math.abs(backLeftPower));
            max = Math.max(Math.abs(frontRightPower), max);
            max = Math.max(Math.abs(backRightPower), max);

            // Divide everything by max (it's positive so we don't need to worry
            // about signs)
            frontLeftPower /= max;
            backLeftPower /= max;
            frontRightPower /= max;
            backRightPower /= max;
        }
        robot.leftFront.setPower(frontLeftPower * .8);
        robot.leftRear.setPower(backLeftPower * .8);
        robot.rightFront.setPower(frontRightPower * .8);
        robot.rightRear.setPower(backRightPower * .8);

        if (gamepad1.y) {
            robot.liftUpDown(2000);
        } else if (gamepad1.a) {
            robot.liftUpDown(-2000);
        } else if (gamepad1.b) {
            robot.intake(2500);
        } else if (gamepad1.x) {
            robot.outake(2500);
        } else {
            robot.liftUpDown(0);
            robot.intake(0);
        }

        // Show the elapsed game time and wheel power.
    }

    @Override
    public void stop() {
    }

}
