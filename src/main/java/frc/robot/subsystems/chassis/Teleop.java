/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.chassis;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.driver_station.Controller;

/**
 * An example command that uses an example subsystem.
 */
public class Teleop extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Chassis chassis;
  private final Controller controller;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Teleop() {
    chassis = Chassis.getInstance();
    controller = Controller.getInstance();
    addRequirements(chassis);
  }

  // Called when the command is initially scheduled.
  // @Override
  // public void initialize() {

  // }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    chassis.arcadeDrive(controller.getForward(), controller.getTurn());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
