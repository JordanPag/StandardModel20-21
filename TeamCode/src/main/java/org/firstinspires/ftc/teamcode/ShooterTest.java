package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Jordan Paglione on 12/1/20.
 */
//@Disabled
@TeleOp(name="Shooting test", group="Iterative Opmode")
public class ShooterTest extends OpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;
    private DcMotor Shooter;
    //private DcMotor Intake;
    //private DcMotor IntakeRight;
    //private DcMotor Treadmill;
    //private Servo FoundationServo;
    double startTime = runtime.milliseconds();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        Shooter = hardwareMap.get(DcMotor.class, "Shooter");
        //IntakeLeft = hardwareMap.get(DcMotor.class, "IntakeLeft");
        //IntakeRight = hardwareMap.get(DcMotor.class, "IntakeRight");
        //Treadmill = hardwareMap.get(DcMotor.class, "Treadmill");
        //FoundationServo = hardwareMap.get(Servo.class, "FoundationServo");



        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        FrontRight.setDirection(DcMotor.Direction.FORWARD);
        BackRight.setDirection(DcMotor.Direction.FORWARD);
        Shooter.setDirection(DcMotor.Direction.REVERSE);
        //IntakeLeft.setDirection(DcMotor.Direction.REVERSE);
        //IntakeRight.setDirection(DcMotor.Direction.FORWARD);
        //Treadmill.setDirection(DcMotor.Direction.FORWARD);

        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Shooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //IntakeLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        //IntakeRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        //Treadmill.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }


    @Override
    public void init_loop() {
        //Servo1.setPosition(0.3);
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */

    public void loop() {

        //Test shooter code
        if (gamepad1.a) {
            Shooter.setPower(1);
        } else if (gamepad1.b) {
            Shooter.setPower(-1);
        } else {
            Shooter.setPower(0);
        }


        // Show the elapsed game time
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();
    }
}