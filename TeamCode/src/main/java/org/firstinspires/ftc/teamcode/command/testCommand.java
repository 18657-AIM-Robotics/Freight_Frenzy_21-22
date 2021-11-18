package org.firstinspires.ftc.teamcode.command;

import org.firstinspires.ftc.teamcode.subsystems.testSubsystem;
import com.arcrobotics.ftclib.command.CommandBase;

/**
 * A simple command that grabs a stone with the
 * {@link testSubsystem}.  Written explicitly for
 * pedagogical purposes. Actual code should inline a
 * command this simple with {@link
 * com.arcrobotics.ftclib.command.InstantCommand}.
 */
public class testCommand extends CommandBase {

    // The subsystem the command runs on
    private testSubsystem m_motorSubsystem;

    public testCommand(testSubsystem subsystem) {
        m_motorSubsystem = subsystem;
        addRequirements(m_motorSubsystem);
    }

    @Override
    public void execute() {
        m_motorSubsystem.runMotor();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}