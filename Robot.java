// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive; //imports library for running a differential drive
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.Joystick;// imports a library for communicating with a joystick

import com.revrobotics.CANSparkMax; //imports library for CAN controlled SparkMax
import com.revrobotics.CANSparkMaxLowLevel.MotorType; //imports library for SmarkMax control functions (required)

public class Robot extends TimedRobot {
  //creates names and variables
  private DifferentialDrive myRobot; //names a differential drive named myRobot
  private Joystick driverStick; //names a joystick named driverStick
  private CANSparkMax leftFrontMotor; //names CAN speed controllers named with the motor they are attached to
  private CANSparkMax leftRearMotor;
  private CANSparkMax rightFrontMotor;
  private CANSparkMax rightRearMotor;
  private MotorControllerGroup leftMotors;
  private MotorControllerGroup rightMotors;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    //creates hardware object attached to names created above
    leftFrontMotor = new CANSparkMax(1, MotorType.kBrushless); //creates a CAN speed controller for leftFrontMotor w/CAN ID #1 set for brushless mode
    leftRearMotor = new CANSparkMax(2, MotorType.kBrushless);
    rightFrontMotor = new CANSparkMax(3, MotorType.kBrushless);
    rightRearMotor = new CANSparkMax(4, MotorType.kBrushless);
    leftMotors = new MotorControllerGroup(leftFrontMotor, leftRearMotor); //groups left motors together as a slingle object called left motors
    rightMotors = new MotorControllerGroup(rightFrontMotor, rightRearMotor);
    myRobot = new DifferentialDrive(leftMotors, rightMotors);
    driverStick = new Joystick(0); //creates a new joystick on USB input 0
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    myRobot.arcadeDrive(driverStick.getY(), driverStick.getX());
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
