package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="driver")
public class DTTest extends LinearOpMode {

    Robot r = new Robot();

    public void runOpMode() throws InterruptedException {
        int leftX = 0;
        int leftY = 1;
        int rightX = 0;

        final double v1 = leftY-leftX + rightX;
        final double v2 = leftY+leftX - rightX;
        final double v3 = leftY+leftX + rightX;
        final double v4 = leftY-leftX - rightX;

        while(opModeIsActive()) {
            r.init(hardwareMap, telemetry);

            r.leftFront.setPower(scaleInput(v3));
            r.rightFront.setPower(scaleInput(v4));
            r.leftBack.setPower(scaleInput(v1));
            r.rightBack.setPower(scaleInput(v2));
        }
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
        if (index > 16) {
            index = 16;
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
