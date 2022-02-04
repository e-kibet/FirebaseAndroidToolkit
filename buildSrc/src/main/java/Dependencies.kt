object Versions {
    const val navVersion = "2.4.0"
}


object Dependencies{
    const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"

    const val core = "androidx.core:core-ktx:1.7.0"
    const val appCompat = "androidx.appcompat:appcompat:1.4.1"
    const val material = "com.google.android.material:material:1.5.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"

    // Kotlin
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"

    // import firebase BOM
    const val firebaseBom = "com.google.firebase:firebase-bom:29.0.4"

    // Firebase SDK for Google Analytics
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics"

    // firebase remote config lib
    const val firebaseConfig = "com.google.firebase:firebase-config-ktx"

    // timber logger
    const val timber = "com.jakewharton.timber:timber:5.0.1"
}