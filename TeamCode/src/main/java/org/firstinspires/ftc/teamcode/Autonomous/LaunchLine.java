package org.firstinspires.ftc.teamcode.Autonomous;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
Created by Jordan Paglione on 12/15/20
 */

@Autonomous(name = "Launch Line", group = "Sensor")
public class LaunchLine extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;

    @Override
    public void runOpMode() {
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        FrontRight.setDirection(DcMotor.Direction.FORWARD);
        BackRight.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        while (opModeIsActive()) {
            // Start button is pressed

            moveForwardWithEncoders(0.5, 3500);

            // End of auto
            break;
        }
    }

    // Basic functions

    public void delay(int time) {
        double startTime = runtime.milliseconds();
        while (runtime.milliseconds() - startTime < time) {
        }
    }

    public void strafeRightWithEncoders(double power, int count){
        int start = FrontLeft.getCurrentPosition();
        FrontLeft.setPower(power * 0.7);
        FrontRight.setPower(-power * 0.7);
        BackLeft.setPower(-power);
        BackRight.setPower(power);
        while(FrontLeft.getCurrentPosition() < start + count) {
            idle();
        }
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }

    public void strafeLeftWithEncoders(double power, int count){
        int start = FrontRight.getCurrentPosition();
        FrontLeft.setPower(-power * 0.7);
        FrontRight.setPower(power * 0.7);
        BackLeft.setPower(power);
        BackRight.setPower(-power);
        while(FrontRight.getCurrentPosition() < start + count) {
            idle();
        }
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }

    public void moveBackwardWithEncoders(double power, int count){
        int start = FrontLeft.getCurrentPosition();
        FrontLeft.setPower(-power * 0.7);
        FrontRight.setPower(-power * 0.7);
        BackLeft.setPower(-power);
        BackRight.setPower(-power);
        while(FrontLeft.getCurrentPosition() > start - count) {
            idle();
        }
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }

    public void moveForwardWithEncoders(double power, int count){
        int start = FrontLeft.getCurrentPosition();
        FrontLeft.setPower(power * 0.7);
        FrontRight.setPower(power * 0.7);
        BackLeft.setPower(power);
        BackRight.setPower(power);
        while(FrontLeft.getCurrentPosition() < start + count) {
            idle();
        }
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }

    public void turnLeftWithEncoders(double power, int count){
        int start = FrontRight.getCurrentPosition();
        FrontLeft.setPower(-power * 0.7);
        FrontRight.setPower(power * 0.7);
        BackLeft.setPower(-power);
        BackRight.setPower(power);
        while(FrontRight.getCurrentPosition() < start + count) {
            idle();
        }
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }

    public void turnRightWithEncoders(double power, int count){
        int start = FrontLeft.getCurrentPosition();
        FrontLeft.setPower(power * 0.7);
        FrontRight.setPower(-power * 0.7);
        BackLeft.setPower(power);
        BackRight.setPower(-power);
        while(FrontLeft.getCurrentPosition() < start + count) {
            idle();
        }
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }
}
