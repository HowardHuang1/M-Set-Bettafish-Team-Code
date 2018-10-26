/*package org.firstinspires.ftc.teamcode.Autonomous;

@AutoOpBlueLeft(name="AutoOpBlueLeft")
public class AutoOpBlueLeft extends AutoOpBase{
    Robot r = new Robot();

    public void runOpMode() throws InterruptedException {
        r.init(hardwareMap, telemetry);
        double speed = 0.8;
        double ppower = 1;
        int time = 1000;
        while (opModeIsActive()) {
            r.winch.setPower(-speed);
            sleep(3400);
            MecanumStrafeLeft(ppower, time);
            speed = 0;
            time = 0;
            idle();
        }
        rest();
    }
    // turn right
    r.MecanumDriveRotateLeft(ppower, 3000);
    // drive forward to align with wall
    r.MecanumDriveForward(ppower, 5000);
    // strafe to depot
    r.MecanumDriveStrafeLeft(ppower, 10000);
}
*/