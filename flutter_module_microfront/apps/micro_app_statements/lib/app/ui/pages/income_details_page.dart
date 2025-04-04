import 'package:design_system/design_system.dart';
import 'package:flutter/material.dart';

class IncomeDetailsPage extends StatelessWidget with DesignSystemMixin {
  IncomeDetailsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBarCustom(
        title: Text("Income Details", style: textTheme.titleMedium),
      ),
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.start,
          children: [],
        ),
      ),
    );
  }
}
