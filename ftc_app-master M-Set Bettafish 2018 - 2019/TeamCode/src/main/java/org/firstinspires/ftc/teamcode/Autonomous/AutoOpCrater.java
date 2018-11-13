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
public class AutoOpCrater extends AutoOpBasic {

    Robot r = new Robot();


    public void runOpMode() throws InterruptedException {
        r.init(hardwareMap, telemetry);
        while (opModeIsActive()) {

            basicFS(); // basic first steps, all condensed in AutoOpBasic
            r.bottomIntakeArm.setPower(1);
            r.topIntakeArm.setPower(1);
            sleep(10000);
            r.bottomIntakeArm.setPower(0);
            r.topIntakeArm.setPower(0);
            // intake can't run for full autonomous because it needs to go to the crater and extend the intake

        }

    }

}