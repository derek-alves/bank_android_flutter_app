// Autogenerated from Pigeon (v9.2.5), do not edit directly.
// See also: https://pub.dev/packages/pigeon
// ignore_for_file: public_member_api_docs, non_constant_identifier_names, avoid_as, unused_import, unnecessary_parenthesis, prefer_null_aware_operators, omit_local_variable_types, unused_shown_name, unnecessary_import

import 'dart:async';
import 'dart:typed_data' show Float64List, Int32List, Int64List, Uint8List;

import 'package:flutter/foundation.dart' show ReadBuffer, WriteBuffer;
import 'package:flutter/services.dart';

class Feature {
  Feature({
    required this.name,
    required this.route,
  });

  String name;

  String route;

  Object encode() {
    return <Object?>[
      name,
      route,
    ];
  }

  static Feature decode(Object result) {
    result as List<Object?>;
    return Feature(
      name: result[0]! as String,
      route: result[1]! as String,
    );
  }
}

class Route {
  Route({
    required this.path,
    required this.data,
  });

  String path;

  Map<String?, String?> data;

  Object encode() {
    return <Object?>[
      path,
      data,
    ];
  }

  static Route decode(Object result) {
    result as List<Object?>;
    return Route(
      path: result[0]! as String,
      data: (result[1] as Map<Object?, Object?>?)!.cast<String?, String?>(),
    );
  }
}

class _FeatureHostApiCodec extends StandardMessageCodec {
  const _FeatureHostApiCodec();
  @override
  void writeValue(WriteBuffer buffer, Object? value) {
    if (value is Feature) {
      buffer.putUint8(128);
      writeValue(buffer, value.encode());
    } else {
      super.writeValue(buffer, value);
    }
  }

  @override
  Object? readValueOfType(int type, ReadBuffer buffer) {
    switch (type) {
      case 128: 
        return Feature.decode(readValue(buffer)!);
      default:
        return super.readValueOfType(type, buffer);
    }
  }
}

class FeatureHostApi {
  /// Constructor for [FeatureHostApi].  The [binaryMessenger] named argument is
  /// available for dependency injection.  If it is left null, the default
  /// BinaryMessenger will be used which routes to the host platform.
  FeatureHostApi({BinaryMessenger? binaryMessenger})
      : _binaryMessenger = binaryMessenger;
  final BinaryMessenger? _binaryMessenger;

  static const MessageCodec<Object?> codec = _FeatureHostApiCodec();

  Future<void> syncFeatures(List<Feature?> arg_features) async {
    final BasicMessageChannel<Object?> channel = BasicMessageChannel<Object?>(
        'dev.flutter.pigeon.FeatureHostApi.syncFeatures', codec,
        binaryMessenger: _binaryMessenger);
    final List<Object?>? replyList =
        await channel.send(<Object?>[arg_features]) as List<Object?>?;
    if (replyList == null) {
      throw PlatformException(
        code: 'channel-error',
        message: 'Unable to establish connection on channel.',
      );
    } else if (replyList.length > 1) {
      throw PlatformException(
        code: replyList[0]! as String,
        message: replyList[1] as String?,
        details: replyList[2],
      );
    } else {
      return;
    }
  }
}

class _FeatureFlutterApiCodec extends StandardMessageCodec {
  const _FeatureFlutterApiCodec();
  @override
  void writeValue(WriteBuffer buffer, Object? value) {
    if (value is Route) {
      buffer.putUint8(128);
      writeValue(buffer, value.encode());
    } else {
      super.writeValue(buffer, value);
    }
  }

  @override
  Object? readValueOfType(int type, ReadBuffer buffer) {
    switch (type) {
      case 128: 
        return Route.decode(readValue(buffer)!);
      default:
        return super.readValueOfType(type, buffer);
    }
  }
}

abstract class FeatureFlutterApi {
  static const MessageCodec<Object?> codec = _FeatureFlutterApiCodec();

  void navigateTo(Route route);

  static void setup(FeatureFlutterApi? api, {BinaryMessenger? binaryMessenger}) {
    {
      final BasicMessageChannel<Object?> channel = BasicMessageChannel<Object?>(
          'dev.flutter.pigeon.FeatureFlutterApi.navigateTo', codec,
          binaryMessenger: binaryMessenger);
      if (api == null) {
        channel.setMessageHandler(null);
      } else {
        channel.setMessageHandler((Object? message) async {
          assert(message != null,
          'Argument for dev.flutter.pigeon.FeatureFlutterApi.navigateTo was null.');
          final List<Object?> args = (message as List<Object?>?)!;
          final Route? arg_route = (args[0] as Route?);
          assert(arg_route != null,
              'Argument for dev.flutter.pigeon.FeatureFlutterApi.navigateTo was null, expected non-null Route.');
          api.navigateTo(arg_route!);
          return;
        });
      }
    }
  }
}
