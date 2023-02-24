// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  // Drive Train Constants 
public static final class DriveConstants{
  public static final int leftFrontCANID = 3;
  public static final int leftBackCANID = 4;
  public static final int rightFrontCANID = 2; // inverted
  public static final int rightBackCANID = 1; // inverted
  public static final double kEncoderTick2Meter = 1.0 / 4096.0 * 0.128 * Math.PI;

  public static final double kAutoDriveForwardSpeed = 0.5;
  public static final double kAutoDriveForwardDistance = 1.5;
  }

  // Elevator Constants
public final class ElevatorConstants{
  public static final int kMotorPort = 6;
  public static final int kEncoderChannelA = 4;
  public static final int kEncoderChannelB = 5;
  public static final double kEncoderTick2Meter = 1.0 / 4096.0 * 0.1 * Math.PI;
  public static final double kP = 3;
  public static final double kI = 0;
  public static final double kD = 0.8;

  public static final double kRaisedPosition = 0.9;
  public static final double kLoweredPosition = 0;
  public static final double kJoystickMaxSpeed = 0.5;
 } 
 // Intake Constants
 public final class IntakeConstants{
  public static final int kMotorPort = 5;
  public static final double kOpenSpeed = 1;
  public static final double kCloseSpeed = 1;
 }
 // Joystick constants 
 public final class  OIConstants{
  public static final int kDriverControllerPort = 0;

  public static final int kArcadeDriveSpeedAxis = 1;
  public static final int kArcadeDriveTurnAxis = 3;

  public static final int kElevatorPIDRaiseButtonIdx = 1;
  public static final int kElevatorPIDLowerButtonIDx = 2;
  public static final int kElevatorJoystickRaiseButtonIdx = 3;
  public static final int kElevatorJoystickLowerButtonIdx = 4;
  public static final int kIntakeCloseButtonIdx = 5;
 }
}

