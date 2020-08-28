package org.firstinspires.ftc.teamcode.Utils;

import com.qualcomm.robotcore.hardware.DcMotor;

public class PID_Motor {

    private PID pid;
    private DcMotor motor;
    private float distance;
    private int position;
    private int starting_position;
    private float gearing, diameter;
    private static int counts_per_motor_rotation_bilda = 7;
    private boolean motor_stopped = false;
    private int positional_tolerance = 2;

    public PID_Motor(DcMotor motor, PID pid){
        this.motor = motor;
        this.pid = pid;
        this.distance = 0;
        this.starting_position = motor.getCurrentPosition();
        this.position = 0;
        this.gearing = 0;
        this.diameter = 0;
    }

    /**
     *
     * @param motor
     * @param pid
     * @param wheel_diameter
     * @param ratio given as driving ratio / driven
     */
    public PID_Motor(DcMotor motor, PID pid, float wheel_diameter, float ratio){

    }

    private void update_pos_stats(){
        this.position = this.motor.getCurrentPosition() - this.starting_position;

        this.distance = (this.position /counts_per_motor_rotation_bilda) * this.diameter * (float)Math.PI * this.gearing;

    }

    public int calculate_position_from_distance(float distance){
        return (int)Math.round((distance / (this.diameter * Math.PI)) * (counts_per_motor_rotation_bilda / this.gearing));
    }

    public float calculate_distance_from_position(int position){
        return (float) (position * this.diameter * Math.PI * this.gearing / counts_per_motor_rotation_bilda);
    }

    public void update_pid_and_power(){
        if(!this.motor_stopped) {
            this.pid.calculate(this.motor.getCurrentPosition());
            this.motor.setPower(this.pid.getOutput());
        }
        else
            this.motor.setPower(0);
        this.update_pos_stats();
    }

    public void setMotorTarget(int position){
        this.pid.updateTarget(position);
    }
    public void setMotorTarget(float distance){ this.pid.updateTarget(calculate_position_from_distance(distance)); }

    public void resetPosition(){
        this.starting_position = this.motor.getCurrentPosition();
        this.update_pos_stats();
    }

    public void stopMotor(){
        this.motor_stopped = true;
        this.update_pid_and_power();
    }

    public void run_to_position(int position){
        this.resetPosition();
        this.setMotorTarget(position);
        while(this.pid.error >= positional_tolerance){
            this.motor_stopped = false;
            this.update_pid_and_power();
        }
        this.stopMotor();
    }

    public void run_to_distance(float distance){ this.run_to_position(calculate_position_from_distance(distance)); }

    public void run_at_velocity(float velocity){}


}
