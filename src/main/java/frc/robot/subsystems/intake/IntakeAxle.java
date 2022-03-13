package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeAxle extends CommandBase {

	double speed;
	
    public IntakeAxle (double speed) {
        Intake.getInstance();
        this.speed = speed;
    }

    public void initialize() {
        Intake.getInstance().intakeAxle(speed);
    }

    public boolean isFinished() {
        return true;
    }
}