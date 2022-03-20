/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.mallet;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.driver_station.Controller;

public class Teleop extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final MalletExt malletExt;
  /**
   * @param subsystem The subsystem used by this command.
   */
  public Teleop() {
    malletExt = MalletExt.getInstance();
    
    Controller.getInstance();
    addRequirements(malletExt);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}