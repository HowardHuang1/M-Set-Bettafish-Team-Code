package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "lifttest")
public class SimpleLiftTest extends LinearOpMode {
    Robot r = new Robot();
    public void runOpMode() throws InterruptedException {
        r.init(hardwareMap, telemetry);
        r.winch.setPower(0);
        while(opModeIsActive()) {
            // lift goes one way if you press a
            if(gamepad1.a)
                r.winch.setPower(1);
            // lift goes other way if you press b
            else if(gamepad1.b)
                r.winch.setPower(-1);
        }
    }
}
