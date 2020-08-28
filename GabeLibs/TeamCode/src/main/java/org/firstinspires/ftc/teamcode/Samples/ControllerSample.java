package org.firstinspires.ftc.teamcode.Samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Utils.Controller.GamepadWrapper;

@TeleOp (name = "Controller Sample")
public class ControllerSample extends LinearOpMode {

    boolean toggle_a = false, toggle_b = false;
    GamepadWrapper exampleGamePad = new GamepadWrapper(gamepad1);
    @Override
    public void runOpMode() throws InterruptedException {
        while(opModeIsActive()){

            if(exampleGamePad.A.isPressed()) // Rising Edge Toggle
                toggle_a = !toggle_a;

            if(exampleGamePad.B.isReleased()) // Falling Edge Toggle
                toggle_b = !toggle_b;

            telemetry.addData("A Pressing", exampleGamePad.A.isPressing());
            telemetry.addData("Toggle A:", toggle_a);

            telemetry.addData("B Pressing", exampleGamePad.B.isPressing());
            telemetry.addData("Toggle B:", toggle_b);

            telemetry.addData("Left Stick X", exampleGamePad.Left_Stick_X);


        }
    }
}
