package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.*;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
@Autonomous(name="duehoang")
public class Auton extends LinearOpMode {
	
	// private ColorSensor front;
	
	private DcMotor leftFront;
	private DcMotor rightFront;
	private DcMotor leftBack;
	private DcMotor rightBack;
	// private DcMotor intake; // constantly runs but only in teleop
	// private Servo intakeArm; // just set to 0
	
	@Override
	public void runOpMode() {
		leftFront = hardwareMap.get(DcMotor.class, "lf");
		rightFront = hardwareMap.get(DcMotor.class, "rf");
		leftBack = hardwareMap.get(DcMotor.class, "lb");
		rightBack = hardwareMap.get(DcMotor.class, "rb");
		// front = hardwareMap.get(ColorSensor.class, "fr");
		// intake = hardwareMap.get(DcMotor.class, "is"); // intake spin
		// intakeArm = hardwareMap.get(Servo.class, "ia"); // intake arm
		
		// intakeArm.setPosition(0);
		
		// front.enableLed(true);
		
		while (true) {
			double leftX = 0;
			double leftY = 1;
			double rightX = 0;
			
			final double v1 = leftY-leftX + rightX;
			final double v2 = leftY+leftX - rightX;
			final double v3 = leftY+leftX + rightX;
			final double v4 = leftY-leftX - rightX;
			
			leftFront.setPower(v1);
			rightFront.setPower(v2);
			leftBack.setPower(v3);
			rightBack.setPower(-v4);
		}
	}
	
}
