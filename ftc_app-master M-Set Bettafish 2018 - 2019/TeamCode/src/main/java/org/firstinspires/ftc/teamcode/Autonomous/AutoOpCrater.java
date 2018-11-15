package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by tejbade on 10/6/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by tejbade on 10/6/18.
 */
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorMRGyro;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="Crater")
public class AutoOpCrater extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        startRobot();

        r.rightBack.setPower(0.8);
        r.rightFront.setPower(1);
        r.leftBack.setPower(0.8);
        r.leftFront.setPower(-1);
        sleep(500);

        driveForwardDistance(r.getCurrentAngle(), 15, 1);

        r.rightBack.setPower(-0.8);
        r.rightFront.setPower(-1);
        r.leftBack.setPower(-0.8);
        r.leftFront.setPower(1);
        sleep(5000);

        turnLeftToAngle(135);

        driveForwardDistance(r.getCurrentAngle(), 12, 1);

        r.intakeArm.setPower(1);
        r.intake.setPower(-1);
        sleep(400);
        r.intake.setPower(0);
        r.intakeArm.setPower(-1);

        turnLeftToAngle(180);

        driveForwardDistance(65, 1);

        r.intakeArm.setPower(-1);

        while (opModeIsActive()) {
            idle();
        }

        r.stop();
    }

}