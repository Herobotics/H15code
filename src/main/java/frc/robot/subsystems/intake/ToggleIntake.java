package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ToggleIntake extends CommandBase {

    public void initialize() {
        Intake.getInstance().setExtention(!Intake.getInstance().getExtention());
    }
    
    public boolean isFinished() {
        return true;
    }
}