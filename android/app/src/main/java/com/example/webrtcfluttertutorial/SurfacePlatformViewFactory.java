package com.example.webrtcfluttertutorial;

import android.content.Context;
import android.util.Log;
import android.view.View;

import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class SurfacePlatformViewFactory extends PlatformViewFactory {

    public static String PLUGIN_KEY_SURFACE = "plugin_key_surface";
    public static String PLUGIN_VIEW_TYPE_SURFACE = "view_type_surface";

    private BinaryMessenger binaryMessenger;
    private SurfacePlatformView surfacePlatformView;

    public SurfacePlatformViewFactory(BinaryMessenger binaryMessenger) {
        super(StandardMessageCodec.INSTANCE);
        this.binaryMessenger = binaryMessenger;
        Log.d("chao", "SurfacePlatformViewFactory init");
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        Log.d("chao", "SurfacePlatformViewFactory create");
        surfacePlatformView = new SurfacePlatformView(context, binaryMessenger, viewId);
        return surfacePlatformView;
    }

    public View getSurfaceView() {
        Log.d("chao", "SurfacePlatformViewFactory getSurfaceView");
        return surfacePlatformView == null ? null : surfacePlatformView.getView();
    }

    public static SurfacePlatformViewFactory registerView(ShimPluginRegistry pluginRegistry) {
        Log.d("chao", "SurfacePlatformViewFactory registerView");
        if (!pluginRegistry.hasPlugin(PLUGIN_KEY_SURFACE)) {
            PluginRegistry.Registrar registrar = pluginRegistry.registrarFor(PLUGIN_KEY_SURFACE);
            SurfacePlatformViewFactory platformViewFactory = new SurfacePlatformViewFactory(registrar.messenger());
            registrar.platformViewRegistry().registerViewFactory(PLUGIN_VIEW_TYPE_SURFACE, platformViewFactory);
            return platformViewFactory;
        }
        return null;
    }

}
