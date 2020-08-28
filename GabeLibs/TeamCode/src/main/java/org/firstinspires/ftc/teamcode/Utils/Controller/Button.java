package org.firstinspires.ftc.teamcode.Utils.Controller;

public class Button {
    private boolean pressing, previous, pressed, released;

    public Button(){
        this.pressing = false;
        this.previous = false;
        this.pressed = false;
        this.released = !this.pressed;
    }

    public void update(boolean input){
        this.pressing = input;
        if (this.pressing != this.previous && this.pressing)
            this.pressed = true;
        else
            this.pressed = false;
        this.released = !this.pressed;
        this.previous = this.pressing;
    }

    public boolean isPressing(){ return this.pressing; }
    public boolean isPressed(){ return this.pressed; }
    public boolean isReleased(){ return this.released; }

}
