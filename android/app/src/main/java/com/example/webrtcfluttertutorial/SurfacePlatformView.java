package com.example.webrtcfluttertutorial;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import org.webrtc.SurfaceViewRenderer;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;

public class SurfacePlatformView implements PlatformView, MethodChannel.MethodCallHandler {

    private static final String METHOD_CHANNEL_NAME = "MessagePlatformMethodChannel";
    private View surfaceView;
    private final MethodChannel methodChannel;

    public SurfacePlatformView(Context context, BinaryMessenger messenger, int id, View surfaceView) {
        Log.d("chao", "SurfacePlatformView init");
        methodChannel = new MethodChannel(messenger, METHOD_CHANNEL_NAME);
        methodChannel.setMethodCallHandler(this);

        this.surfaceView = surfaceView;
    }

    @Override
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Log.d("chao", "SurfacePlatformView onMethodCall");
//        switch (call.method) {
//
//        }
    }

    @Override
    public View getView() {
        Log.d("chao", "SurfacePlatformView getView");
        return surfaceView;
    }

    @Override
    public void dispose() {
        Log.d("chao", "SurfacePlatformView dispose");

    }
}
