import 'package:flutter/material.dart';
import 'package:micro_app_profile/micro_app_profile.dart';
import 'package:micro_app_settings/micro_app_settings.dart';
import 'package:micro_app_statements/micro_app_statements.dart';

import 'package:micro_core/micro_core.dart';

import 'api.dart' as api;
import 'src/pages/pages.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  Paint.enableDithering = true;
  runApp(MyApp());
}

class MyApp extends StatefulWidget with BaseApp {
  MyApp({Key? key}) : super(key: key) {
    super.registerRouters();
    super.registerInjections();
    super.registerListeners();
    super.registerFeatures();

    // final List<api.Feature> features = super
    //     .features
    //     .map(
    //       (feature) => api.Feature(
    //         name: feature.name,
    //         route: feature.baseRoute,
    //       ),
    //     )
    //     .toList();
    // api.FeatureHostApi().syncFeatures(features);
  }

  @override
  State<MyApp> createState() => _MyAppState();

  @override
  Map<String, WidgetBuilderArgs> get baseRoutes => {};

  @override
  List<MicroApp> get microApps => [
        MicroAppStatementsResolver(),
        MicroAppProfileResolver(),
        MicroAppSettingsResolver(),
      ];
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();

    api.FeatureFlutterApi.setup(FlutterBookApiHendler());
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      navigatorKey: globalNavigatorKey,
      onGenerateRoute: widget.generateRoute,
      initialRoute: '/statements',
      debugShowCheckedModeBanner: false,
      themeMode: ThemeMode.dark,
      darkTheme: ThemeData(
        fontFamily: "Inter",
        scaffoldBackgroundColor: const Color(0xff0D0D0D),
        colorScheme: const ColorScheme.dark().copyWith(
          surfaceTint: const Color(0xff0D0D0D),
          surface: const Color(0xff0D0D0D),
        ),
      ),
      onUnknownRoute: (RouteSettings settings) {
        return MaterialPageRoute<void>(
          settings: settings,
          builder: (BuildContext context) => const GenericMicroAppError(),
        );
      },
    );
  }
}

class FlutterBookApiHendler extends api.FeatureFlutterApi {
  @override
  void navigateTo(api.Route route) {
    globalNavigatorKey.currentState
        ?.pushReplacementNamed(route.path, arguments: route.data);
  }
}
