package org.firstinspires.ftc.teamcode;

/**
 * Created by tejbade on 10/6/18.
 * <p>
 * Created by tejbade on 10/6/18.
 */

/**
 * Created by tejbade on 10/6/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

public abstract class AutoOpBase extends LinearOpMode {

    Robot r = new Robot();

    public void initRobot() throws InterruptedException {
        r.init(hardwareMap, telemetry);
        r.resetEncoders();
        r.setUseEncoderMode();
        r.initGyro();
    }

    public void startRobot() throws InterruptedException {
        r.winch.setPower(-1);
        sleep(4200);
        r.winch.setPower(0);
        driveBackwardDistance(2, 0.3);
        mecanumStrafeRightTime(0.8, 400);
    }

    public void driveForwardDistance(double maintainAngle, int forwardInches, double driveSpeed) {
        if (opModeIsActive()) {
            int newRightBackTarget = r.rightBack.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
            int newLeftBackTarget = r.leftBack.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
            int newRightFrontTarget = r.rightFront.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
            int newLeftFrontTarget = r.leftFront.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);

            r.rightBack.setTargetPosition(newRightBackTarget);
            r.rightFront.setTargetPosition(newRightFrontTarget);
            r.leftBack.setTargetPosition(newLeftBackTarget);
            r.leftFront.setTargetPosition(newLeftFrontTarget);

            r.setRunToPositionMode();

            r.driveForward(driveSpeed);

            while (opModeIsActive() && r.isBusy()) {
                float newAngle = r.getCurrentAngle();
                if (newAngle != maintainAngle && Math.abs(newAngle - maintainAngle) > 1) {
                    if (newAngle < maintainAngle) {
                        // bot veered right. give less power to the left motor.
                        r.driveForward(driveSpeed, r.LEAN_LEFT);
                    } else {
                        // bot veered left. give less power to the right motor.
                        r.driveForward(driveSpeed, r.LEAN_RIGHT);
                    }
                } else {
                    r.driveForward(driveSpeed, r.GO_STRAIGHT);
                }

                double endAngle = r.getCurrentAngle();

                telemetry.addData("Angle: ", "Start: " + maintainAngle + " End: " + endAngle);
                telemetry.update();
            }

        }
        r.stopDriving();
        r.setUseEncoderMode();
    }

    public void driveForwardDistance(int forwardInches, double driveSpeed) {
        int newRightBackTarget;
        int newLeftBackTarget;
        int newRightFrontTarget;
        int newLeftFrontTarget;

        if (opModeIsActive()) {
            newRightBackTarget = r.rightBack.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
            newLeftBackTarget = r.leftBack.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
            newRightFrontTarget = r.rightFront.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);
            newLeftFrontTarget = r.leftFront.getCurrentPosition() + (int) (forwardInches * r.COUNTS_PER_INCH);

            r.rightBack.setTargetPosition(newRightBackTarget);
            r.rightFront.setTargetPosition(newRightFrontTarget);
            r.leftBack.setTargetPosition(newLeftBackTarget);
            r.leftFront.setTargetPosition(newLeftFrontTarget);

            r.setRunToPositionMode();

            r.driveForward(driveSpeed);

            while (opModeIsActive() && r.isBusy()) {
                // Do nothing.
            }

            r.stopDriving();
            r.setUseEncoderMode();
        }
    }

    public void driveBackwardDistance(double maintainAngle, int backwardInches, double driveSpeed) {
        backwardInches = -1 * backwardInches;

        if (opModeIsActive()) {
            int newRightBackTarget = r.rightBack.getCurrentPosition() + (int) (backwardInches * r.COUNTS_PER_INCH);
            int newLeftBackTarget = r.leftBack.getCurrentPosition() + (int) (backwardInches * r.COUNTS_PER_INCH);
            int newRightFrontTarget = r.rightFront.getCurrentPosition() + (int) (backwardInches * r.COUNTS_PER_INCH);
            int newLeftFrontTarget = r.leftFront.getCurrentPosition() + (int) (backwardInches * r.COUNTS_PER_INCH);

            r.rightBack.setTargetPosition(newRightBackTarget);
            r.rightFront.setTargetPosition(newRightFrontTarget);
            r.leftBack.setTargetPosition(newLeftBackTarget);
            r.leftFront.setTargetPosition(newLeftFrontTarget);

            r.setRunToPositionMode();

            r.driveBackward(driveSpeed);

            while (opModeIsActive() && r.isBusy()) {
                float newAngle = r.getCurrentAngle();
                if (newAngle != maintainAngle && Math.abs(newAngle - maintainAngle) > 1) {
                    if (newAngle < maintainAngle) {
                        // bot veered right. give less power to the left motor.
                        r.driveBackward(driveSpeed, r.LEAN_LEFT);
                    } else {
                        // bot veered left. give less power to the right motor.
                        r.driveBackward(driveSpeed, r.LEAN_RIGHT);
                    }
                } else {
                    r.driveBackward(driveSpeed, r.GO_STRAIGHT);
                }

                double endAngle = r.getCurrentAngle();

                telemetry.addData("Angle: ", "Start: " + maintainAngle + " End: " + endAngle);
                telemetry.update();
            }

            r.stopDriving();
            r.setUseEncoderMode();
        }
    }

    public void driveBackwardDistance(int backwardInches, double driveSpeed) {
        driveForwardDistance(-1 * backwardInches, driveSpeed);
    }

    public void turnLeftToAngle(double targetAngle) {
        float currentAngle = r.getCurrentAngle();
        if (targetAngle == currentAngle) {
            // Nothing to do.
            return;
        }

        // Check if the target angle is to the left of current angle
        if (targetAngle > currentAngle) {
            turnLeftToAngleLocal(targetAngle);
        } else {
            // We will be crossing over the 180 mark.

            // Let's first go to 180.
            turnLeftToAngleLocal(180);

            // Now let's go to the actual target angle.
            turnLeftToAngleLocal(targetAngle);
        }

        r.stopDriving();
        r.setUseEncoderMode();
    }

    private void turnLeftToAngleLocal(double targetAngle) {
        float currentAngle = r.getCurrentAngle();
        if (opModeIsActive() && currentAngle < targetAngle) {
            r.turnLeft(r.TURN_SPEED_NORMAL);
        }

        while (opModeIsActive() && targetAngle > currentAngle) {
            // Keep turning.
            currentAngle = r.getCurrentAngle();
            telemetry.addData("Angle", currentAngle);
            telemetry.update();
        }

        r.stopDriving();
    }

    public void turnRightToAngle(double targetAngle) {
        float currentAngle = r.getCurrentAngle();
        if (targetAngle == currentAngle) {
            // Nothing to do.
            return;
        }

        // Check if the target angle is to the left of current angle
        if (targetAngle < currentAngle) {
            turnRightToAngleLocal(targetAngle);
        } else {
            // We will be crossing over the 180 mark.

            // Let's first go to -179.99.
            turnRightToAngleLocal(-179.99);

            // Now let's go to the actual target angle.
            turnRightToAngleLocal(targetAngle);
        }

        r.stopDriving();
        r.setUseEncoderMode();
    }

    private void turnRightToAngleLocal(double targetAngle) {
        float currentAngle = r.getCurrentAngle();
        if (opModeIsActive() && targetAngle < currentAngle) {
            r.turnRight(r.TURN_SPEED_NORMAL);
        }

        while (opModeIsActive() && targetAngle < currentAngle) {
            // Keep turning.
            currentAngle = r.getCurrentAngle();
            telemetry.addData("Target Angle", targetAngle);
            telemetry.addData("Current Angle", currentAngle);
            telemetry.update();
        }

        r.stopDriving();
    }

    public void mecanumStrafeLeftTime(double power, long time) {
        if(opModeIsActive()) {
            r.mecanumStrafeLeft(power);
            sleep(time);
            r.stopDriving();
        }
    }

    public void mecanumStrafeRightTime(double power, long time) {
        if(opModeIsActive()) {
            r.mecanumStrafeRight(power);
            sleep(time);
            r.stopDriving();
        }
    }

}