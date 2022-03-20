package frc.robot.subsystems.mallet;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Ports;

public class MalletExt extends SubsystemBase {

  // This variable and function are for managing and accessing the chasses anywhere in the code
  private static MalletExt instance;
  public static MalletExt getInstance(){
    if(instance == null){
      instance = new MalletExt();
    }
    
    return instance;
  }

  // All actuators on the intake
 Solenoid solenoid;

  // Creates a new Intake. This method should only be called once
  private MalletExt() {
    // Set up the actuators
    solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Ports.mallet_solenoid);
  }
  
 boolean getExtention(){
    return solenoid.get();
  }

  void setExtention(boolean b) {
    solenoid.set(b);
  }

 
}
