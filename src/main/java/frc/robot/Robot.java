/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.leds.Leds;
import frc.robot.subsystems.mallet.MalletExt;
import frc.robot.subsystems.arms.ArmsExt;
import frc.robot.subsystems.chassis.Chassis;
import edu.wpi.first.cameraserver.CameraServer;


//import frc.robot.autonomous.*;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command autonomousCommand;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    CommandScheduler.getInstance().setDefaultCommand(Chassis.getInstance(), new frc.robot.subsystems.chassis.Teleop());
    CommandScheduler.getInstance().setDefaultCommand(Intake.getInstance(), new frc.robot.subsystems.intake.Teleop());
    CommandScheduler.getInstance().setDefaultCommand(MalletExt.getInstance(), new frc.robot.subsystems.mallet.Teleop());
    CommandScheduler.getInstance().setDefaultCommand(ArmsExt.getInstance(), new frc.robot.subsystems.arms.Teleop());
    CommandScheduler.getInstance().setDefaultCommand(Leds.getInstance(), new frc.robot.subsystems.leds.Teleop());
    CameraServer.startAutomaticCapture();
    CameraServer.startAutomaticCapture();
  }


  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    Leds.getInstance().LEDBufSet();
    Leds.getInstance().startLEDs();

  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
    if (Leds.getInstance().getAuto() == true) {
      Leds.getInstance().setAuto(!Leds.getInstance().getAuto());
    }
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    Leds.getInstance().setAuto(!Leds.getInstance().getAuto());
    MalletExt.getInstance().setExtention(!MalletExt.getInstance().getExtention());
    Timer.delay(1);
    MalletExt.getInstance().setExtention(!MalletExt.getInstance().getExtention());
    Timer.delay(2);
    //Chassis.getInstance().tankDrive(1, 1);
    

    }
    
  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().schedule();
    
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
      
      
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().schedule();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }
}
