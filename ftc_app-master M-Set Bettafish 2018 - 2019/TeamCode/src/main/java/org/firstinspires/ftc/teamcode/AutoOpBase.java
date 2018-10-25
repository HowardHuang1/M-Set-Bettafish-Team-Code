package org.firstinspires.ftc.teamcode;

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

@Autonomous(name="Autonomous")
public class AutoOpBase extends LinearOpMode {
	
	Robot r = new Robot();

	public void runOpMode() throws InterruptedException {
		r.init(hardwareMap, telemetry);
		double speed = 1;
		double time = 1000;
		while (opModeIsActive()) {
			r.winch.setPower(-speed);
			sleep(5000);
			MecanumDriveLeft(speed, time);
			speed = 0;
			time = 0;
			idle();
		}
		rest();
	}
	public void MecanumDriveLeft(double power, double time) {
		r.leftFront.setPower(power);
		r.rightBack.setPower(power);
		r.leftFront.setPower(-power);
		r.leftFront.setPower(-power);
		sleep((long) time);
		rest();
	}
	public void MecanumDriveRight(int power) {
		r.leftFront.setPower(-power);
		r.rightBack.setPower(-power);
		r.leftFront.setPower(power);
		r.leftFront.setPower(power);
	}
	public void rest() {
		r.leftFront.setPower(0);
		r.rightBack.setPower(0);
		r.leftFront.setPower(0);
		r.leftFront.setPower(0);
		r.winch.setPower(0);
	}

}