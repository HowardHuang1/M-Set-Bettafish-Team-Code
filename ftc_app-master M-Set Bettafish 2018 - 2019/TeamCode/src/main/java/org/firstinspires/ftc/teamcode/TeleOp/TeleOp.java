package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.Drive;
import org.firstinspires.ftc.teamcode.Robot;

import static java.lang.Math.abs;

/**
 * Created by tejbade on 10/8/18.
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="TeleOpOld")
public class TeleOp extends LinearOpMode {
	Robot r = new Robot();
	Drive dr;

	public void runOpMode() throws InterruptedException {
		// Initialize the drive system variables.
		// The init() method of the hardware class does all the work here
		r.init(hardwareMap, telemetry);
		dr = new Drive(r);
		telemetry.update();
		waitForStart();

		while (opModeIsActive()) {
			// Joystick value test
			telemetry.addData("x", gamepad1.left_stick_x + "");
			telemetry.addData("y", gamepad1.left_stick_y + "");
			telemetry.update();

			if (gamepad1.left_stick_y > 0.2)
				forward();
			else if (gamepad1.left_stick_y < -0.2)
				backward();
			else if (gamepad1.right_bumper)
				turnRight();
			else if (gamepad1.left_bumper)
				turnLeft();
			else if (gamepad1.left_stick_x > 0.2)
				mecanumStrafeRight();
			else if (gamepad1.left_stick_x < -0.2)
				mecanumStrafeLeft();
			else
				rest();

			if (gamepad2.y) {
				r.intake.setPower(1);
			} else if (gamepad2.a)
				r.intake.setPower(-1);
			else
				r.intake.setPower(0);

			if (gamepad2.x) {
				r.intakeArm.setPower(-1);
			} else if (gamepad2.b) {
				r.intakeArm.setPower(1);
			} else
				r.intakeArm.setPower(0);

			if (gamepad2.dpad_up)
				r.winch.setPower(1);
			else if (gamepad2.dpad_down)
				r.winch.setPower(-1);
			else
				r.winch.setPower(0);

			idle();
		}
		rest();
	}


	public void forward() {
		r.rightBack.setPower(0.8);
		r.rightFront.setPower(-1);
		r.leftBack.setPower(-0.8);
		r.leftFront.setPower(-1);
	}
	public void backward() {
		r.rightBack.setPower(-0.8);
		r.rightFront.setPower(1);
		r.leftBack.setPower(0.8);
		r.leftFront.setPower(1);
	}
	public void turnRight() {
		r.rightBack.setPower(-1);
		r.rightFront.setPower(1);
		r.leftBack.setPower(-1);
		r.leftFront.setPower(-1);
	}
	public void turnLeft() {
		r.rightBack.setPower(1);
		r.rightFront.setPower(-1);
		r.leftBack.setPower(1);
		r.leftFront.setPower(1);
	}
	public void mecanumStrafeLeft() {
		r.leftFront.setPower(-1);
		r.leftBack.setPower(0.8);
		r.rightFront.setPower(1);
		r.rightBack.setPower(0.8);
	}
	public void mecanumStrafeRight() {
		r.leftFront.setPower(1);
		r.leftBack.setPower(-0.8);
		r.rightFront.setPower(-1);
		r.rightBack.setPower(-0.8);
	}
	public void rest() {
		r.rightBack.setPower(0);
		r.rightFront.setPower(0);
		r.leftBack.setPower(0);
		r.leftFront.setPower(0);
	}
	public void holonomic(double Speed, double Turn, double Strafe, double MAX_SPEED) {
//EQ:      Left Front = +Speed + Turn - Strafe      Right Front = +Speed - Turn + Strafe
//EQ:      Left Rear  = +Speed + Turn + Strafe      Right Rear  = +Speed - Turn - Strafe

		double Magnitude = abs(Speed) + abs(Turn) + abs(Strafe);
		Magnitude = (Magnitude > 1) ? Magnitude : 1; //Set scaling to keep -1,+1 range

		r.leftFront.setPower(scaleInput(Speed) + scaleInput(Turn) - scaleInput(Strafe));
		if (r.leftBack != null) {
			r.leftBack.setPower(scaleInput(Speed) + scaleInput(Turn) + scaleInput(Strafe));
		}
		r.rightFront.setPower(scaleInput(Speed) - scaleInput(Turn) + scaleInput(Strafe));
		if (r.rightBack != null) {
			r.rightBack.setPower(scaleInput(Speed) - scaleInput(Turn) - scaleInput(Strafe));
		}
	}

	double scaleInput(double dVal) {
		double[] scaleArray = {0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
				0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00};
		// get the corresponding index for the scaleInput array.
		int index = (int) (dVal * 16.0);
		// index should be positive.
		if (index < 0) {
			index = -index;
		}
		// index cannot exceed size of array minus 1.
		if (index > scaleArray.length) {
			index = scaleArray.length;
		}
		// get value from the array.
		double dScale = 0.0;
		if (dVal < 0) {
			dScale = -scaleArray[index];
		} else {
			dScale = scaleArray[index];
		}
		// return scaled value.
		return dScale;
	}
}
