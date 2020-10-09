package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Demo1 extends LinearOpMode {
    DcMotor motor;
    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.get(DcMotor.class, "motor");

        while(opModeIsActive()){
            if(gamepad1.a)
                motor.setPower(100);
            else
                motor.setPower(-100);
        }
    }
}
