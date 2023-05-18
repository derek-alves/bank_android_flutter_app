import './micro_core_utils.dart';

mixin NavigationMixin {
  Future<T?> navigateToNamed<T extends Object?>(String route) async {
    return globalNavigatorKey.currentState?.pushNamed(route);
  }
}
