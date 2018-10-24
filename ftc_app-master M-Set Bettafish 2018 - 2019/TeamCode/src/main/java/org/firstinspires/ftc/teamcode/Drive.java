package org.firstinspires.ftc.teamcode;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Drive {
	Robot r;
	
	public Drive(Robot r) {
		this.r=r;
	}

	// master program which drives the drive train
	public void master(double leftX, double leftY, double rightX) {
		
		final double v1 = leftY-leftX + rightX;
		final double v2 = leftY+leftX - rightX;
		final double v3 = leftY+leftX + rightX;
		final double v4 = leftY-leftX - rightX;
		
		r.leftFront.setPower(-v3); // 3
		r.rightFront.setPower(-v4); // -4
		r.leftBack.setPower(v3); // 1
		r.rightBack.setPower(-v4); // -2
		
	}
	double scaleInput(double dVal)  {
		double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
				0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };
		// get the corresponding index for the scaleInput array.
		int index = (int) (dVal * 16.0);
		// index should be positive.
		if (index < 0) {
			index = -index;
		}
		// index cannot exceed size of array minus 1.
		if (index > scaleArray.length) {
			index = scaleArray.length;
		}
		// get value from the array.
		double dScale = 0.0;
		if (dVal < 0) {
			dScale = -scaleArray[index];
		} else {
			dScale = scaleArray[index];
		}
		// return scaled value.
		return dScale;
	}
}