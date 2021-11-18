package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class testSubsystem extends SubsystemBase {

    private DcMotor mechRotation;

    private int power = 0;

    public void GripperSubsystem(HardwareMap hMap, String name) {
        mechRotation = hMap.get(DcMotor.class, name);
    }

    public void runMotor() {
        power = 1;
    }

    public void turnOffMotor() {
        power = 0;
    }

    @Override
    public void periodic() {
        mechRotation.setPower(power);
    }

}