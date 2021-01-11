package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Driver Mode", group="Manual")
public class DriverMode extends LinearOpMode {

    @Override
    public void runOpMode() {
        HardwareConfig cfg = new HardwareConfig(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            double leftPower1;
            double rightPower1;
            double leftPower2;
            double rightPower2;

            int reverseDrive = 1;
            int reverseTurn = 1;
            int reverseStrafe = 1;

            double drive = gamepad1.left_stick_y * reverseDrive;
            double turn = gamepad1.left_stick_x * reverseTurn;
            double strafe = gamepad1.right_stick_x * reverseStrafe;

            leftPower1 = drive + turn;
            rightPower1 = drive - turn;
            leftPower2 = drive + turn;
            rightPower2 = drive - turn;

            if (strafe != 0) {
                leftPower1 = strafe;
                rightPower1 = -strafe;
                leftPower2 = -strafe;
                rightPower2 = strafe;
            }

            cfg.leftDrive1.setPower(leftPower1);
            cfg.rightDrive1.setPower(rightPower1);
            cfg.leftDrive2.setPower(leftPower2);
            cfg.rightDrive2.setPower(rightPower2);
        }
    }
}