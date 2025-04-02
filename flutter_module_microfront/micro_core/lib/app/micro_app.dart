import 'micro_core_utils.dart';

abstract class MicroApp {
  String get microAppName;

  Map<String, WidgetBuilderArgs> get routes;

  void Function() get injectionsRegister;

  void Function() get createListener;

  MicroAppFeature get feature;
}

class MicroAppFeature {
  final String name;
  final String baseRoute;

  MicroAppFeature({
    required this.name,
    required this.baseRoute,
  });
}
