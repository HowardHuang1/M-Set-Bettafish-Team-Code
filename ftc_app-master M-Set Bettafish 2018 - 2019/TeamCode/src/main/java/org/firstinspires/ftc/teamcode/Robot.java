package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by howardhuang on 10/6/18.
 */

public class Robot {
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor intake; // constantly runs
    private Servo intakeArm;

    public void runOpMode() {
        // define routes in Hardware Map
        leftFront = hardwareMap.get(DcMotor.class, "lf");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        leftBack = hardwareMap.get(DcMotor.class, "lb");
        rightBack = hardwareMap.get(DcMotor.class, "rb");
    }

    // telemetry feedback display
    telemetry.addData("Status", "Initialized");
    telemetry.update();
}
