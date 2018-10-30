package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by robotics on 10/9/2018.
 */
@Autonomous
public class Robot extends LinearOpMode{
    // Creates the variables for the motors, servos, and runtime.
    DcMotor LM;
    DcMotor RM;
    double half = 0.5;
    double qrt = 0.25;
    //Boolean True;
    //Boolean False;
    //Boolean 1;
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode(){


        // Maps the variables
        LM = hardwareMap.dcMotor.get("LM");
        RM = hardwareMap.dcMotor.get("RM");
        // Reverses the left motor direction
        LM.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addLine("Drive: ");

        waitForStart(); // Tells the robot to wait for the sign to start

        while(opModeIsActive()){ // While the code is told to run the following happens
            telemetry.addData("Timer: ", runtime.seconds());
            telemetry.addLine();
            if(runtime.seconds() <= 4){ // While the code is under 1 second this happens
                drive(0.5);
            } else if(runtime.seconds() <= 8) { // While the code is under 1 second this happens
                turnLeft(0.25);
            } else if(runtime.seconds() <= 12){ // While the code is under 1 second this happens
                turnRight(0.25);
            }else if(runtime.seconds()<=14){ // Otherwise, it will stop the robot and reset the servo position.
                Stop();
            } else if(runtime.seconds()<=17){
                drive(0.5);
            } else{
                Stop();
            }
        }
        runtime.reset();
        telemetry.clearAll();



    }
    private void drive(double speed){
        telemetry.addData("Drive: ", speed);
        telemetry.update();
        LM.setPower(speed);
        RM.setPower(speed);
    }
    private void Stop(){
        telemetry.addData("Drive: ", "Stop");
        telemetry.update();
        LM.setPower(0);
        RM.setPower(0);
    }
    private void turnRight(double speed){
        telemetry.addData("Drive: ", "Turning Right");
        telemetry.update();
        LM.setPower(speed);
        RM.setPower(-speed);
    }
    private void turnLeft(double speed){
        telemetry.addData("Drive: ", "Turning Left");
        telemetry.update();
        LM.setPower(-speed);
        RM.setPower(speed);
    }




}
