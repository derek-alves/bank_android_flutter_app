import 'package:micro_app_statements/app/ui/pages/income_details_page.dart';
import 'package:micro_app_statements/app/ui/pages/statements_page.dart';
import 'package:micro_core/app/micro_app.dart';
import 'package:micro_core/app/micro_core_utils.dart';

import 'di/di.dart';

class MicroAppStatementsResolver implements MicroApp {
  @override
  String get microAppName => 'micro_app_statements';

  @override
  MicroAppFeature get feature =>
      MicroAppFeature(name: 'statements', baseRoute: '/statements');

  @override
  Map<String, WidgetBuilderArgs> get routes => {
    '/statements': (context, args) => StatementsPage(),
    '/statements/income-details': (context, args) => IncomeDetailsPage(),
  };

  @override
  void Function() get injectionsRegister => Injector.initialize;

  @override
  void Function() get createListener => () {};
}
