package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by howardhuang on 10/8/18.
 */

@TeleOp(name="abinav_kapoor")

public class TeleOp_ extends LinearOpMode {
    Robot bot = new Robot();

    public void runOpMode() throws InterruptedException {
        // Initialize the drive system variables.
        // The init() method of the hardware class does all the work here
        bot.init(hardwareMap, telemetry);
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            manageChassis();
        }
        stopDriving();
    }

    // Drive Forward Command
    void driveForward(double power) {
        driveForward(power, power);
    }

    void stopDriving() {
        driveForward(0);
    }

    // Drive Backward Command
    void driveBackward(double leftPower, double rightPower) {
        driveForward(-leftPower, -rightPower);
    }

    void driveBackward(double power) {
        driveForward(-power);
//        motorLeft.setDirection(DcMotor.Direction.FORWARD);
//        motorRight.setDirection(DcMotor.Direction.REVERSE);
//        motorLeft.setPower(power);
//        motorRight.setPower(power);
    }


    // Game Pad Key Input
    void manageChassis() {
        String motion = "Stop";
        double leftStickY = gamepad1.left_stick_y;
        double leftStickX = gamepad1.left_stick_x;
        double rightStickX = gamepad1.right_stick_x;

        if (leftStickY == 0 && leftStickX == 0 && rightStickX == 0) {
            // Stop the robot and return.
            bot.stopDriving();
            return;
        }

    }

    // pre-coded drive Speeds
    // Mecanum power is determined by Speed, Turn, and Strafe
    public void MecanumDrive() {
        double Speed = -gamepad1.left_stick_y;
        double Turn = gamepad1.left_stick_x;
        double Strafe = gamepad1.right_stick_x;
        double MAX_SPEED = 1.0;
        holonomic(Speed, Turn, Strafe, MAX_SPEED);
    }
// Front, Back, rightstrafe, leftstrafe
    public void holonomic(double Speed, double Turn, double Strafe, double MAX_SPEED) {
//EQ:      Left Front = +Speed + Turn - Strafe      Right Front = +Speed - Turn + Strafe
//EQ:      Left Rear  = +Speed + Turn + Strafe      Right Rear  = +Speed - Turn - Strafe

        double Magnitude = abs(Speed) + abs(Turn) + abs(Strafe);
        Magnitude = (Magnitude > 1) ? Magnitude : 1; //Set scaling to keep -1,+1 range

        leftFrontMotor.setPower(scale((scaleInput(Speed) + scaleInput(Turn) - scaleInput(Strafe)),
                -Magnitude, +Magnitude, -MAX_SPEED, +MAX_SPEED));
        if (leftRearMotor != null) {
            leftRearMotor.setPower(scale((scaleInput(Speed) + scaleInput(Turn) + scaleInput(Strafe)),
                    -Magnitude, +Magnitude, -MAX_SPEED, +MAX_SPEED));
        }
        rightFrontMotor.setPower(scale((scaleInput(Speed) - scaleInput(Turn) + scaleInput(Strafe)),
                -Magnitude, +Magnitude, -MAX_SPEED, +MAX_SPEED));
        if (rightRearMotor != null) {
            rightRearMotor.setPower(scale((scaleInput(Speed) - scaleInput(Turn) - scaleInput(Strafe)),
                    -Magnitude, +Magnitude, -MAX_SPEED, +MAX_SPEED));
        }
    }

}
