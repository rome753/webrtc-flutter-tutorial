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

public class SurfacePlatformView implements PlatformView {

    private View surfaceView;

    public SurfacePlatformView(View surfaceView) {
        Log.d("chao", "SurfacePlatformView init");
        this.surfaceView = surfaceView;
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
