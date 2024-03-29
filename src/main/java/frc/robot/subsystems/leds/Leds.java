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

    public Boolean isAuto = false;
    Boolean isColor1 = true;
    Boolean isColor2 = true;
    
    public boolean getAuto() {
      return isAuto;
    }
    
    public void setAuto(Boolean b) {
      isAuto = b;
    }
    
    boolean getBase(){
      return isColor2;
    }
 
    void setBase(Boolean b) {
      isColor2 = b;
    }

    
    public Leds() {
      LEDStrip = new AddressableLED(Ports.led);

      // Set length of LED strip to a # 
      LEDStripBuf = new AddressableLEDBuffer(297);
      LEDStrip.setLength(LEDStripBuf.getLength());

      }

      public void LEDBufSet() { 
      
      // Sets grouping # of LEDS
      int GroupLength = 4;

        // Sets two colors for each grouping
      //for (float j = 0f; j < LEDStripBuf.getLength(); j+=0.3f){
        //if (j == LEDStripBuf.getLength() - 1) {
          //j = 0f;
        //}
        for (int i = 0; i < LEDStripBuf.getLength(); i++) {
          if (i%GroupLength == 0){
            isColor1 = !isColor1;
          }
          
           if (isColor1){
             LEDStripBuf.setRGB(i, 128, 128, 128);
          }
          // Toggles between 2 colors for LED grouping 2
          if (isColor1 == false){
            if (isAuto) {
              LEDStripBuf.setRGB(i, 0, 128, 0);
            }
            else if (isAuto == false) {
            if(isColor2){
              LEDStripBuf.setRGB(i, 0, 0, 128);
            
            }
            else if(isColor2 == false){
              LEDStripBuf.setRGB(i, 128, 0, 0);
              
 
              }
            }
            // Code for (kinda) rotate, slows down robot processing
           // if (i == 0) {
            //}
             
            //else if (i+1 >= LEDStripBuf.getLength()) {
              //LEDStripBuf.setLED(0, LEDStripBuf.getLED(i));
               
              //}
            //else {
              //  LEDStripBuf.setLED(i+1, LEDStripBuf.getLED(i)); 
                 
              //}
            } 
          }
        }
      //}
      
      // Separate starting script so LEDs can start on robot init
      public void startLEDs() {
       //for (float i = 0f; i < LEDStripBuf.getLength(); i+=0.3f) { 
        //if (i == LEDStripBuf.getLength() - 1) {
         // i = 0;
        //}  
          LEDStrip.setData(LEDStripBuf);
          LEDStrip.start();

    }
  }
//} 
  