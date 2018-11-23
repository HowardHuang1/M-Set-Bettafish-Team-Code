package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

/**
 * Created by tejbade on 10/6/18.
 */

/**
 * Created by tejbade on 10/6/18.
 */

@Autonomous(name="Reset Winch")
public class ResetWinch extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        while (opModeIsActive()) {
            r.winch.setPower(1);
            idle();
        }

        r.stop();

    }

}