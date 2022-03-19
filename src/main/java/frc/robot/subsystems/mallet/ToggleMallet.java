package frc.robot.subsystems.mallet;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ToggleMallet extends CommandBase{

    public ToggleMallet(MalletExt malletExt) {
    }

    public void initialize() {
        MalletExt.getInstance().setExtention(!MalletExt.getInstance().getExtention());
    }
    
    public boolean isFinished() {
        return true;
    }

    
}
