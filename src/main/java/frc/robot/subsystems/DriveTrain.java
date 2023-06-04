package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.VictorSPPorts;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends SubsystemBase {
  private VictorSP m_frontLeftMotorController;
  private VictorSP m_rearLeftMotorController;
  private VictorSP m_frontRightMotorController;
  private VictorSP m_rearRightMotorController;
  private VictorSP m_midMotorController;

  private MotorControllerGroup m_leftMotorControllerGroup;
  private MotorControllerGroup m_rightMotorControllerGroup;

  public DifferentialDrive m_DifferentialDrive;

  public DriveTrain() {
    m_frontLeftMotorController = new VictorSP(VictorSPPorts.kLeftMotorGroupPort);
    m_rearLeftMotorController = new VictorSP(VictorSPPorts.kLeftMotorGroupPort);
    m_frontRightMotorController = new VictorSP(VictorSPPorts.kRightMotorGroupPort);
    m_rearRightMotorController = new VictorSP(VictorSPPorts.kRightMotorGroupPort);
    m_midMotorController = new VictorSP(VictorSPPorts.kMidMotorPort);

    m_leftMotorControllerGroup = new MotorControllerGroup(m_frontLeftMotorController, m_rearLeftMotorController);
    m_rightMotorControllerGroup = new MotorControllerGroup(m_frontRightMotorController, m_rearRightMotorController);

    m_rightMotorControllerGroup.setInverted(true);

    m_DifferentialDrive = new DifferentialDrive(m_leftMotorControllerGroup, m_rightMotorControllerGroup);
  }
  public void Move(double xspeed, double yspeed, double rotspeed) {
    m_DifferentialDrive.arcadeDrive(yspeed, rotspeed);
    m_midMotorController.set(xspeed);
  }


}