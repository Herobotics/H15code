package frc.robot.subsystems.leds;
import frc.robot.Ports;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Leds extends SubsystemBase {
  private static Leds instance;
  public static Leds getInstance(){
    if(instance == null){
      instance = new Leds();
    }
    return instance;
  }
    
    
    AddressableLED LEDStrip0;
    public Leds() {
      LEDStrip0 = new AddressableLED(Ports.led);
      
    }
  public void setLength(int length) {
     // set to 10 for testing (can also set length using the LED buffer library)
    LEDStrip0.setLength(10);
  
    }

   }
  
    

