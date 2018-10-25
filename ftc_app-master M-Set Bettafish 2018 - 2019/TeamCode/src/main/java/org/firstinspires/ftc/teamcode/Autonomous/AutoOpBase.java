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
		double speed = 0.8;
		double ppower = 1;
		int time = 1000;
		while (opModeIsActive()) {
			r.winch.setPower(-speed);
			sleep(3400);
			MecanumStrafeLeft(ppower, time);
			speed = 0;
			time = 0;
			idle();
		}
		rest();
	}
	// turn in place
	public void MecanumDriveRotateLeft(double power, int time) {
		r.leftFront.setPower(-power);
		// account for weight difference
		r.leftBack.setPower(-power/2);
		r.rightFront.setPower(power);
		// account for weight difference
		r.rightBack.setPower(power/2);
		sleep(time);
		rest();
	}
	// turn in place
	public void MecanumDriveRotateRight(double power, int time) {
		r.leftFront.setPower(power);
		// account for weight difference in the back
		r.leftBack.setPower(power/2);
		r.rightFront.setPower(-power);
		r.rightBack.setPower(-power/2);
		// acount for weight difference in the back
		sleep(time);
		rest();
	}
	public void MecanumStrafeLeft(double power, int time) {
		// wheels move in opposite directions so that forward/backward forces cancel out
		r.leftFront.setPower(power);
		r.leftBack.setPower(-power);
		r.rightFront.setPower(-power);
		r.rightBack.setPower(power);
		sleep(time);
		rest();
	}
	public void MecanumStrafeRight(double power, int time) {
		// wheels move in opposite directions so that forward/backward forces cancel out
		r.leftFront.setPower(-power);
		r.leftBack.setPower(power);
		r.rightFront.setPower(power);
		r.rightBack.setPower(-power);
		sleep(time);
		rest();
	}
	public void rest() {
		r.leftFront.setPower(0);
		r.rightBack.setPower(0);
		r.leftBack.setPower(0);
		r.rightFront.setPower(0);
		r.winch.setPower(0);
	}

}