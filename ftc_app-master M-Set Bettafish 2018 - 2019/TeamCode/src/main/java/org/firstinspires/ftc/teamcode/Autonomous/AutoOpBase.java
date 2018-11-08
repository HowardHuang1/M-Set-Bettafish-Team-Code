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

	public void driveForwardDistance() {
		if(opModeIsActive()) {
			int newRightTarget = d.rightBack.getCurrentPosition() + (int) (forwardInches * d.COUNTS_PER_INCH);
			int newLeftTarget = d.leftBack.getCurrentPosition() + (int) (forward)
		}
	}
	public void driveBackwardDistance() {

	}
	public void turnLeftToAngle () {

	}
	public void turnRightToAngle () {

	}
	public boolean isLeftJewelGold(){

		return true;
	}

	public boolean isRightJewelGold(){
		return false;
	}

}
