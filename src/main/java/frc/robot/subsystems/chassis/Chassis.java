package frc.robot.subsystems.chassis;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Ports;

public class Chassis extends SubsystemBase {

  // This variable and function are for managing and accessing the chasses anywhere in the code
  public static Chassis instance;
  public static Chassis getInstance(){
    if(instance == null){
      instance = new Chassis();
    }
    return instance;
  }

  // All motors on the chassis
  VictorSP left1;
  VictorSP left2;

  VictorSP right1;
  VictorSP right2;

  public double driveScale = -1;

  // Creates a new Chassis. This method should only be called once
  public Chassis() {
    // Set up the motors
    left1 = new VictorSP(Ports.chassis_left_1);
    left2 = new VictorSP(Ports.chassis_left_2);

    right1 = new VictorSP(Ports.chassis_right_1);
    right2 = new VictorSP(Ports.chassis_right_2);
  }

  // Control the chassis with tank drive with this function
  public void tankDrive(double left, double right){
    left1.set(left*driveScale);
    left2.set(left*driveScale);
    
    right1.set(-right*driveScale);
    right2.set(-right*driveScale);
  }

  // Control the chassis with arcade drive with this function
  public void arcadeDrive(double forward, double turn){
    arcadeDrive(forward, turn, true);
  }

  // Arcade drive with optinal squared inputs
  void arcadeDrive(double forward, double turn, boolean square){
    
    if (driveScale < 0) {
			turn *= -1;
		}
		// square inputs preserving sign
		if (square) {
			forward = forward * forward * (forward / Math.abs(forward));
			turn = turn * turn * (turn / Math.abs(turn));
		}

		double max = Math.max(Math.abs(forward), Math.abs(turn));
		double difference = forward - turn;
		double total = forward + turn;

    double left;
    double right;
    
		if (forward >= 0.0) {
			// First quadrant
			if (turn >= 0.0) {
				left = max;
				right = difference;
			}
			// Second quadrant
			else {
				left = total;
				right = max;
			}
		} else {
			// Fourth quadrant
			if (turn >= 0.0) {
				left = total;
				right = -max;
			}
			// Third quadrant
			else {
				left = -max;
				right = difference;
			}
		}

    this.tankDrive(left, right);
  }

public double getRotation() {
	return 0;
}

public double getAverageDistance() {
	return 0;
}
}
