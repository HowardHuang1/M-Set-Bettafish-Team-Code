package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcontroller.external.samples.SensorMRColor;
import org.firstinspires.ftc.robotcontroller.external.samples.SensorMRGyro;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;


import java.util.Locale;

/**
 * Created by tejbade on 10/6/18.
 */

public class Robot {

    public DcMotor leftFront;
    public DcMotor rightFront;
    public DcMotor leftBack;
    public DcMotor rightBack; //reverse
    public DcMotor winch;
    public DcMotor intakeArm;
    public DcMotor intake;

    // preset speeds
    public static final double COUNTS_PER_MOTOR_REV = 1120;    // Motor Encoder
    public static final double DRIVE_GEAR_REDUCTION = 1.0;     // This is < 1.0 if geared UP
    public static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    public static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);

    public static final double DRIVE_SPEED_SLOW = 0.25;
    public static final double DRIVE_SPEED_NORMAL = 0.5;
    public static final double DRIVE_SPEED_FAST = 1.0;
    public static final double TURN_SPEED_SLOW = 0.15;
    public static final double TURN_SPEED_NORMAL = 0.3;
    public static final double TURN_SPEED_FAST = 1;

    public static final int LEAN_LEFT = -1;
    public static final int GO_STRAIGHT = 0;
    public static final int LEAN_RIGHT = 1;
    public static final double LEAN_CORRECTION = 0.20;

    public ColorSensor leftSensor;
    public Servo leftServo;
    public Servo rightServo;
    public ColorSensor rightSensor;

    /* Initialize Hardware Map and Telemetry */
    HardwareMap hardwareMap = null;
    Telemetry telemetry = null;

    // The IMU sensor object
    //BNO055IMU imu;

    BNO055IMU imu;

    // State used for updating telemetry
    public Orientation angles;
    public Acceleration gravity;

    public void init(HardwareMap hardwareMap, Telemetry telemetry) throws InterruptedException {
        // Save reference to Hardware map
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        // define routes in Hardware Map
        leftFront = hardwareMap.get(DcMotor.class, "lf");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        leftBack = hardwareMap.get(DcMotor.class, "lb");
        rightBack = hardwareMap.get(DcMotor.class, "rb");

        winch = hardwareMap.get(DcMotor.class, "wi");
        intakeArm = hardwareMap.get(DcMotor.class, "ia");
        intake = hardwareMap.get(DcMotor.class, "in");

        /*
        leftSensor = hardwareMap.get(ColorSensor.class, "lcs");
        rightSensor = hardwareMap.get(ColorSensor.class, "rcs");
        leftServo = hardwareMap.get(Servo.class, "ls");
        rightServo = hardwareMap.get(Servo.class, "rs");
        */

        /* Initialize Telemetry */

        // telemetry feedback display
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // initiate "getCurrentPosition"

        //int getCurrentPosition();

        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0", "Starting at %7d :%7d",
                leftFront.getCurrentPosition(),
                rightFront.getCurrentPosition(),
                leftBack.getCurrentPosition(),
                rightBack.getCurrentPosition());
        telemetry.update();

        // NeverRest Encoders
//    static final double COUNTS_PER_MOTOR_REV    = 1120 ;    // eg: NeveRest Motor Encoder
//    static final double DRIVE_GEAR_REDUCTION    = 1.0 ;     // This is < 1.0 if geared UP
//    static final double WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
//    static final double COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);

        stopDriving();

    }

    public void resetEncoders() {
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setUseEncoderMode() {
        // Set wheel motors to run with encoders.
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setRunToPositionMode() {
        // Set wheel motors to run to position.
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void driveForward(double power) {
        driveForward(power, power);
    }

    public void driveForward(double leftPower, double rightPower) {
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setPower(rightPower);
        rightFront.setPower(rightPower);
        leftBack.setPower(leftPower);
        leftFront.setPower(leftPower);
    }

    public void driveForward(double power, int lean) {
        if (lean == GO_STRAIGHT) {
            driveForward(power, power);
        } else if (lean == LEAN_LEFT) {
            driveForward(power - power * LEAN_CORRECTION, power);
        } else if (lean == LEAN_RIGHT) {
            driveForward(power, power - power * LEAN_CORRECTION);
        }
    }

    public void driveBackward(double power) {
        driveForward(-power);
    }

    public void driveBackward(double leftPower, double rightPower) {
        driveForward(-leftPower, -rightPower);
    }

    public void driveBackward(double power, int lean) {
        if (lean == GO_STRAIGHT) {
            driveBackward(power, power);
        } else if (lean == LEAN_LEFT) {
            driveBackward(power - power * LEAN_CORRECTION, power);
        } else if (lean == LEAN_RIGHT) {
            driveBackward(power, power - power * LEAN_CORRECTION);
        }
    }

    public void turnLeft(double power) {
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setPower(power);
        leftFront.setPower(power);
        rightBack.setPower(power);
        rightFront.setPower(power);
    }

    public void turnRight(double power) {
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setPower(power);
        leftFront.setPower(power);
        rightBack.setPower(power);
        rightFront.setPower(power);
    }

    public void stopDriving() {
        driveForward(0);
    }

    public void stop() {
        rightBack.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        leftFront.setPower(0);
        winch.setPower(0);
        intakeArm.setPower(0);
        intake.setPower(0);
    }

    public boolean isBusy() {
        return rightBack.isBusy() && rightFront.isBusy() && leftBack.isBusy() && leftFront.isBusy();
    }

    public float getCurrentAngle() {
        return imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
    }

    public void initGyro() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        gravity = imu.getGravity();

    }
}