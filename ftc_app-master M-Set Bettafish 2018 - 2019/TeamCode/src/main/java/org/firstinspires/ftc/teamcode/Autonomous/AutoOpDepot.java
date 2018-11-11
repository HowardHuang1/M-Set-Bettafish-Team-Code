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
import org.firstinspires.ftc.teamcode.TeleOp.Drive;
import org.firstinspires.ftc.teamcode.Autonomous.AutoOpBase;


@Autonomous(name="Depot")
public class AutoOpDepot extends AutoOpBasic {

    Drive r = new Drive();

    public void runOpMode() throws InterruptedException {
        r.init(hardwareMap, telemetry);

        waitForStart();
        basicFS(); // condensed basic first steps from AutoOpBasic.

        // release the team marker
        while(opModeIsActive()) {
            r.bottomIntakeArm.setPower(1);
            r.topIntakeArm.setPower(1);
        }

        r.stop();


    }

}