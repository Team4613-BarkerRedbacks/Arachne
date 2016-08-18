package redbacks.arachne.lib.motors;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * @author Sean Zammit
 */
public class CtrlDrivetrain extends RobotDrive
{
	public static ArrayList<CtrlDrivetrain> drivetrains = new ArrayList<CtrlDrivetrain>();
	
	public CtrlDrivetrain(CtrlDrive leftMotor, CtrlDrive rightMotor) {
		super(leftMotor, rightMotor);
		drivetrains.add(this);
	}

	public CtrlDrivetrain(CtrlDrive frontLeftMotor, CtrlDrive rearLeftMotor, CtrlDrive frontRightMotor, CtrlDrive rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		drivetrains.add(this);
	}
	
	//TODO Rename method
	public void setMotorOutputs() {
		if(m_frontLeftMotor != null) {
			m_frontLeftMotor.set(m_frontLeftMotor.get() * m_maxOutput, m_syncGroup);
		}
		m_rearLeftMotor.set(m_rearLeftMotor.get() * m_maxOutput, m_syncGroup);

		if(m_frontRightMotor != null) {
			m_frontRightMotor.set(-m_frontRightMotor.get() * m_maxOutput, m_syncGroup);
		}
		m_rearRightMotor.set(-m_rearRightMotor.get() * m_maxOutput, m_syncGroup);

		if(this.m_syncGroup != 0) CANJaguar.updateSyncGroup(m_syncGroup);
		if(m_safetyHelper != null) m_safetyHelper.feed();
	}
}
