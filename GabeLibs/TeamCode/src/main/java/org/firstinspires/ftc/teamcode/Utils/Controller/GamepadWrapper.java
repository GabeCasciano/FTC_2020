package org.firstinspires.ftc.teamcode.Utils.Controller;

import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadWrapper extends Thread {

    public Button A, B, X, Y, L_Bumper, R_Bumper, Start;
    public Button DPad_Up, DPad_Down, DPad_Left, DPad_Right;
    public float Left_Stick_X, Left_Stick_Y, Right_Stick_X, Right_Stick_Y, Right_Trigger, Left_Trigger;
    public Gamepad currentState;
    private boolean running;

    public GamepadWrapper(Gamepad gamepad){
        this.currentState = gamepad;
        this.running = false;
    }

    public void run(){
        while(this.running){
            this.A.update(this.currentState.a);
            this.B.update(this.currentState.b);
            this.X.update(this.currentState.x);
            this.Y.update(this.currentState.y);
            this.L_Bumper.update(this.currentState.left_bumper);
            this.R_Bumper.update(this.currentState.right_bumper);
            this.Start.update(this.currentState.start);
            this.DPad_Up.update(this.currentState.dpad_up);
            this.DPad_Down.update(this.currentState.dpad_down);
            this.DPad_Left.update(this.currentState.dpad_left);
            this.DPad_Right.update(this.currentState.dpad_right);
            this.Left_Stick_X = this.currentState.left_stick_x;
            this.Right_Stick_X = this.currentState.right_stick_x;
            this.Left_Stick_Y = this.currentState.left_stick_y;
            this.Right_Stick_Y = this.currentState.right_stick_y;
            this.Left_Trigger = this.currentState.right_trigger;
        }
    }

}
