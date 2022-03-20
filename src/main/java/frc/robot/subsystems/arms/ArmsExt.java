package frc.robot.subsystems.arms;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Ports;

public class ArmsExt extends SubsystemBase {

  // This variable and function are for managing and accessing the chasses anywhere in the code
  private static ArmsExt instance;
  public static ArmsExt getInstance(){
    if(instance == null){
      instance = new ArmsExt();
    }
    return instance;
  }

  // All actuators on the intake
  Solenoid solenoidA;
  Solenoid solenoidB;

  // Creates a new Intake. This method should only be called once
  public ArmsExt() {
    // Set up the actuators
    solenoidA = new Solenoid(PneumaticsModuleType.CTREPCM, Ports.arm_solenoid_1);
    solenoidB = new Solenoid(PneumaticsModuleType.CTREPCM, Ports.arm_solenoid_2);
  }

  boolean getExtentionA(){
    return solenoidA.get();
    }

  boolean getExtentionB(){
    return solenoidB.get();
  }

  void setExtention(boolean b) {
    solenoidA.set(b);
    solenoidB.set(b);
  }

 
}