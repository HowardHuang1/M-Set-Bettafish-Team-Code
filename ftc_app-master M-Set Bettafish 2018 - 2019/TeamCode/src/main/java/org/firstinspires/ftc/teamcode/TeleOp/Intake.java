package org.firstinspires.ftc.teamcode.TeleOp;

public class Intake {
    Robot r = new Robot();

    public void spin() {

        if (gamepad1.right_trigger)
            //suck in
            r.intake.setPower(1);
        else if (gamepad1.left_trigger)
            //spit out
            r.intake.setPower(-1);
        else
            // halt all spinning
            r.intake.setPower(0);
    }
}
