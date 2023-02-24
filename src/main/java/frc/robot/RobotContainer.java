package frc.robot;


import frc.robot.Constants.ElevatorConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.DriveForwardCmd;
import frc.robot.commands.ElevatorJoystickCmd;
import frc.robot.commands.ElevatorPIDCmd;
import frc.robot.commands.IntakeSetCmd;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  // Controllers
  private final Joystick drivController = new Joystick(0);

  public RobotContainer() {
    driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(driveSubsystem, () -> -drivController.getRawAxis(1), () -> drivController.getRawAxis(3)));  
    elevatorSubsystem.setDefaultCommand(new ElevatorJoystickCmd(elevatorSubsystem, 0));
    intakeSubsystem.setDefaultCommand(new IntakeSetCmd(intakeSubsystem, true));
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(drivController, OIConstants.kElevatorPIDRaiseButtonIdx)
          .whileTrue(new ElevatorPIDCmd(elevatorSubsystem, ElevatorConstants.kRaisedPosition));
    new JoystickButton(drivController, OIConstants.kElevatorJoystickRaiseButtonIdx)
          .whileTrue(new ElevatorPIDCmd(elevatorSubsystem, ElevatorConstants.kLoweredPosition));
    new JoystickButton(drivController, OIConstants.kElevatorJoystickRaiseButtonIdx)
          .whileTrue(new ElevatorJoystickCmd(elevatorSubsystem, ElevatorConstants.kJoystickMaxSpeed));
    new JoystickButton(drivController, OIConstants.kElevatorJoystickLowerButtonIdx)
          .whileTrue(new ElevatorJoystickCmd(elevatorSubsystem, -ElevatorConstants.kJoystickMaxSpeed)); // make sure this number is negative
    new JoystickButton(drivController, OIConstants.kIntakeCloseButtonIdx)
          .whileTrue(new IntakeSetCmd(intakeSubsystem, false));
  }

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(//
        new DriveForwardCmd(driveSubsystem, 1.5), //
      
        new ParallelCommandGroup( //
           new IntakeSetCmd(intakeSubsystem, false), new ElevatorPIDCmd(elevatorSubsystem, ElevatorConstants.kRaisedPosition)//
        )
    );
  }
}
