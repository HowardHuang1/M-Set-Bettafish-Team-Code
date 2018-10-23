package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Unload {

	Robot r = new Robot();

	public Unload(HardwareMap hm, Telemetry tm) {
        try {
            r.init(hm, tm);
        } catch (InterruptedException e) {}
	}

	public void doGoodThing() {
        r.winch.setPower(-1);

	}

}
