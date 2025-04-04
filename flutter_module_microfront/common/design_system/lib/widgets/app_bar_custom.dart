import 'package:flutter/material.dart';

class AppBarCustom extends StatelessWidget implements PreferredSizeWidget {
  final Widget title;
  final void Function()? onBackButtonPressed;
  const AppBarCustom({
    super.key,
    required this.title,
    this.onBackButtonPressed,
  });

  @override
  Size get preferredSize => const Size.fromHeight(kToolbarHeight);

  @override
  Widget build(BuildContext context) {
    return AppBar(
      leading: IconButton(
        onPressed:
            onBackButtonPressed ??
            () {
              Navigator.of(context).pop();
            },
        icon: const Icon(Icons.arrow_back_ios),
        padding: const EdgeInsets.only(left: 26),
      ),
      centerTitle: true,
      title: title,
      elevation: 0,
    );
  }
}
