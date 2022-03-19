package com.ixidev.opencvandroidtemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.ixidev.opencvandroidtemplate.databinding.ActivityMainBinding;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'opencvandroidtemplate' library on application startup.
    static {
        System.loadLibrary("opencvandroidtemplate");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'opencvandroidtemplate' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    /**
     * Example  of using jni opencv
     * see {@link com.ixidev.opencvandroidtemplate.MainActivity#exampleUsingOpenCVFun()}
     * @param input  : cv::Mat address
     * @param output : cv::Mat address
     *
     */
    public native void opencvExample(long input, long output);

    private void exampleUsingOpenCVFun() {


//        Utils.bitmapToMat(); // read bitmap to mat
        Mat input = Mat.zeros(100, 100, CvType.CV_8UC1); // read input somewhere
        Mat output = Mat.zeros(100, 100, CvType.CV_8UC1);

        opencvExample(input.getNativeObjAddr(), output.getNativeObjAddr());
        // ....
        // todo :  show output


//        Utils.matToBitmap(); // write mat to bitmap and display it

    }
}