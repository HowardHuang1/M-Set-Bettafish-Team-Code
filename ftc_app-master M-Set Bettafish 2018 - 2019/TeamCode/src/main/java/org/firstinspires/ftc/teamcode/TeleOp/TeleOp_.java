package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.Drive;
import org.firstinspires.ftc.teamcode.Robot;

import static java.lang.Math.abs;

/**
 * Created by tejbade on 10/8/18.
 */

@TeleOp(name="teleop")
public class TeleOp_ extends LinearOpMode {
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

			if(gamepad1.dpad_up)
				forward();
			else if(gamepad1.dpad_down)
				backward();
			else if(gamepad1.right_bumper)
				turnRight();
			else if(gamepad1.left_bumper)
				turnLeft();
			else if(gamepad1.dpad_right)
				mecanumStrafeRight();
			else if(gamepad1.dpad_left)
				mecanumStrafeLeft();
			else
				rest();


			if(gamepad2.y)
				r.winch.setPower(0.4);
			else if(gamepad2.a)
				r.winch.setPower(-0.4);
			else
				r.winch.setPower(0);

			idle();
		}
		rest();
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
