package org.usfirst.frc.team2212.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public abstract class Locker extends Subsystem {
    
	private SpeedController motor;

	public Locker(SpeedController motor) {
		this.motor = motor;
	}

	public abstract boolean isMin();

	public abstract boolean isMax();

	public boolean canMove(double speed) {
		return !(speed < 0 && isMin() || speed > 0 && isMax());
	}

	public void tryMove(double speed) {
		if (canMove(speed)) {
			motor.set(speed);
		}
	}

	public void stop() {
		motor.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
}

