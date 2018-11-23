package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;

/**
 * Created by tejbade on 10/6/18.
 */

/**
 * Created by tejbade on 10/6/18.
 */

@Autonomous(name="Depot Strafe")
public class AutoOpDepotStrafe extends AutoOpBase {

    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        startRobot(); //drop down and strafe

        driveForwardDistance(r.getCurrentAngle(), 32, 0.8); //drive forward away from lander
        double angle = r.getCurrentAngle()+3;
        r.turnLeft(angle);
        mecanumStrafeRight(0.7, 2500); //align with wall

        r.intakeArm.setPower(0.5);
        sleep(200);
        r.intake.setPower(0.7);
        sleep(4000); //spin outward for 4 secs.
        r.intake.setPower(0);
        r.intakeArm.setPower(-1);
        sleep(1500);
        r.intakeArm.setPower(0);

        mecanumStrafeLeft(0.8, 500);
        driveBackwardDistance(15, 0.8);
        angle = r.getCurrentAngle() - 180;
        turnRightToAngle(angle); //turn to crater
        sleep(100);

        double maintainAngle = r.getCurrentAngle();
        driveForwardDistance(maintainAngle, 65, 1); //drive to crater

        r.intakeArm.setPower(1); //put intake in crater

        while (opModeIsActive()) {
            idle();
        }

        r.stop();
    }

}