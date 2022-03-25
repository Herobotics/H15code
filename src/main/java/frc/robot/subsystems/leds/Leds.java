// This code was made by Eli and Henry, if you copy (which you might) get bent lmao
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
    Boolean isColor2 = true;

    boolean getBase(){
      return isColor2;
    }
 
    void setBase(Boolean b) {
      isColor2 = b;
    }
    
    public Leds() {
      LEDStrip = new AddressableLED(Ports.led);

      // Set length of LED strip to a # 
      LEDStripBuf = new AddressableLEDBuffer(200);
      LEDStrip.setLength(LEDStripBuf.getLength());

      }

      public void LEDBufSet() { 

      boolean isColor1 = true;
      // Sets grouping # of LEDS
      int GroupLength = 4;

        // Sets two colors for each grouping
        for (int i = 0; i < LEDStripBuf.getLength(); i++) {
          if (i%GroupLength == 0){
            isColor1 = !isColor1;
          }
          if (isColor1){
            LEDStripBuf.setRGB(i, 200, 255, 255);
          }
          // Toggles between 2 colors for LED grouping 2
          if (isColor1 == false){
            if(isColor2){
              LEDStripBuf.setRGB(i, 255, 0, 0);
            }
            else if(isColor2 == false){
              LEDStripBuf.setRGB(i, 0, 0, 255);

              
              }
            }
        }
      }
      
      // Separate starting script so LEDs can start on robot init
      public void startLEDs() {
        LEDStrip.setData(LEDStripBuf);
        LEDStrip.start();
      } 

    }