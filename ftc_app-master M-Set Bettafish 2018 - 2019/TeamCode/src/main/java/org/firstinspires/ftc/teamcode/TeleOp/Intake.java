package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Robot;

public class Intake {
    Robot r;
    Gamepad gp1, gp2;
    public Intake(Robot r, Gamepad gp1, Gamepad gp2) {
        this.r = r;
        this.gp1 = gp1;
        this.gp2 = gp2;
    }
    public void draw() {
        if(gp1.a) // down
            r.intakeArm.setPower(0.2);
        else if(gp1.b) // up
            r.intakeArm.setPower(-0.3);
        else
            r.intakeArm.setPower(0);
    }
}