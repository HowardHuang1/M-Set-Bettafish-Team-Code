package org.firstinspires.ftc.teamcode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot;

public class Drive extends Robot {

    public void forward(double power) {
        rightBack.setPower(0.8 * power);
        rightFront.setPower(power);
        leftBack.setPower(0.8 * power);
        leftFront.setPower(power);
    }
    public void backward(double power) {
        forward(-power);
    }
    public void turnRight(double power) {
        rightBack.setPower(-power);
        rightFront.setPower(-power);
        leftBack.setPower(power);
        leftFront.setPower(power);
    }
    public void turnLeft(double power) {
        turnRight(-power);
    }
    public void mecanumStrafeLeft(double power) {
        rightBack.setPower(-0.8*power);
        rightFront.setPower(power);
        leftBack.setPower(0.8*power);
        leftFront.setPower(-power);
    }
    public void mecanumStrafeRight(double power) {
        mecanumStrafeLeft(-power);
    }

    public void rest() {
        rightBack.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        leftFront.setPower(0);
    }

}
