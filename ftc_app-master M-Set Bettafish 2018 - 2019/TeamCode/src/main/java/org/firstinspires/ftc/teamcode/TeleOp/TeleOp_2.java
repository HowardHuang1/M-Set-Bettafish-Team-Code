/*package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.Drive;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.TeleOp.Lift;

import static java.lang.Math.abs;

/**
 * Created by howardhuang on 10/8/18.
 */
/*
@TeleOp(name="teleopalbert")

public class TeleOp_2 extends LinearOpMode {
	Robot r = new Robot();
	Lift l;
	Drive dr;

	public void runOpMode() throws InterruptedException {
		// Initialize the drive system variables.
		// The init() method of the hardware class does all the work here
		r.init(hardwareMap, telemetry);
		l = new Lift(hardwareMap, telemetry, gamepad1, gamepad2);
		dr = new Drive(r);
		telemetry.update();
		double speed = 1;
		waitForStart();

		while (opModeIsActive()) {
			telemetry.addData("Power: ", speed);
			telemetry.update();
			if(gamepad1.y)
				r.winch.setPower(speed);
			else if(gamepad1.a)
				r.winch.setPower(-speed);
			else
				r.winch.setPower(0);
			idle();
		}
		r.winch.setPower(0);
	}
<<<<<<< HEAD:ftc_app-master M-Set Bettafish 2018 - 2019/TeamCode/src/main/java/org/firstinspires/ftc/teamcode/TeleOp/TeleOp_2.java

	// OBSOLETE FROM HERE BELOW
	// pre-coded drive Speeds
	// Mecanum power is determined by Speed, Turn, and Strafe
	public void MecanumDrive() {
		double Speed = -gamepad1.left_stick_y;
		double Turn = gamepad1.left_stick_x;
		double Strafe = gamepad1.right_stick_x;
		double MAX_SPEED = 1.0;
		holonomic(Speed, Turn, Strafe, MAX_SPEED);
	}
// Front, Back, rightstrafe, leftstrafe
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

	double scaleInput(double dVal)  {
		double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
				0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };
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
=======
	public void backward() {
		r.rightBack.setPower(1);
		r.rightFront.setPower(-1);
		r.leftBack.setPower(-1);
		r.leftFront.setPower(-1);
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
		r.leftBack.setPower(1);
		r.rightFront.setPower(1);
		r.rightBack.setPower(1);
	}
	public void mecanumStrafeRight() {
		r.leftFront.setPower(1);
		r.leftBack.setPower(-1);
		r.rightFront.setPower(-1);
		r.rightBack.setPower(-1);
	}
	public void rest() {
		r.rightBack.setPower(0);
		r.rightFront.setPower(0);
		r.leftBack.setPower(0);
		r.leftFront.setPower(0);
>>>>>>> d1b938c53dcdb695a2f8eef6490a0fb8267f115e:ftc_app-master M-Set Bettafish 2018 - 2019/TeamCode/src/main/java/org/firstinspires/ftc/teamcode/TeleOp/TeleOp_.java
	}

}
*/