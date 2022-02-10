package org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.Functions;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.CVPipelines.ContourPipeline;
import org.firstinspires.ftc.teamcode.drive.tempOpModeAndHardware.CVPipelines.YellowAVGPipeline;
import org.opencv.core.Scalar;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

public class EOCV_Functions extends LinearOpMode {

    private OpenCvCamera webcam;
    WebcamName webcamName;

    private YellowAVGPipeline pipeline;

    public int liftHeight;

    public void initWebcam(HardwareMap hwMap) {
        // OpenCV webcam
        webcamName = hwMap.get(WebcamName.class, "EagleEyes");
        webcam = OpenCvCameraFactory.getInstance().createWebcam(webcamName);
    }

    public void initPipeline() {
        // OpenCV pipeline
        pipeline = new YellowAVGPipeline();

        webcam.setPipeline(pipeline);
    }

    public void webcamStream() {
        // Webcam Streaming
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });
    }

    public void processImage() {
        liftHeight = pipeline.position;
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
