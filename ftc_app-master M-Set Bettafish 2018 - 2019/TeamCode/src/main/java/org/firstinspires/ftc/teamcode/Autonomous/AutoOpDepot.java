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
public class AutoOpDepot extends AutoOpBase {

    Drive r = new Drive();

    public void runOpMode() throws InterruptedException {
        r.init(hardwareMap, telemetry);

        waitForStart();
            //hang
            r.winch.setPower(1);
            sleep(4000);

            r.winch.setPower(0);
            r.mecanumStrafeLeft(1);
            sleep(800);

            r.rest();
            sleep(300);

            r.backward(1);
            sleep(100);
            r.bottomIntakeArm.setPower(1);
            r.topIntakeArm.setPower(1);
            r.forward(1);
            sleep(1000);
            r.rest();

            r.intake.setPower(1);
            sleep(3000);
            r.intake.setPower(0);
            r.backward(1);
            sleep(100);
            r.rest();

            r.turnRight(1);
            sleep(100);
            r.forward(1);
            sleep(600);
            r.rest();

            while(opModeIsActive()) {
                r.bottomIntakeArm.setPower(1);
                r.topIntakeArm.setPower(1);
            }

            r.stop();


    }

}