import 'dart:ui';

import 'package:dependencies/dependencies.dart';
import 'package:design_system/design_system.dart';
import 'package:flutter/material.dart';

class ChartCustom extends StatefulWidget {
  const ChartCustom({Key? key}) : super(key: key);

  @override
  State<ChartCustom> createState() => _ChartCustomState();
}

class _ChartCustomState extends State<ChartCustom> {
  late final List<ChartData> data;
  @override
  void initState() {
    super.initState();

    data = const [
      ChartData(day: 17, price: 21500),
      ChartData(day: 18, price: 22650),
      ChartData(day: 19, price: 21220),
      ChartData(day: 20, price: 22997),
      ChartData(day: 21, price: 22883),
      ChartData(day: 22, price: 22635),
      ChartData(day: 23, price: 21800),
      ChartData(day: 24, price: 23500),
      ChartData(day: 25, price: 21354),
      ChartData(day: 26, price: 22354),
    ];
  }

  @override
  Widget build(BuildContext context) {
    return Stack(children: [
      Container(
        height: 300,
        decoration: BoxDecoration(
            gradient: RadialGradient(
          colors: [
            const Color(0xff340923),
            const Color(0xff0D0D0D).withOpacity(0.001)
          ],
        )),
      ),
      SizedBox(
        height: 300,
        child: SfCartesianChart(
          plotAreaBorderWidth: 0,
          margin: const EdgeInsets.all(0),
          borderWidth: 0,
          borderColor: Colors.transparent,
          primaryXAxis: NumericAxis(
              minimum: 17,
              maximum: 26,
              isVisible: false,
              interval: 1,
              borderWidth: 0,
              borderColor: Colors.transparent),
          primaryYAxis: NumericAxis(
              minimum: 19000,
              maximum: 24000,
              isVisible: false,
              interval: 1000,
              borderWidth: 0,
              borderColor: Colors.transparent),
          series: <ChartSeries<ChartData, int>>[
            SplineAreaSeries(
              dataSource: data,
              xValueMapper: (ChartData data, _) => data.day,
              yValueMapper: (ChartData data, _) => data.price,
              splineType: SplineType.natural,
              gradient: LinearGradient(
                colors: [
                  const Color(0xff35190A),
                  Color(0xff0D0D0D).withAlpha(150)
                ],
                begin: Alignment.topCenter,
                end: Alignment.bottomCenter,
              ),
            ),
            SplineSeries(
              dataSource: data,
              width: 2,
              color: ThemeCustom.colors.darkOrange,
              opacity: 0.6,
              xValueMapper: (ChartData data, _) => data.day,
              yValueMapper: (ChartData data, _) => data.price,
              splineType: SplineType.natural,
            ),
          ],
        ),
      ),
    ]);
  }
}

class ChartData {
  final int day;
  final double price;
  const ChartData({
    required this.day,
    required this.price,
  });
}
