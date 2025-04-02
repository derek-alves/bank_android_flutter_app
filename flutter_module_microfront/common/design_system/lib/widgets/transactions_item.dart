// ignore_for_file: public_member_api_docs, sort_constructors_first
import 'package:design_system/design_system.dart';
import 'package:flutter/material.dart';

class TransactionItem extends StatelessWidget with DesignSystemMixin {
  final String title;
  final String description;
  final Widget icon;
  final String value;
  TransactionItem({
    super.key,
    required this.title,
    required this.description,
    required this.value,
    this.icon = const Icon(Icons.arrow_circle_right_outlined),
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.only(bottom: sizes.sm),
      padding: EdgeInsets.only(bottom: sizes.xs),
      decoration: BoxDecoration(
        border: Border(bottom: BorderSide(color: colors.grey, width: 0.6)),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Row(
            children: [
              icon,
              SizedBox(width: sizes.sm),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(title, style: textTheme.headlineLarge),
                  Text(
                    description,
                    style: textTheme.headlineSmall?.copyWith(fontSize: 10),
                  ),
                ],
              ),
            ],
          ),
          Text(
            "\$ $value",
            style: textTheme.headlineLarge?.copyWith(
              color: colors.green,
              fontWeight: FontWeight.normal,
            ),
          ),
        ],
      ),
    );
  }
}
