package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions.Feb6;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

public class TFODFunctions extends LinearOpMode{

    public HardwareMap hwMap = null;

    public String vuforiaKey = "AQJCq9P/////AAABmRF3bj1dCUxOiN/kZJz6n+8AMWhQRttZrjuCfDKY/h6MyolB6NeVIvECXtaieNHxOgiLDloKRhY65smtSdEc3SA8k2i27bmjRwnSTh45hWcSbIyUuK9UdrtD4cTiGtS1NZchY50k4vgBp3so0hATwlv413gRNjhVKLE2RVPqsWDnecCEvBRlAzk2Pgm0QEBMR5pV/amkShrWssyq317OuJ7NgZW0IgsEc6xS3wykAl2SlFlWPXj+n7JlW+E044nYZLXn2invAz4WT/i8enbJn41qPokfT60jk6HFYsutdb5LeHNui8B4+lO+7riOvrVJnKT25QGchiO9TZHdAepynUelShm1u+eJa5HjNpGVHNeT";
    public static final String TFOD_MODEL_ASSET = "FreightFrenzy_DM.tflite";
    public static final String[] LABELS = {
            "Duck",
            "Marker"
    };
    public List<Recognition> updatedRecognitions = null;
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
    public int height = 3;


    public void initVuforia() {
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = vuforiaKey;
        parameters.cameraName = hwMap.get(WebcamName.class, "EagleEyes");

        vuforia = ClassFactory.getInstance().createVuforia(parameters);

    }

    public void initTfod() {
        int tfodMonitorViewId = hwMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hwMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.8f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 320;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
    }

    public void initProcesses() {
        initVuforia();
        initTfod();
    }

    public void TfodOnZoom() {
        if (tfod != null) {
            tfod.activate();
            tfod.setZoom(2.5, 16.0/9.0);
        }
    }

    public void checkForStuff() {
        if (tfod != null) {
            List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
            if (updatedRecognitions != null) {
                telemetry.addData("# Object Detected", updatedRecognitions.size());
                // step through the list of recognitions and display boundary info.

                telemetry.update();
            }
        }
    }
    public void iterateRecognitions() {
        for (Recognition recognition : updatedRecognitions) {
            int i = 0;
            telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
            telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                    recognition.getLeft(), recognition.getTop());
            telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                    recognition.getRight(), recognition.getBottom());
            if (recognition.getLeft() > 300 && recognition.getRight() < 800) { //STAND IN VALUE
               height = 1;
            } else if (recognition.getLeft() > 900 && recognition.getRight() < 1000) { //STAND IN VALUE
                height = 2;
            } else if (recognition.getLeft() > 1100 && recognition.getRight() < 1200) { //STAND IN VALUE
                height = 3;
            } else {
                height = 3;
            }
            i++;
        }
    }

    public void runOpMode() {

    }
}
