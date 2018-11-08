package org.firstinspires.ftc.teamcode.Autonomous;

/**
 * Created by tejbade on 10/6/18.
 */

/**
 * Created by tejbade on 10/6/18.
 */

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.TeleOp.Drive;

public class AutoOpBase {

	Drive d = new Drive();

	public void driveForwardDistance(int forwardInches) {
			int newRightTarget = d.rightBack.getCurrentPosition() + (int) (forwardInches * d.COUNTS_PER_INCH);
			int newLeftTarget = d.leftBack.getCurrentPosition() + (int) (forwardInches)
	}
	public void driveBackwardDistance() {

	}
	public void turnLeftToAngle (int measure) {

	}
	public void turnRightToAngle () {

	}
	public boolean isLeftJewelGold(){
		d.left.enableLed(true);
		if(d.left.red() > d.left.blue())
			return true;
		else
			return false;
	}

	public boolean isRightJewelGold(){
		d.right.enableLed(true);
		if(d.right.red() > d.right.blue())
			return true;
		else
			return false;
	}

}
