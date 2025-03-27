flutter pub run pigeon \
  --input pigeon/feature_schema.dart \
  --dart_out lib/api.dart \
  --kotlin_out ../../app_android/app/src/main/java/com/bank/app_android/infra/flutter_module/flutter_features_api.kt \
  --kotlin_package "dev.flutter.module.features" \