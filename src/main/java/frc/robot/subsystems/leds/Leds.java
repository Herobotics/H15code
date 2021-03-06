// Made by Eli and Henry, if you copy (which you might) get bent lmao (live, laugh, love)
package frc.robot.subsystems.leds;

import frc.robot.Ports;
import frc.robot.driver_station.Controller;

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
    Boolean isColor1 = true;
    Boolean isColor2 = true;

    double forwardVal = Controller.getInstance().getForward();
    double turnVal = Controller.getInstance().getTurn();
    
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
      
      // Sets grouping # of LEDS
      int GroupLength = 4;

        // Sets two colors for each grouping
      for (float j = 0f; j < LEDStripBuf.getLength(); j++) {
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
            // Possible code for rotate, either is broken or Rio too weak for it
            if (i == 0) {
            }
            else if (i+1 >= LEDStripBuf.getLength()) {
              LEDStripBuf.setLED(0, LEDStripBuf.getLED(i)); 
              }
            else {
              LEDStripBuf.setLED(i+1, LEDStripBuf.getLED(i)); 
              }
            } 
          }
        }
      
      // Separate starting script so LEDs can start on robot init
      public void startLEDs() {
      // Test way of stopping rotation when not moving without encoders
      if (forwardVal == 0 && turnVal == 0) {
        LEDStrip.setData(LEDStripBuf);
        LEDStrip.start();
      }
      else {
       for (float i = 0f; i < LEDStripBuf.getLength(); i++) {   
          LEDStrip.setData(LEDStripBuf);
          LEDStrip.start();
          }
        }
      }
    } 
  