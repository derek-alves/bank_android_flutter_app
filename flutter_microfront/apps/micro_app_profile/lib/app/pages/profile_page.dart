import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:micro_core/micro_core.dart';

class ProfilePage extends StatelessWidget {
  const ProfilePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () {
            SystemNavigator.pop();
          },
        ),
        title: const Text('Profile'),
      ),
      body: Container(
        alignment: Alignment.center,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text("Profile", style: TextStyle(fontSize: 30)),
            ElevatedButton(
                onPressed: () {
                  navigateTo();
                },
                child: const Text("Click me "))
          ],
        ),
      ),
    );
  }

  navigateTo() {
    globalNavigatorKey.currentState?.pushNamed("AAAAAAAAAAAAAA");
  }
}
