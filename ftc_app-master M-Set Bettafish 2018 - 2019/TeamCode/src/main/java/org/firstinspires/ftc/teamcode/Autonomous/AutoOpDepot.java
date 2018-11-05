package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by tejbade on 10/6/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

/**
 * Created by tejbade on 10/6/18.
 */
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorMRGyro;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="AutoOpDepot")
public class AutoOpDepot extends LinearOpMode {

    Robot r = new Robot();

    public void runOpMode() throws InterruptedException {
        r.init(hardwareMap, telemetry);

        waitForStart();

        r.winch.setPower(1);
        sleep(4000);
        r.winch.setPower(0);
        mecanumStrafeLeft(1, 800);
        rest();
        sleep(300);
        backward(1, 100);
        r.bottomIntakeArm.setPower(1);
        r.topIntakeArm.setPower(1);
        sleep(500);
        forward(1, 1000);
        sleep(500);
        restMotors();
        r.intake.setPower(1);
        sleep(10000);
        r.intake.setPower(0);
        backward(1, 300);
        rest();
    }

    public void forward(double power, int time) {
        r.rightBack.setPower(0.8*power);
        r.rightFront.setPower(-power);
        r.leftBack.setPower(-0.8*power);
        r.leftFront.setPower(-power);
        sleep(time);
    }
    public void backward(float power, int time) {
        r.rightBack.setPower(-0.8*power);
        r.rightFront.setPower(power);
        r.leftBack.setPower(0.8*power);
        r.leftFront.setPower(power);
        sleep(time);
    }
    public void turnRight(double power, int time) {
        r.rightBack.setPower(-power);
        r.rightFront.setPower(power);
        r.leftBack.setPower(-power);
        r.leftFront.setPower(-power);
        sleep(time);
    }
    public void turnLeft(float power, int time) {
        r.rightBack.setPower(power);
        r.rightFront.setPower(-power);
        r.leftBack.setPower(power);
        r.leftFront.setPower(power);
        sleep(time);
    }
    public void mecanumStrafeLeft(float power, int time) {
        r.leftFront.setPower(-power);
        r.leftBack.setPower(0.8*power);
        r.rightFront.setPower(power);
        r.rightBack.setPower(0.8*power);
        sleep(time);
    }
    public void mecanumStrafeRight(float power, int time) {
        r.leftFront.setPower(power);
        r.leftBack.setPower(-0.8*power);
        r.rightFront.setPower(-power);
        r.rightBack.setPower(-0.8*power);
        sleep(time);
    }
    public void rest() {
        r.rightBack.setPower(0);
        r.rightFront.setPower(0);
        r.leftBack.setPower(0);
        r.leftFront.setPower(0);
        r.winch.setPower(0);
        r.topIntakeArm.setPower(0);
        r.bottomIntakeArm.setPower(0);
        r.intake.setPower(0);
    }
    public void restMotors() {
        r.rightBack.setPower(0);
        r.rightFront.setPower(0);
        r.leftBack.setPower(0);
        r.leftFront.setPower(0);
    }
}