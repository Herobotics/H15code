package frc.robot.subsystems.leds;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ColorChange extends CommandBase {
    public static boolean isBase = true;
    
    public ColorChange(boolean isPressed){
        if (isPressed){
            isBase = !isBase;
            System.out.println("toggling");
        }
    }
}
