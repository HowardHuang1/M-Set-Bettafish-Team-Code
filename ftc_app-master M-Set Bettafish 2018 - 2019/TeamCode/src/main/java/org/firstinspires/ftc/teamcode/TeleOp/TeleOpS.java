package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.Drive;
import org.firstinspires.ftc.teamcode.Robot;

import static java.lang.Math.abs;
import static java.lang.Thread.sleep;

/**
 * Created by tejbade on 10/8/18.
 */

@TeleOp(name="tele_op")
public class TeleOpS extends LinearOpMode {
	Robot r = new Robot();
	Drive dr;
	Intake in;

	public void runOpMode() throws InterruptedException {
		// Initialize the drive system variables.
		// The init() method of the hardware class does all the work here
		r.init(hardwareMap, telemetry);
		dr = new Drive(r);
		in = new Intake(r, gamepad1, gamepad2);
		telemetry.update();
		double speed = 1;
		waitForStart();

		while (opModeIsActive()) {
			// Joystick value test
			telemetry.addData("x", gamepad1.left_stick_x + "");
			telemetry.addData("y", gamepad1.left_stick_y + "");
			telemetry.update();

			if (gamepad1.left_stick_y > 0)
				forward(speed);
			else if (gamepad1.left_stick_y < 0)
				backward(speed);
			else if (gamepad1.right_bumper)
				turnRight(speed);
			else if (gamepad1.left_bumper)
				turnLeft(speed);
			else if (gamepad1.left_stick_x > 0)
				mecanumStrafeRight(speed);
			else if (gamepad1.left_stick_x < 0)
				mecanumStrafeLeft(speed);
			else
				rest();

			in.draw();
			in.spin();

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
	}



	public void forward(double speed) {
		r.rightBack.setPower(-speed);
		r.rightFront.setPower(speed);
		r.leftBack.setPower(speed);
		r.leftFront.setPower(speed);
	}
	public void backward(double speed) {
		r.rightBack.setPower(speed);
		r.rightFront.setPower(-speed);
		r.leftBack.setPower(-speed);
		r.leftFront.setPower(-speed);
	}
	public void turnRight(double speed) {
		r.rightBack.setPower(-speed);
		r.rightFront.setPower(speed);
		r.leftBack.setPower(-speed);
		r.leftFront.setPower(-speed);
	}
	public void turnLeft(double speed) {
		r.rightBack.setPower(speed);
		r.rightFront.setPower(-speed);
		r.leftBack.setPower(speed);
		r.leftFront.setPower(speed);
	}
	public void mecanumStrafeLeft(double speed) {
		r.leftFront.setPower(-speed);
		r.leftBack.setPower(speed);
		r.rightFront.setPower(speed);
		r.rightBack.setPower(speed);
	}
	public void mecanumStrafeRight(double speed) {
		r.leftFront.setPower(speed);
		r.leftBack.setPower(-speed);
		r.rightFront.setPower(-speed);
		r.rightBack.setPower(-speed);
	}
	public void rest() {
		r.rightBack.setPower(0);
		r.rightFront.setPower(0);
		r.leftBack.setPower(0);
		r.leftFront.setPower(0);
	}

}
