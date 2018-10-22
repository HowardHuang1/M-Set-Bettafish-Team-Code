package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by howardhuang on 10/6/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by howardhuang on 10/6/18.
 */
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorMRGyro;

@Autonomous(name="Autonomous")
public class AutoOpBase extends LinearOpMode {
	
	Robot r = new Robot();

	public void runOpMode() throws InterruptedException {
		SensorMRGyro gyro = new SensorMRGyro();
		Drive dt = new Drive(r);
		dt.master(0.0, 1.0, 0.0);
		
		// THIS PART WILL BE REPLACED WITH NUMBER OF ROTATIONS
		// test from Chris
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {}
		// ABOVE PART WILL BE REPLACED WIth NUMBER OF ROTATIONS
		
		dt.master(0.0, 0.0, 0.0);
		while (opModeIsActive()) {
			r.init(hardwareMap, telemetry);
		}
	}
	
}