import 'package:pigeon/pigeon.dart';

class Feature {
  String name;
  String route;
  Feature({
    required this.name,
    required this.route,
  });
}

class Route {
  String path;
  Map<String?, String?> data;
  Route({
    required this.path,
    required this.data,
  });
}

@HostApi()
abstract class FeatureHostApi {}

@FlutterApi()
abstract class FeatureFlutterApi {
  void navigateTo(Route route);
  List<Feature> syncFeatures();
}
