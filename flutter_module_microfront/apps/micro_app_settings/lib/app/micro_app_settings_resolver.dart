import 'package:micro_core/app/micro_app.dart';
import 'package:micro_core/app/micro_core_utils.dart';

import 'di/injector.dart';
import 'pages/pages.dart';

class MicroAppSettingsResolver implements MicroApp {
  @override
  String get microAppName => 'micro_app_settings';

  @override
  MicroAppFeature get feature =>
      MicroAppFeature(name: 'settings', baseRoute: '/settings');

  @override
  Map<String, WidgetBuilderArgs> get routes => {
        '/settings': (context, args) => const SettingsPage(),
      };

  @override
  void Function() get injectionsRegister => Injector.initialize;

  @override
  void Function() get createListener => () {};
}
