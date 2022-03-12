package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.EEEAssistance;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="EEE")
public class EEE extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private Servo drop1 = null;
    private Servo drop2 = null;
    private Servo drop3 = null;
    private Servo drop4 = null;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        drop1 = hardwareMap.get(Servo.class, "drop1");
        drop2 = hardwareMap.get(Servo.class, "drop2");
        drop3 = hardwareMap.get(Servo.class, "drop3");
        drop4 = hardwareMap.get(Servo.class, "drop4");

        // Wait for the game to start (driver presses PLAY)
        drop1.setPosition(0);
        drop2.setPosition(1);
        drop3.setPosition(1);
        drop4.setPosition(0);
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            drop1.setPosition(.75);
            drop2.setPosition(.25);
            drop3.setPosition(.25);
            drop4.setPosition(.75);
            sleep(10000);
            break;
        }
    }
}
