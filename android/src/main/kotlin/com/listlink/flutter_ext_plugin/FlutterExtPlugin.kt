package com.listlink.flutter_ext_plugin

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

/** FlutterExtPlugin */
class FlutterExtPlugin : FlutterPlugin, MethodCallHandler {
    companion object {
        const val CHANNEL_NAME = "flutter_ext_plugin"

        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), CHANNEL_NAME)
            channel.setMethodCallHandler(FlutterExtPlugin())
        }
    }

    private lateinit var channel: MethodChannel

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, CHANNEL_NAME)
        channel.setMethodCallHandler(this)
    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        when (call.method) {
          "getPlatformVersion" -> {
            result.success("Android ${android.os.Build.VERSION.RELEASE}")
          }
          "generateColor" -> {
            val randomColor = generateColor()
            result.success(randomColor)
          }
            else -> result.notImplemented()
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    /**
     * Generates random RGB color.
     */
    private fun generateColor(): List<Int> {
        return arrayOf(0, 0, 0).map { (Math.random() * 256).toInt() }
    }
}
