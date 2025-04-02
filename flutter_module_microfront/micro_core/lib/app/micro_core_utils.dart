import 'package:flutter/widgets.dart';

typedef WidgetBuilderArgs = Widget Function(BuildContext context, Object? args);
GlobalKey<NavigatorState> _navigatorKey = GlobalKey<NavigatorState>();
GlobalKey<NavigatorState> get globalNavigatorKey => _navigatorKey;
