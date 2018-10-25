package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Lift {
	Robot r = new Robot();
	Gamepad gp1, gp2;

	public Lift(Robot r, Gamepad gp1, Gamepad gp2) {
		this.r=r;

		this.gp1 = gp1;
		this.gp2 = gp2;
	}

	// detects button press and adjusts lift motor
	public void detectBP() {
		r.winch.setPower(0);
		// lift goes one way if you press a
		if(gp1.a)
			r.winch.setPower(1);
		// lift goes other way if you press b
		else if(gp1.b)
			r.winch.setPower(-1);
		// lift stops moving if you press nothing
		else
			r.winch.setPower(0);
	}
}
