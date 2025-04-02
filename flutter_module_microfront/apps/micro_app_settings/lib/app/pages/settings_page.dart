import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:micro_core/micro_core.dart';

class SettingsPage extends StatelessWidget {
  const SettingsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.green,
      appBar: AppBar(
        title: const Text('Settings'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () {
            SystemNavigator.pop();
          },
        ),
      ),
      body: Container(
        alignment: Alignment.center,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text("Settings", style: TextStyle(fontSize: 30)),
            ElevatedButton(
              onPressed: () {
                navigateTo();
              },
              child: const Text("Click me "),
            ),
          ],
        ),
      ),
    );
  }

  navigateTo() {
    globalNavigatorKey.currentState?.pushNamed("AAAAAAAAAAAAAA");
  }
}
