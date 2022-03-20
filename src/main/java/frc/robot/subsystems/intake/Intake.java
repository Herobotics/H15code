package frc.robot.subsystems.intake;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Ports;

public class Intake extends SubsystemBase {

  // This variable and function are for managing and accessing the chasses anywhere in the code
  private static Intake instance;
  public static Intake getInstance(){
    if(instance == null){
      instance = new Intake();
    }
    return instance;
  }

  // All actuators on the intake
  VictorSP axle;
  // Peacock


  // Creates a new Intake. This method should only be called once
  private Intake() {
    // Set up the actuators
    axle = new VictorSP(Ports.intake_axle);
   
  }
  
  void intakeAxle(double speed){
    axle.set(speed);
  }
}
