package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.Drive;
import org.firstinspires.ftc.teamcode.Robot;

import static java.lang.Math.abs;

/**
 * Created by tejbade on 10/25/18.
 */

@Autonomous(name="MotorTest")
public class MotorTest extends LinearOpMode {
    Robot r = new Robot();

    public void runOpMode() throws InterruptedException {

        r.init(hardwareMap, telemetry);

        waitForStart();
        while(opModeIsActive()) {
            r.leftBack.setPower(0.2);
            r.leftFront.setPower(0.2);
            r.rightBack.setPower(0.2);
            r.rightFront.setPower(0.2);
            sleep(10000);
            idle();
        }
        r.leftBack.setPower(0);
        r.leftFront.setPower(0);
        r.rightBack.setPower(0);
        r.rightFront.setPower(0);
    }
}
