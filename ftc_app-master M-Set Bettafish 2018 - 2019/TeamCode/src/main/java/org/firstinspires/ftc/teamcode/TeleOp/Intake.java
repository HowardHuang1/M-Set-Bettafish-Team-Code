package org.firstinspires.ftc.teamcode.TeleOp;

public class Intake {
    org.firstinspires.ftc.teamcode.Robot r = new org.firstinspires.ftc.teamcode.Robot();

    Robot r = new Robot();
    Gamepad gp1, gp2;

    public Intake(HardwareMap hm, Telemetry tm, Gamepad gp1, Gamepad gp2) {
        try {
            r.init(hm, tm); // used try/catch to please android studio :)
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        this.gp1 = gp1;
        this.gp2 = gp2;
    }

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
