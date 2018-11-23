package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

/**
 * Created by tejbade on 10/6/18.
 */

/**
 * Created by tejbade on 10/6/18.
 */

@Autonomous(name="Test Encoders")
public class TestEncoders extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        turnLeftToAngle(45);
        sleep(2000);
        telemetry.addData("Start Angle: ", r.getCurrentAngle());
        telemetry.update();

        driveForwardDistance(10, 0.5);
        sleep(3000);

        turnLeftToAngle(90);
        sleep(2000);
        telemetry.addData("Middle Angle: ", r.getCurrentAngle());
        telemetry.update();

        driveForwardDistance(10, 0.5);
        sleep(3000);

        turnLeftToAngle(270);
        sleep(2000);
        telemetry.addData("End Angle: ", r.getCurrentAngle());
        telemetry.update();

        while (opModeIsActive()) {
            idle();
        }

        r.stop();

    }

}