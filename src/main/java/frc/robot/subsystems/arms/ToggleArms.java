package frc.robot.subsystems.arms;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ToggleArms extends CommandBase{

    public void initialize() {
        ArmsExt.getInstance().setExtention(!ArmsExt.getInstance().getExtentionA());
        ArmsExt.getInstance().setExtention(!ArmsExt.getInstance().getExtentionB());
    }
    
    public boolean isFinished() {
        return true;
    }

    
}

