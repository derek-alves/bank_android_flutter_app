import 'package:flutter/material.dart';
import 'package:design_system/design_system.dart';

class StatementsPage extends StatelessWidget {
  const StatementsPage({super.key});

  @override
  Widget build(BuildContext context) {
    var textTheme = ThemeCustom.textTheme();
    var sizes = ThemeCustom.sizes;
    var colors = ThemeCustom.colors;
    return Scaffold(
      appBar: AppBarCustom(
        title: Text(
          "Statements",
          style: ThemeCustom.textTheme().titleMedium,
        ),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        mainAxisAlignment: MainAxisAlignment.start,
        children: [
          Column(
            children: [
              Text(
                'Chika Adien A.P',
                style: textTheme.titleMedium,
              ),
              Text(
                'Bank Number - 77421348213',
                style: textTheme.headlineSmall,
              ),
            ],
          ),
          SizedBox(height: sizes.sm),
          FittedBox(
            child: Container(
              padding: EdgeInsets.symmetric(
                  vertical: sizes.xxs, horizontal: sizes.sm),
              decoration: BoxDecoration(
                color: colors.white,
                borderRadius: BorderRadius.all(Radius.circular(sizes.xs)),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    "Balance",
                    style: textTheme.headlineMedium,
                  ),
                  SizedBox(width: sizes.sm),
                  Text(
                    "\$ 142,883.00",
                    style: textTheme.headlineMedium?.copyWith(
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ],
              ),
            ),
          ),
          SizedBox(height: sizes.lg),
          FittedBox(
            child: Container(
              padding: EdgeInsets.all(sizes.xxs),
              height: sizes.xxxl,
              decoration: BoxDecoration(
                borderRadius: BorderRadius.all(Radius.circular(sizes.xxl)),
                gradient: LinearGradient(
                  colors: [
                    const Color(0xff383838).withOpacity(0.3),
                    colors.black,
                  ],
                  begin: Alignment.topCenter,
                  end: Alignment.bottomCenter,
                ),
              ),
              child: Container(
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.all(Radius.circular(sizes.xxl)),
                    border: Border.all(color: colors.darkOrange),
                  ),
                  padding: EdgeInsets.symmetric(horizontal: sizes.xl),
                  child: Row(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Text(
                            "Income",
                            style: textTheme.headlineLarge,
                          ),
                          SizedBox(height: sizes.xxs),
                          Container(
                            height: 4,
                            width: 48,
                            decoration: BoxDecoration(
                              gradient: LinearGradient(
                                colors: [
                                  colors.lightOrang,
                                  colors.pink,
                                ],
                                begin: Alignment.topCenter,
                                end: Alignment.bottomCenter,
                              ),
                            ),
                          )
                        ],
                      ),
                      SizedBox(width: sizes.xxxl),
                      Column(
                        mainAxisSize: MainAxisSize.min,
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Text(
                            "Outcome",
                            style: textTheme.headlineLarge,
                          ),
                          SizedBox(height: sizes.xxs),
                          Row(
                            children: [
                              Container(
                                height: 4,
                                width: 28,
                                decoration: BoxDecoration(
                                  gradient: LinearGradient(
                                    colors: [
                                      colors.lightOrang,
                                      colors.pink,
                                    ],
                                    begin: Alignment.topCenter,
                                    end: Alignment.bottomCenter,
                                  ),
                                ),
                              ),
                              SizedBox(width: sizes.xs),
                              Container(
                                height: 4,
                                width: 28,
                                decoration: BoxDecoration(
                                  gradient: LinearGradient(
                                    colors: [
                                      colors.lightOrang,
                                      colors.pink,
                                    ],
                                    begin: Alignment.topCenter,
                                    end: Alignment.bottomCenter,
                                  ),
                                ),
                              )
                            ],
                          )
                        ],
                      )
                    ],
                  )),
            ),
          ),
          const ChartCustom(),
          Container(
            child: Row(
              children: [Text("Recent Income Flow"), Text("May")],
            ),
          )
        ],
      ),
    );
  }
}
