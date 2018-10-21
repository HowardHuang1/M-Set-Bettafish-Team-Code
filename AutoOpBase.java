package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by howardhuang on 10/6/18.
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by howardhuang on 10/6/18.
 */

package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

@Autonomous(name="Autonomous")
public class AutoOpBase extends LinearOpMode {

/*
This was taken as sample code for Modern Robotics Gyro.
*/
@TeleOp(name = "Sensor: MR Gyro", group = "Sensor")
@Disabled
	public class SensorMRGyro extends LinearOpMode {

		/** In this sample, for illustration purposes we use two interfaces on the one gyro object.
		 * That's likely atypical: you'll probably use one or the other in any given situation,
		 * depending on what you're trying to do. {@link IntegratingGyroscope} (and it's base interface,
		 * {@link Gyroscope}) are common interfaces supported by possibly several different gyro
		 * implementations. {@link ModernRoboticsI2cGyro}, by contrast, provides functionality that
		 * is unique to the Modern Robotics gyro sensor.
		 */
		IntegratingGyroscope gyro;
		ModernRoboticsI2cGyro modernRoboticsI2cGyro;

		// A timer helps provide feedback while calibration is taking place
		ElapsedTime timer = new ElapsedTime();

		@Override
		public void runOpMode() {

			boolean lastResetState = false;
			boolean curResetState  = false;

			// hardware map
			modernRoboticsI2cGyro = hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");
			gyro = (IntegratingGyroscope)modernRoboticsI2cGyro;

			// Start calibrating the gyro. This takes a few seconds and is worth performing
			// during the initialization phase at the start of each opMode.
			telemetry.log().add("Gyro Calibrating. Do Not Move!");
			modernRoboticsI2cGyro.calibrate();

			// Wait until the gyro calibration is complete
			timer.reset();
			while (!isStopRequested() && modernRoboticsI2cGyro.isCalibrating())  {
				telemetry.addData("calibrating", "%s", Math.round(timer.seconds())%2==0 ? "|.." : "..|");
				telemetry.update();
				sleep(50);
			}

			telemetry.log().clear(); telemetry.log().add("Gyro Calibrated. Press Start.");
			telemetry.clear(); telemetry.update();

			// Wait for the start button to be pressed
			waitForStart();
			telemetry.log().clear();
			telemetry.log().add("Press A & B to reset heading");

			// Loop until we're asked to stop
			while (opModeIsActive())  {

				// If the A and B buttons are pressed just now, reset Z heading.
				curResetState = (gamepad1.a && gamepad1.b);
				if (curResetState && !lastResetState) {
					modernRoboticsI2cGyro.resetZAxisIntegrator();
				}
				lastResetState = curResetState;

				// The raw() methods report the angular rate of change about each of the
				// three axes directly as reported by the underlying sensor IC.
				int rawX = modernRoboticsI2cGyro.rawX();
				int rawY = modernRoboticsI2cGyro.rawY();
				int rawZ = modernRoboticsI2cGyro.rawZ();
				int heading = modernRoboticsI2cGyro.getHeading();
				int integratedZ = modernRoboticsI2cGyro.getIntegratedZValue();

				// Read dimensionalized data from the gyro. This gyro can report angular velocities
				// about all three axes. Additionally, it internally integrates the Z axis to
				// be able to report an absolute angular Z orientation.
				AngularVelocity rates = gyro.getAngularVelocity(AngleUnit.DEGREES);
				float zAngle = gyro.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;

				// Read administrative information from the gyro
				int zAxisOffset = modernRoboticsI2cGyro.getZAxisOffset();
				int zAxisScalingCoefficient = modernRoboticsI2cGyro.getZAxisScalingCoefficient();

				telemetry.addLine()
						.addData("dx", formatRate(rates.xRotationRate))
						.addData("dy", formatRate(rates.yRotationRate))
						.addData("dz", "%s deg/s", formatRate(rates.zRotationRate));
				telemetry.addData("angle", "%s deg", formatFloat(zAngle));
				telemetry.addData("heading", "%3d deg", heading);
				telemetry.addData("integrated Z", "%3d", integratedZ);
				telemetry.addLine()
						.addData("rawX", formatRaw(rawX))
						.addData("rawY", formatRaw(rawY))
						.addData("rawZ", formatRaw(rawZ));
				telemetry.addLine().addData("z offset", zAxisOffset).addData("z coeff", zAxisScalingCoefficient);
				telemetry.update();
			}
		}

		String formatRaw(int rawValue) {
			return String.format("%d", rawValue);
		}

		String formatRate(float rate) {
			return String.format("%.3f", rate);
		}

		String formatFloat(float rate) {
			return String.format("%.3f", rate);
		}

	}

	@Autonomous(name="Drive")
	public class Drive extends LinearOpMode {
		public void runOpMode() throws InterruptedException {
			Robot r = new Robot();
			r.init(hardwareMap, telemetry);
			while (opModeIsActive()) {
				r.init(hardwareMap, telemetry);
				double leftX = 0;
				double leftY = 1;
				double rightX = 0;

				final double v1 = leftY-leftX + rightX;
				final double v2 = leftY+leftX - rightX;
				final double v3 = leftY+leftX + rightX;
				final double v4 = leftY-leftX - rightX;

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
}