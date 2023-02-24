package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    
    private WPI_VictorSPX rollerMotor = new WPI_VictorSPX(IntakeConstants.kMotorPort);

    public IntakeSubsystem(){
    }

public void setPosition(boolean open){
    if(open){
        rollerMotor.set(-1);
    }else{
        rollerMotor.set(1);
    }
  }
}

