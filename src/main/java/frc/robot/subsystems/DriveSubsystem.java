// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  private CANSparkMax leftFrontMotor = new CANSparkMax(DriveConstants.leftFrontCANID, CANSparkMaxLowLevel.MotorType.kBrushless);
  private CANSparkMax leftBackMotor = new CANSparkMax(DriveConstants.leftBackCANID, CANSparkMaxLowLevel.MotorType.kBrushless);
  private CANSparkMax rightFrontMotor = new CANSparkMax(DriveConstants.rightFrontCANID, CANSparkMaxLowLevel.MotorType.kBrushless);
  private CANSparkMax rightBackMotor = new CANSparkMax(DriveConstants.rightBackCANID, CANSparkMaxLowLevel.MotorType.kBrushless);
  
  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor);
  // Encoders 
  RelativeEncoder leftEncoder = leftFrontMotor.getEncoder();
  RelativeEncoder rightEncoder = rightFrontMotor.getEncoder();
   // Unit Conversion
  private final double kEncoderTick2Meter = 1.0/4096*6*Math.PI/12;

  public double getEncoderMeters(){
    return(leftEncoder.getPosition() + -rightEncoder.getPosition()) /2  *kEncoderTick2Meter;
  }

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    // invertation settings
    rightControllerGroup.setInverted(true);
    leftControllerGroup.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Drive encoder value", getEncoderMeters());
  }

  public void setMotors(double leftSpeed, double rightSpeed){
    leftControllerGroup.set(leftSpeed);
    rightControllerGroup.set(rightSpeed);
  }












  // Forget about simulation stuff for now 
  // _____________________________________________
  @Override
  public void simulationPeriodic() {
    
  // This method will be called once per scheduler run during simulation
  }
  // Documentation Stuff
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }
}
