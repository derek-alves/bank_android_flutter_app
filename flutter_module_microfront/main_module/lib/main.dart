import 'package:flutter/material.dart';
import 'package:micro_app_profile/micro_app_profile.dart';
import 'package:micro_app_settings/micro_app_settings.dart';
import 'package:micro_app_statements/micro_app_statements.dart';
import 'package:micro_core/micro_core.dart';

import './infra/android_comunication_api.dart' as api;
import 'src/pages/pages.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  runApp(MyApp());
}

class MyApp extends StatefulWidget with BaseApp {
  MyApp({super.key}) {
    super.registerRouters();
    super.registerInjections();
    super.registerListeners();
    super.registerFeatures();
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

    api.FlutterCommunicationChannel.setUp(
      FlutterBookApiHendler(features: widget.features),
    );
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

class FlutterBookApiHendler extends api.FlutterCommunicationChannel {
  final List<MicroAppFeature> features;

  FlutterBookApiHendler({required this.features});

  @override
  void navigateTo(api.Route route) {
    globalNavigatorKey.currentState?.pushReplacementNamed(
      route.path,
      arguments: route.data,
    );
  }

  @override
  List<api.MicroApp> syncFeatures() {
    final List<api.MicroApp> apiFeatures =
        features
            .map(
              (feature) =>
                  api.MicroApp(name: feature.name, route: feature.baseRoute),
            )
            .toList();

    return apiFeatures;
  }
}
