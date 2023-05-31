import 'package:flutter/material.dart';

class GenericMicroAppError extends StatelessWidget {
  const GenericMicroAppError({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(backgroundColor: Colors.red),
      body: const Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              "Serviço indisponível no momento, tente mais tarde",
              style: TextStyle(
                color: Colors.red,
                fontSize: 36,
              ),
              textAlign: TextAlign.center,
            ),
          ]),
    );
  }
}
