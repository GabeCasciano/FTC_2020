package org.firstinspires.ftc.teamcode.Samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Utils.PID;

@TeleOp (name="Simple PID")
public class Simple_PID extends LinearOpMode {
    public float Kp = .5f;
    public PID pid;
    public DcMotor motor;
    @Override
    public void runOpMode() throws InterruptedException {

        motor = hardwareMap.get(DcMotor.class, "motor");
        pid = new PID(Kp);
        pid.updateTarget(767);
        pid.setMaximumOut(100);
        pid.calculate(motor.getCurrentPosition());
        do {
            motor.setPower(pid.getOutput()/100);
            telemetry.addData("pos", motor.getCurrentPosition());
            telemetry.addData("out", pid.getOutput());
            telemetry.update();
        } while (!pid.calculate(motor.getCurrentPosition()));

        motor.setPower(0);


    }
}
