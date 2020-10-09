package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class SampleTankDrive extends LinearOpMode {

    DcMotor leftFront, rightFront, leftRear, rightRear, intakeMotor;
    Servo gripper, gripperExtender;
    float left, right;

    float error = 0, target = 0, Kp = 1;
    float error2 = 0, target2 = 0, Kp2 = 1;

    public void doAutoCalculation(float input1, float input2){
        error = target - input1;
        error2 = target2 - input2;

        error = target - intakeMotor.getCurrentPosition(); // calculate the error
        intakeMotor.setPower(error * Kp);  // send the output to the motor
    }

    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        intakeMotor = hardwareMap.get(DcMotor.class, "intake");
        gripper = hardwareMap.get(Servo.class, "gripper");
        gripperExtender = hardwareMap.get(Servo.class, "gripperExtender");
        gripper.scaleRange(0, 180);




        while (opModeIsActive()) {
            left = gamepad1.left_stick_y + gamepad1.left_stick_x;
            right = gamepad1.left_stick_y - gamepad1.left_stick_x;

            leftFront.setPower(left);
            leftRear.setPower(left);
            rightFront.setPower(right);
            rightRear.setPower(right);

            if(gamepad1.a){
                target = 100;
            }
            else if(gamepad1.b){
                target = 200;
            }


        }
    }
}