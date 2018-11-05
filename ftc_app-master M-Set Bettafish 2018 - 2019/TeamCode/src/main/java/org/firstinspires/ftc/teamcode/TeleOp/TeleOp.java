package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.Robot;

import static java.lang.Math.abs;

/**
 * Created by tejbade on 10/8/18.
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="TeleOp")
public class TeleOp extends LinearOpMode {
    Robot r = new Robot();
    int factor = 1;
    public void runOpMode() throws InterruptedException {
        // Initialize the drive system variables.
        // The init() method of the hardware class does all the work here
        r.init(hardwareMap, telemetry);
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            // Joystick value test
            telemetry.addData("leftX", gamepad1.left_stick_x + " ");
            telemetry.addData("leftY", gamepad1.left_stick_y + " ");
            telemetry.addData("rightX", gamepad1.right_stick_x + " ");
            telemetry.addData("rightY", gamepad1.right_stick_y + " ");
            telemetry.update();

            //Gamepad 1

            if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x) && gamepad1.left_stick_y > 0.1)
                forward(Math.abs(gamepad1.left_stick_y) * factor);
            else if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x) && gamepad1.left_stick_y < -0.1)
                backward(Math.abs(gamepad1.left_stick_y) * factor);
            else if (gamepad1.right_stick_x > 0.1)
                turnRight(Math.abs(gamepad1.right_stick_x));
            else if (gamepad1.right_stick_x < -0.1)
                turnLeft(Math.abs(gamepad1.right_stick_x));
            else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y) && gamepad1.left_stick_x > 0.1)
                mecanumStrafeRight(Math.abs(gamepad1.left_stick_x) * factor);
            else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y) && gamepad1.left_stick_x < -0.1)
                mecanumStrafeLeft(Math.abs(gamepad1.left_stick_x) * factor);
            else
                rest();

            if(gamepad1.left_stick_button)
                factor = -factor;

            //Gamepad 2

            if (gamepad2.y) {
                r.bottomIntakeArm.setPower(-1);
                r.topIntakeArm.setPower(1);
            } else if (gamepad2.a) {
                r.bottomIntakeArm.setPower(1);
                r.topIntakeArm.setPower(-1);
            } else {
                r.bottomIntakeArm.setPower(0);
                r.topIntakeArm.setPower(0);
            }

            if (gamepad2.left_bumper) {
                r.intake.setPower(-1);
            } else if (gamepad2.right_bumper) {
                r.intake.setPower(1);
            } else
                r.intake.setPower(0);

            if (gamepad2.dpad_up)
                r.winch.setPower(1);
            else if (gamepad2.dpad_down)
                r.winch.setPower(-1);
            else
                r.winch.setPower(0);

            idle();
        }
        rest();
    }


    public void forward(double power) {
        r.rightBack.setPower(0.8 * power);
        r.rightFront.setPower(-power);
        r.leftBack.setPower(-0.8* power);
        r.leftFront.setPower(-power);
    }
    public void backward(double power) {
        r.rightBack.setPower(-0.8* power);
        r.rightFront.setPower(power);
        r.leftBack.setPower(0.8* power);
        r.leftFront.setPower(power);
    }
    public void turnRight(double power) {
        r.rightBack.setPower(-power);
        r.rightFront.setPower(power);
        r.leftBack.setPower(-power);
        r.leftFront.setPower(-power);
    }
    public void turnLeft(double power) {
        r.rightBack.setPower(power);
        r.rightFront.setPower(-power);
        r.leftBack.setPower(power);
        r.leftFront.setPower(power);
    }
    public void mecanumStrafeLeft(double power) {
        r.rightBack.setPower(0.8*power);
        r.rightFront.setPower(power);
        r.leftBack.setPower(0.8*power);
        r.leftFront.setPower(-power);
    }
    public void mecanumStrafeRight(double power) {
        r.rightBack.setPower(-0.8*power);
        r.rightFront.setPower(-power);
        r.leftBack.setPower(-0.8*power);
        r.leftFront.setPower(power);
    }
    public void rest() {
        r.rightBack.setPower(0);
        r.rightFront.setPower(0);
        r.leftBack.setPower(0);
        r.leftFront.setPower(0);
    }
}
