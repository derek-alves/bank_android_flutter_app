flutter pub run pigeon \
  --input pigeon/feature_schema.dart \
  --dart_out lib/api.dart \
  --kotlin_out ../../android_app/app/src/main/java/com/example/android_app/flutter_features_api.kt \
  --kotlin_package "dev.flutter.module.features" \