package org.firstinspires.ftc.teamcode.Samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Simple X Drive", group = "Linear Opmode")
public class Simple_X_Drive extends LinearOpMode {

    public DcMotor LeftFront, LeftRear, RightFront, RightRear;
    public float linear = 0, rotational = 0, translational = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        LeftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        LeftRear = hardwareMap.get(DcMotor.class, "LeftRear");
        RightFront = hardwareMap.get(DcMotor.class, "RightFront");
        RightRear = hardwareMap.get(DcMotor.class, "RightRear");

        while(true){
            linear = gamepad1.left_stick_y;
            rotational = gamepad1.right_stick_x;
            translational = gamepad1.left_stick_x;

            LeftFront.setPower(-linear+rotational+translational);
            LeftRear.setPower(-linear+rotational-translational);
            RightFront.setPower(linear+rotational+translational);
            RightRear.setPower(linear+rotational-translational);

        }
    }
}
