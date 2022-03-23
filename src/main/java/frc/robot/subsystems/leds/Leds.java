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
    
    AddressableLED LEDStrip;
    AddressableLEDBuffer LEDStripBuf;
    
    public Leds() {
      LEDStrip = new AddressableLED(Ports.led);

      // Set length of LED strip to 50 (base 50 for testing)
      LEDStripBuf = new AddressableLEDBuffer(50);
      LEDStrip.setLength(LEDStripBuf.getLength());

      // Sets chosen # of LEDS on strip to Red 
      for (int i = 0; i <= LEDStripBuf.getLength(); i++) {
        LEDStripBuf.setRGB(i, 255, 0, 0);
        }

      }

      // Separate starting script so LEDs can start on robot init
      public void startLEDs() {
        LEDStrip.setData(LEDStripBuf);
        LEDStrip.start();
      } 

    }