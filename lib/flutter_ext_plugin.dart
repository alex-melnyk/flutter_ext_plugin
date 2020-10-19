import 'dart:async';
import 'dart:ui';

import 'package:flutter/services.dart';

class FlutterExtPlugin {
  static const MethodChannel _channel = const MethodChannel('flutter_ext_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<Color> generateColor() async {
    final randomColor = await _channel.invokeListMethod('generateColor');

    return Color.fromRGBO(randomColor[0], randomColor[1], randomColor[2], 1.0);
  }
}
