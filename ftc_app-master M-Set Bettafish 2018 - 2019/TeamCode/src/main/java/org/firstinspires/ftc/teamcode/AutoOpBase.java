package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by howardhuang on 10/6/18.
 */

@Autonomous(name="duehoang")
public class AutoOpBase extends LinearOpMode{
	public void runOpMode() {
		while (true) {
			double leftX = 0;
			double leftY = 1;
			double rightX = 0;
			
			final double v1 = leftY-leftX + rightX;
			final double v2 = leftY+leftX - rightX;
			final double v3 = leftY+leftX + rightX;
			final double v4 = leftY-leftX - rightX;
			
			leftFront.setPower(v3);
			rightFront.setPower(v4);
			leftBack.setPower(v1);
			rightBack.setPower(v2);
			
		}		
	}
}
