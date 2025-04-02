pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven (
            settingsDir.parentFile.toString() + "/flutter_module_microfront/main_module/build/host/outputs/repo"
            )
        maven(url = "https://storage.googleapis.com/download.flutter.io")

    }


}



rootProject.name = "main_app"
include(":app")
//(from = File(settingsDir.parentFile, "flutter_module_microfront/main_module/.android/include_flutter.groovy"))
