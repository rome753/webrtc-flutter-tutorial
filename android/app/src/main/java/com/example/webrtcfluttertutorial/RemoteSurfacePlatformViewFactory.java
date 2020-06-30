package com.example.webrtcfluttertutorial;

import android.content.Context;
import android.util.Log;
import android.view.View;

import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class RemoteSurfacePlatformViewFactory extends PlatformViewFactory {

    public static String PLUGIN_KEY_SURFACE = "plugin_key_remote_surface";
    public static String PLUGIN_VIEW_TYPE_SURFACE = "view_type_remote_surface";

    private View surfaceView;

    public RemoteSurfacePlatformViewFactory(View surfaceView) {
        super(StandardMessageCodec.INSTANCE);
        this.surfaceView = surfaceView;
        Log.d("chao", "SurfacePlatformViewFactory init");
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        Log.d("chao", "SurfacePlatformViewFactory create");
        return new SurfacePlatformView(surfaceView);
    }

    public static void registerView(ShimPluginRegistry pluginRegistry, View surfaceView) {
        Log.d("chao", "SurfacePlatformViewFactory registerView");
        if (!pluginRegistry.hasPlugin(PLUGIN_KEY_SURFACE)) {
            PluginRegistry.Registrar registrar = pluginRegistry.registrarFor(PLUGIN_KEY_SURFACE);
            registrar.platformViewRegistry().registerViewFactory(PLUGIN_VIEW_TYPE_SURFACE, new RemoteSurfacePlatformViewFactory(surfaceView));
        }
    }

}
