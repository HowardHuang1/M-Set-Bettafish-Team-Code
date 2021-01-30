package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.*;

// DUE HOANG

public class TeleOp extends LinearOpMode {
	// mecanum wheels
	private DcMotor leftFront;
	private DcMotor rightFront;
	private DcMotor leftBack;
	private DcMotor rightBack;
	private DcMotor intake; // constantly runs
	private Servo intakeArm;
	
	public void runOpMode() {
		leftFront = hardwareMap.get(DcMotor.class, "lf");
		rightFront = hardwareMap.get(DcMotor.class, "rf");
		leftBack = hardwareMap.get(DcMotor.class, "lb");
		rightBack = hardwareMap.get(DcMotor.class, "rb");
		intake = hardwareMap.get(DcMotor.class, "is"); // intake spin
		intakeArm = hardwareMap.get(Servo.class, "ia"); // intake arm
		
		telemetry.addData("Status", "Initialized");
		telemetry.update();
		
		// wait for the game to start !
		waitForStart();
		
		// run till the end
		while(opModeIsActive()) {
			// is now running
			telemetry.addData("Status", "Running");
			telemetry.update();
			// move the mecanums
			double leftX = gamepad1.left_stick_x;
			double leftY = gamepad1.left_stick_y;
			double rightX = gamepad1.right_stick_x;
			
			final double v1 = leftY-leftX + rightX;
			final double v2 = leftY+leftX - rightX;
			final double v3 = leftY+leftX + rightX;
			final double v4 = leftY-leftX - rightX;
			
			leftFront.setPower(v1);
			rightFront.setPower(v2);
			leftBack.setPower(v3);
			rightBack.setPower(v4);
			
			// constantly rotate the intake at full power
			intake.setPower(1);
			
		}
	}
}
