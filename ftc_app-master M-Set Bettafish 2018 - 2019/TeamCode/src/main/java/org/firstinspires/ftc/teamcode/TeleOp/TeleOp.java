package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.Robot;

import static java.lang.Math.abs;

/**
 * Created by tejbade on 10/8/18.
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOp extends LinearOpMode {
    Drive d = new Drive();
    int direction = 1;

    public void runOpMode() throws InterruptedException {
        // Initialize the drive system variables.
        // The init() method of the hardware class does all the work here
        d.init(hardwareMap, telemetry);
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

            if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x) && gamepad1.left_stick_y < 0.2)
                d.forward(Math.abs(gamepad1.left_stick_y) * direction);
            else if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x) && gamepad1.left_stick_y > -0.2)
                d.backward(Math.abs(gamepad1.left_stick_y) * direction);
            else if (gamepad1.right_stick_x > 0.2)
                d.turnRight(Math.abs(gamepad1.right_stick_x));
            else if (gamepad1.right_stick_x < -0.2)
                d.turnLeft(Math.abs(gamepad1.right_stick_x));
            else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y) && gamepad1.left_stick_x > 0.2)
                d.mecanumStrafeRight(Math.abs(gamepad1.left_stick_x) * direction);
            else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y) && gamepad1.left_stick_x < -0.2)
                d.mecanumStrafeLeft(Math.abs(gamepad1.left_stick_x) * direction);
            else
                d.rest();

            if (gamepad1.left_stick_button)
                direction = -direction;

            //Gamepad 2

            if (gamepad2.y) {
                d.intakeArm.setPower(-1);
            } else if (gamepad2.a) {
                d.intakeArm.setPower(1);
            } else {
                d.intakeArm.setPower(0);
            }

            if (gamepad2.right_bumper) {
                d.intake.setPower(-0.6);
            } else if (gamepad2.left_bumper) {
                d.intake.setPower(0.6);
            } else
                d.intake.setPower(0);

            if (gamepad2.dpad_up)
                d.winch.setPower(-1);
            else if (gamepad2.dpad_down)
                d.winch.setPower(1);
            else
                d.winch.setPower(0);

            idle();
        }

        d.rest();

    }

}
