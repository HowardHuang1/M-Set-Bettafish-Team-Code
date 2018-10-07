package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by howardhuang on 10/6/18.
 */

public class Robot {
    private DcMotor leftFrontMotor;
    private DcMotor rightFrontMotor;
    private DcMotor leftBackMotor;
    private DcMotor rightBackMotor;
    private DcMotor intake; // constantly runs
    private Servo intakeArm;

    /* Initialize Hardware Map */
    HardwareMap hardwareMap =  null;

    public void init(HardwareMap hardwareMap, Telemetry telemetry) throws InterruptedException {
        // Save reference to Hardware map
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        // define routes in Hardware Map
        leftFrontMotor = hardwareMap.get(DcMotor.class, "left_Front_Motor");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "right_Front_Motor");
        leftBackMotor = hardwareMap.get(DcMotor.class, "left_Back_Motor");
        rightBackMotor = hardwareMap.get(DcMotor.class, "right_Back_Motor");
    }


    /* Initialize Telemetry */
    Telemetry telemetry;

    // telemetry feedback display
    telemetry.addData("Status", "Initialized");
    telemetry.update();

    // reset encoder values
    leftFrontMotor.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    // initiate "getCurrentPosition"
    int getCurrentPosition();

    // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0",  "Starting at %7d :%7d",
                leftFrontMotor.getCurrentPosition(),
                rightFrontMotor.getCurrentPosition());
        telemetry.update();

    // NeverRest Encoders
//    static final double COUNTS_PER_MOTOR_REV    = 1120 ;    // eg: NeveRest Motor Encoder
//    static final double DRIVE_GEAR_REDUCTION    = 1.0 ;     // This is < 1.0 if geared UP
//    static final double WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
//    static final double COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI);

    // pre-coded drive Speeds
    static final double AUTO_DRIVE_SPEED_SLOW = 0.25;
    static final double AUTO_DRIVE_SPEED_NORMAL = 0.5;
    static final double AUTO_DRIVE_SPEED_FAST   = 1.0;
    // this may be linked to encoders used above

    // pre-coded drive Directions
        // forward
    leftFrontMotor.setDirection(DcMotor.Direction.FORWARD);// have to make sure left mecanum and right mecanum are set up REVERSE of each other though
    rightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
    leftBackMotor.setDirection(DcMotor.Direction.FORWARD);
    rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        // backwards
    leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);// have to make sure left mecanum and right mecanum are set up REVERSE of each other though
    rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
    leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
    rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        // left strafe

        // right strafe

}
