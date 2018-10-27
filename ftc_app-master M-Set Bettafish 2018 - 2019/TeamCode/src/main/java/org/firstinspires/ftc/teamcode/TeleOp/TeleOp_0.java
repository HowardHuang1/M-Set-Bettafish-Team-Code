package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.Drive;
import org.firstinspires.ftc.teamcode.Robot;

import static java.lang.Math.abs;

/**
 * Created by tejbade on 10/8/18.
 */

@TeleOp(name="teleoptej")
public class TeleOp_0 extends LinearOpMode {
	Robot r = new Robot();
	Drive dr;

	public void runOpMode() throws InterruptedException {
		// Initialize the drive system variables.
		// The init() method of the hardware class does all the work here
		r.init(hardwareMap, telemetry);
		dr = new Drive(r);
		telemetry.update();
		double speed = 1;
		waitForStart();

		while (opModeIsActive()) {
			// Joystick value test
			telemetry.addData("x", gamepad1.left_stick_x + "");
			telemetry.addData("y", gamepad1.left_stick_y + "");
			telemetry.update();

			if (gamepad1.left_stick_y > 0)
				forward();
			else if (gamepad1.left_stick_y < 0)
				backward();
			else if (gamepad1.right_bumper)
				turnRight();
			else if (gamepad1.left_bumper)
				turnLeft();
			else if (gamepad1.left_stick_x > 0)
				mecanumStrafeRight();
			else if (gamepad1.left_stick_x < 0)
				mecanumStrafeLeft();
			else
				rest();

			if (gamepad2.y) {
				r.intake.setPower(0.3);
			} else if (gamepad2.a)
				r.intake.setPower(-0.3);
		}

		if (gamepad2.x) {
			r.intakeArm.setPower(-0.3);
		} else if (gamepad2.b) {
			r.intakeArm.setPower(0.3);
		}

		if (gamepad1.right_trigger > 0) {
			speed = speed + 0.2;
			sleep(200);
		} else if (gamepad1.left_trigger > 0) {
			speed = speed - 0.2;
			sleep(200);
		}


		if (gamepad2.dpad_up)
			r.winch.setPower(0.4);
		else if (gamepad2.dpad_down)
			r.winch.setPower(-0.4);
		else
			r.winch.setPower(0);

		idle();
	}



	public void forward() {
		r.rightBack.setPower(-1);
		r.rightFront.setPower(1);
		r.leftBack.setPower(1);
		r.leftFront.setPower(1);
	}
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
	}

}
