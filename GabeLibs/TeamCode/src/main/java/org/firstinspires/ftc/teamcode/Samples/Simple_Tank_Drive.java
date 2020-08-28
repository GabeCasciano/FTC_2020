package org.firstinspires.ftc.teamcode.Samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="Simple Tank Drive", group="Linear Opmode")
public class Simple_Tank_Drive extends LinearOpMode {

    public DcMotor LeftFront, LeftRear, RightFront, RightRear;
    public float left_power = 0, right_power = 0;

    public float reverse = 1; // If reversed put -1

    @Override
    public void runOpMode() throws InterruptedException {
        LeftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        LeftRear = hardwareMap.get(DcMotor.class, "LeftRear");
        RightFront = hardwareMap.get(DcMotor.class, "RightFront");
        RightRear = hardwareMap.get(DcMotor.class, "RightRear");

        while(true){
            left_power = reverse * gamepad1.left_stick_y;
            right_power = reverse * -gamepad1.right_stick_y;

            LeftFront.setPower(left_power);
            LeftRear.setPower(left_power);
            RightFront.setPower(right_power);
            RightRear.setPower(right_power);
        }
    }
}
