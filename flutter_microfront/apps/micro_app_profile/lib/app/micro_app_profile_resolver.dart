import 'package:micro_app_profile/app/di/injector.dart';
import 'package:micro_app_profile/app/pages/profile_page.dart';
import 'package:micro_core/app/micro_app.dart';
import 'package:micro_core/app/micro_core_utils.dart';

class MicroAppProfileResolver implements MicroApp {
  @override
  String get microAppName => 'micro_app_profile';

  @override
  Map<String, WidgetBuilderArgs> get routes => {
        '/profile': (context, args) => const ProfilePage(),
      };

  @override
  void Function() get injectionsRegister => Injector.initialize;

  @override
  void Function() get createListener => () {};

  @override
  MicroAppFeature get feature => MicroAppFeature(
        name: 'profile',
        baseRoute: '/profile',
      );
}
