package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

/**
 * Created by tejbade on 10/6/18.
 */

/**
 * Created by tejbade on 10/6/18.
 */

@Autonomous(name="Crater")
public class AutoOpCrater extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        startRobot(); //drop down and strafe out of hook

        telemetry.addData("Step 1: ", "Completed");
        telemetry.update();

        double maintainAngle = r.getCurrentAngle();
        driveForwardDistance(maintainAngle, 19, 0.5); //drive forward away from lander
        sleep(200);

        turnLeftToAngle(90);
        sleep(200);

        maintainAngle = r.getCurrentAngle();
        driveForwardDistance(maintainAngle, 46, 0.5); //drive to wall
        sleep(1000);

        double angle = r.getCurrentAngle()+1;

        turnLeftToAngle(angle); //turn to depot
        sleep(500);

        maintainAngle = r.getCurrentAngle();
        driveForwardDistance(maintainAngle, 27, 0.5); //drive to depot

        telemetry.addData("Step 2: ", "Completed");
        telemetry.update();

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