package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="AutoOpBlueLeft")
public class AutoOpBlueLeft extends AutoOpBase {
    Robot r = new Robot();

    public void runOpMode() throws InterruptedException {
        r.init(hardwareMap, telemetry);
        double speed = 0.8;
        double ppower = 1;
        int time = 1000;
        while (opModeIsActive()) {
            r.winch.setPower(-speed);
            sleep(3400);
            mecanumStrafeLeft(time);
            speed = 0;
            time = 0;
            idle();
        }
        rest();
        // turn right
        turnLeft(3000);
        // drive forward to align with wall
        forward(5000);
        // strafe to depot
        mecanumStrafeLeft(10000);
    }

    public void stopMotors() {
        r.rightBack.setPower(0);
        r.rightFront.setPower(0);
        r.leftBack.setPower(0);
        r.leftFront.setPower(0);
    }

    public void forward(int time) {
        r.rightBack.setPower(-1);
        r.rightFront.setPower(1);
        r.leftBack.setPower(1);
        r.leftFront.setPower(1);
        try {
            Thread.currentThread().sleep(time);
        } catch (InterruptedException e) {}
        stopMotors();
    }
    public void backward(int time) {
        r.rightBack.setPower(1);
        r.rightFront.setPower(-1);
        r.leftBack.setPower(-1);
        r.leftFront.setPower(-1);
        try {
            Thread.currentThread().sleep(time);
        } catch (InterruptedException e) {}
        stopMotors();
    }
    public void turnRight(int time) {
        r.rightBack.setPower(-1);
        r.rightFront.setPower(1);
        r.leftBack.setPower(-1);
        r.leftFront.setPower(-1);
        try {
            Thread.currentThread().sleep(time);
        } catch (InterruptedException e) {}
        stopMotors();
    }
    public void turnLeft(int time) {
        r.rightBack.setPower(1);
        r.rightFront.setPower(-1);
        r.leftBack.setPower(1);
        r.leftFront.setPower(1);
        try {
            Thread.currentThread().sleep(time);
        } catch (InterruptedException e) {}
        stopMotors();
    }
    public void mecanumStrafeLeft(int time) {
        r.leftFront.setPower(-1);
        r.leftBack.setPower(1);
        r.rightFront.setPower(1);
        r.rightBack.setPower(1);
        try {
            Thread.currentThread().sleep(time);
        } catch (InterruptedException e) {}
        stopMotors();
    }
    public void mecanumStrafeRight(int time) {
        r.leftFront.setPower(1);
        r.leftBack.setPower(-1);
        r.rightFront.setPower(-1);
        r.rightBack.setPower(-1);
        try {
            Thread.currentThread().sleep(time);
        } catch (InterruptedException e) {}
        stopMotors();
    }
}