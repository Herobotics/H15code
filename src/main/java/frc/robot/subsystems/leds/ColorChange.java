package frc.robot.subsystems.leds;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ColorChange extends CommandBase {
    public void initialize() {
        Leds.getInstance().setBase(!Leds.getInstance().getBase());
        
    }
    
    
    public boolean isFinished() {
        return true;
    }
}
