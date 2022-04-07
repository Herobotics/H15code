/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.chassis;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveTime extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  public final Chassis chassis;

  /**
   * @param subsystem The subsystem used by this command.
   */
  public DriveTime(double timeout) {
    chassis = Chassis.getInstance();
    addRequirements(chassis);
    withTimeout(timeout);
  }


  @Override
  public void execute() {
    chassis.arcadeDrive(.5, 0);
  }

  public void end(boolean interrupted) {
    chassis.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


  
}
