package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorMRGyro;

/**
 * Created by howardhuang on 10/6/18.
 * <p>
 * Created by howardhuang on 10/6/18.
 */
/**
 * Created by howardhuang on 10/6/18.
 */

@Autonomous(name="LiftTest")
public class LiftTest extends LinearOpMode {


	public void runOpMode() throws InterruptedException {

		Robot r = new Robot();
		double speed = 1;
		r.init(hardwareMap, telemetry);

		waitForStart();
		while (opModeIsActive()) {
			r.winch.setPower(speed);
			sleep(10000);
			r.winch.setPower(-speed);
			sleep(3000);
			speed=0;
			idle();
		}
	}
	
}