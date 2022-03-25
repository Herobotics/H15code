package frc.robot.driver_station;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.arms.ToggleArms;
import frc.robot.subsystems.intake.IntakeAxle;
import frc.robot.subsystems.mallet.ToggleMallet;
import frc.robot.subsystems.leds.ColorChange;


public class Controller {
    
    private static Controller instance;
    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

	private Joystick driver;

    private Controller(){
        driver = new Joystick(0);
        new JoystickButton(driver, GamePad.Button.A).whenPressed(new ToggleMallet());
        new JoystickButton(driver, GamePad.Button.B).whenPressed(new ToggleArms());
        new JoystickButton(driver, GamePad.Button.RB).whenPressed(new IntakeAxle(1));
        new JoystickButton(driver, GamePad.Button.RB).whenReleased(new IntakeAxle(0));
        new JoystickButton(driver, GamePad.Button.LB).whenPressed(new IntakeAxle(-1));
        new JoystickButton(driver, GamePad.Button.LB).whenReleased(new IntakeAxle(0));
        new JoystickButton(driver, GamePad.Button.BACK).whenPressed(new ColorChange());
        //new JoystickButton(driver, GamePad.Button.START).whenPressed(new InvertDrive());

    }

    // Get the speed we want the ball intake to move at
    public double getShooter(){
        return driver.getRawAxis(GamePad.Axis.RT) - driver.getRawAxis(GamePad.Axis.LT);
    }

    // Get our forward value for the chassis
    public double getForward(){
        return driver.getRawAxis(GamePad.Axis.LEFT_Y);
    }

    // Get our turn value for the chassis
    public double getTurn(){
        return driver.getRawAxis(GamePad.Axis.LEFT_X);
    }
}