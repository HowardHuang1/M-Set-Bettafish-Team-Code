package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

/**
 * Created by tejbade on 10/6/18.
 */

/**
 * Created by tejbade on 10/6/18.
 */

@Autonomous(name="CraterBasic")
public class AutoOpCraterBasic extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        startRobot(); //drop down and strafe out of hook

        double maintainAngle = r.getCurrentAngle();
        driveForwardDistance(maintainAngle, 19, 0.5); //drive forward away from lander
        sleep(200);

        r.intakeArm.setPower(1);
        sleep(200);
        r.intake.setPower(1);
        sleep(4000); //spin outward for 4 secs.
        r.intake.setPower(0);
        r.intakeArm.setPower(-1);
        sleep(1500);
        r.intakeArm.setPower(0);

        telemetry.addData("Step 3: ", "Completed");
        telemetry.update();

        double angle1 = r.getCurrentAngle() - 180;
        turnRightToAngle(angle1); //turn to crater
        sleep(100);

        maintainAngle = r.getCurrentAngle();
        driveForwardDistance(maintainAngle, 65, 1); //drive to crater

        r.intakeArm.setPower(1); //put intake in crater

        telemetry.addData("Step 4: ", "Completed");
        telemetry.update();

        while (opModeIsActive()) {
            idle();
        }

        r.stop();
    }

}