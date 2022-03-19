#include <jni.h>
#include <string>
#include "opencv2/opencv.hpp"
#include "opencv2/core.hpp"

extern "C" JNIEXPORT jstring JNICALL
Java_com_ixidev_opencvandroidtemplate_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++, OpenCV Version " + cv::getVersionString();

    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_ixidev_opencvandroidtemplate_MainActivity_opencvExample(
        JNIEnv *env,
        jobject thiz,
        jlong input, jlong output) {


    cv::Mat *intMat = (cv::Mat *) input;
    cv::Mat *outMat = (cv::Mat *) input;

    // todo process inMat and save result to outMat
}