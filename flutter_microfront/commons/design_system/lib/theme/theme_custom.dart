import 'package:design_system/design_system.dart';
import 'package:design_system/theme/sizes_custom.dart';
import 'package:flutter/material.dart';

class ThemeCustom {
  static var sizes = const SizesCustom();
  static var colors = const ColorsCustom();
  static TextTheme textTheme() => TextTheme(
        titleMedium: const TextStyle(
          fontFamily: "Inter",
          fontSize: 24,
          fontWeight: FontWeight.bold,
        ),
        labelSmall: TextStyle(
          fontFamily: "Inter",
          fontSize: 16,
          fontWeight: FontWeight.w600,
          color: const ColorsCustom().white,
        ),
        headlineLarge: TextStyle(
          fontFamily: "Inter",
          fontSize: 14,
          fontWeight: FontWeight.w600,
          color: const ColorsCustom().white,
        ),
        headlineMedium: TextStyle(
          fontFamily: "Inter",
          fontSize: 14,
          fontWeight: FontWeight.w300,
          color: const ColorsCustom().black,
        ),
        headlineSmall: TextStyle(
          fontFamily: "Inter",
          fontSize: 12,
          fontWeight: FontWeight.w300,
          color: const ColorsCustom().white,
        ),
      );
}
