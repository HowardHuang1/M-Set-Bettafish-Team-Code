package org.firstinspires.ftc.teamcode.Autonomous;

/**
 * Created by tejbade on 10/6/18.
 */

/**
 * Created by tejbade on 10/6/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot;

public abstract class AutoOpBase extends LinearOpMode {

	Robot r = new Robot();

	public void initRobot() throws InterruptedException {
		r.init(hardwareMap, telemetry);
		r.resetEncoders();
		r.setUseEncoderMode();
	}

	public void driveForwardDistance(double maintainAngle, int forwardInches, double driveSpeed) {
		if (opModeIsActive()) {
			int newRightBackTarget = r.rightBack.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
			int newLeftBackTarget = r.leftBack.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
			int newRightFrontTarget = r.rightFront.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
			int newLeftFrontTarget = r.leftFront.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);

			r.rightBack.setTargetPosition(newRightBackTarget);
			r.rightFront.setTargetPosition(newRightFrontTarget);
			r.leftBack.setTargetPosition(newLeftBackTarget);
			r.leftFront.setTargetPosition(newLeftFrontTarget);

			r.setRunToPositionMode();

			r.driveForward(driveSpeed);

			while (opModeIsActive() && r.isBusy()) {
				float newAngle = r.getCurrentAngle();
				if (newAngle != maintainAngle && Math.abs(newAngle - maintainAngle) > 1) {
					if (newAngle < maintainAngle) {
						// bot veered right. give less power to the left motor.
						r.driveForward(driveSpeed, r.LEAN_LEFT);
					} else {
						// bot veered left. give less power to the right motor.
						r.driveForward(driveSpeed, r.LEAN_RIGHT);
					}
				} else {
					r.driveForward(driveSpeed, r.GO_STRAIGHT);
				}

				double endAngle = r.getCurrentAngle();

				telemetry.addData("Angle: ", "Start: " + maintainAngle + " End: " + endAngle);
				telemetry.update();
			}

			r.stopDriving();
			r.setUseEncoderMode();
		}
	}

	public void driveForwardDistance(int forwardInches, double driveSpeed) {
		int newRightBackTarget;
		int newLeftBackTarget;
		int newRightFrontTarget;
		int newLeftFrontTarget;

		if (opModeIsActive()) {
			newRightBackTarget = r.rightBack.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
			newLeftBackTarget = r.leftBack.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
			newRightFrontTarget = r.rightFront.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
			newLeftFrontTarget = r.leftFront.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);

			r.rightBack.setTargetPosition(newRightBackTarget);
			r.rightFront.setTargetPosition(newRightFrontTarget);
			r.leftBack.setTargetPosition(newLeftBackTarget);
			r.leftFront.setTargetPosition(newLeftFrontTarget);

			r.setRunToPositionMode();

			r.driveForward(driveSpeed);

			while (opModeIsActive() && r.isBusy()) {
				// Do nothing.
			}

			r.stopDriving();
			r.setUseEncoderMode();
		}
	}

	public void driveBackwardDistance(double maintainAngle, int backwardInches, double driveSpeed) {
		backwardInches = -1 * backwardInches;

		if (opModeIsActive()) {
			int newRightBackTarget = r.rightBack.getCurrentPosition() + (int) (backwardInches * r.COUNTS_PER_INCH);
			int newLeftBackTarget = r.leftBack.getCurrentPosition() + (int) (backwardInches * r.COUNTS_PER_INCH);
			int newRightFrontTarget = r.rightFront.getCurrentPosition() + (int) (backwardInches * r.COUNTS_PER_INCH);
			int newLeftFrontTarget = r.leftFront.getCurrentPosition() + (int) (backwardInches * r.COUNTS_PER_INCH);

			r.rightBack.setTargetPosition(newRightBackTarget);
			r.rightFront.setTargetPosition(newRightFrontTarget);
			r.leftBack.setTargetPosition(newLeftBackTarget);
			r.leftFront.setTargetPosition(newLeftFrontTarget);

			r.setRunToPositionMode();

			r.driveBackward(driveSpeed);

			while (opModeIsActive() && r.isBusy()) {
				float newAngle = r.getCurrentAngle();
				if (newAngle != maintainAngle && Math.abs(newAngle - maintainAngle) > 1) {
					if (newAngle < maintainAngle) {
						// bot veered right. give less power to the left motor.
						r.driveBackward(driveSpeed, r.LEAN_LEFT);
					} else {
						// bot veered left. give less power to the right motor.
						r.driveBackward(driveSpeed, r.LEAN_RIGHT);
					}
				} else {
					r.driveBackward(driveSpeed, r.GO_STRAIGHT);
				}

				double endAngle = r.getCurrentAngle();

				telemetry.addData("Angle: ", "Start: " + maintainAngle + " End: " + endAngle);
				telemetry.update();
			}

			r.stopDriving();
			r.setUseEncoderMode();
		}
	}

	public void driveBackwardDistance(int backwardInches, double driveSpeed) {
		driveBackwardDistance(-1 * backwardInches, driveSpeed);
	}


	public void turnLeftToAngle () {

	}
	public void turnRightToAngle () {

	}
	public boolean isLeftJewelGold(){

		return true;
	}

	public boolean isRightJewelGold(){
		return false;
	}

}
