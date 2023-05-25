import 'package:design_system/design_system.dart';
import 'package:flutter/material.dart';

class AppBarCustom extends StatelessWidget implements PreferredSizeWidget {
  final Widget title;
  const AppBarCustom({
    super.key,
    required this.title,
  });

  @override
  Size get preferredSize => const Size.fromHeight(kToolbarHeight);

  @override
  Widget build(BuildContext context) {
    return AppBar(
      leading: IconButton(
        onPressed: () {},
        icon: const Icon(Icons.arrow_back_ios),
        padding: const EdgeInsets.only(left: 26),
      ),
      centerTitle: true,
      title: title,
      elevation: 0,
    );
  }
}
