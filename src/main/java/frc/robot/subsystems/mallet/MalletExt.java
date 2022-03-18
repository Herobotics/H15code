package frc.robot.subsystems.mallet;
import java.util.Set;

import edu.wpi.first.wpilibj.PneumaticsModuleType; 
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Ports;

public class MalletExt extends SubsystemBase implements Command{

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
  public MalletExt() {
    // Set up the actuators
    solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Ports.mallet_solenoid);
  }

  //void toggle(boolean on) {
    //solenoid.set(on);
  //}

  @Override
  public Set<Subsystem> getRequirements() {
    // TODO Auto-generated method stub
    return null;
  }


 boolean getExtention(){
    return solenoid.get();
  }

  void setExtention(boolean b) {
    solenoid.set(b);
  }

 
}
