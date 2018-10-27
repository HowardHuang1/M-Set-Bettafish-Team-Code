package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by tejbade on 10/6/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by tejbade on 10/6/18.
 */
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorMRGyro;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="Autonomous")
public class AutoOpBase extends LinearOpMode {
	
	Robot r = new Robot();

	public void runOpMode() throws InterruptedException {
		r.init(hardwareMap, telemetry);
		float driveSpeed = (float) 0.8;
		float winchSpeed = 1;
		int time = 500;
		while (opModeIsActive()) {
			r.winch.setPower(winchSpeed);
			sleep(3400);
			winchSpeed = 0;
			mecanumStrafeLeft(driveSpeed, time);
			driveSpeed = 0;
			rest();
			idle();
		}
		rest();
	}

	public void forward(float power, int time) {
		r.rightBack.setPower(-power);
		r.rightFront.setPower(power);
		r.leftBack.setPower(power);
		r.leftFront.setPower(power);
		sleep(time);
	}
	public void backward(float power, int time) {
		r.rightBack.setPower(power);
		r.rightFront.setPower(-power);
		r.leftBack.setPower(-power);
		r.leftFront.setPower(-power);
		sleep(time);
	}
	public void turnRight(float power, int time) {
		r.rightBack.setPower(-power);
		r.rightFront.setPower(power);
		r.leftBack.setPower(-power);
		r.leftFront.setPower(-power);
		sleep(time);
	}
	public void turnLeft(float power, int time) {
		r.rightBack.setPower(power);
		r.rightFront.setPower(-power);
		r.leftBack.setPower(power);
		r.leftFront.setPower(power);
		sleep(time);
	}
	public void mecanumStrafeLeft(float power, int time) {
		r.leftFront.setPower(-power);
		r.leftBack.setPower(power);
		r.rightFront.setPower(power);
		r.rightBack.setPower(power);
		sleep(time);
	}
	public void mecanumStrafeRight(float power, int time) {
		r.leftFront.setPower(power);
		r.leftBack.setPower(-power);
		r.rightFront.setPower(-power);
		r.rightBack.setPower(-power);
		sleep(time);
	}
	public void rest() {
		r.rightBack.setPower(0);
		r.rightFront.setPower(0);
		r.leftBack.setPower(0);
		r.leftFront.setPower(0);
	}

}