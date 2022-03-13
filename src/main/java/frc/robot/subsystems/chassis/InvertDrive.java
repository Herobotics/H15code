package frc.robot.subsystems.chassis;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class InvertDrive extends CommandBase {

	public InvertDrive() {

	}

	public void initialize() {
        System.out.println("Inverting the drive");
        Chassis.getInstance().driveScale = Chassis.getInstance().driveScale * -1;
    }

	@Override
    public boolean isFinished() {
        return true;
    }
}