import 'package:pigeon/pigeon.dart';

class MicroApp {
  String name;
  String route;
  MicroApp({required this.name, required this.route});
}

class Route {
  String path;
  Map<String, String> data;
  Route({required this.path, required this.data});
}

@HostApi()
abstract class FeatureHostApi {}

@FlutterApi()
abstract class FlutterCommunicationChannel {
  void navigateTo(Route route);
  List<MicroApp> syncFeatures();
}
