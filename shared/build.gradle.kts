plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.20"
}

kotlin {
    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:1.0.0-rc10")
                implementation("cafe.adriel.voyager:voyager-navigator:1.0.0-rc10")
                implementation("cafe.adriel.voyager:voyager-transitions:1.0.0-rc10")
                implementation("cafe.adriel.voyager:voyager-tab-navigator:1.0.0-rc10")
                implementation(compose.material3)
                implementation("media.kamel:kamel-image:0.9.0")
                implementation("io.ktor:ktor-client-core:2.3.6")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.1")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.6")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.6")
                api("dev.icerock.moko:mvvm-core:0.16.1") // only ViewModel, EventsDispatcher, Dispatchers.UI
                api("dev.icerock.moko:mvvm-compose:0.16.1") // api mvvm-core, getViewModel for Compose Multiplatform
                // #1 - Basic settings
                implementation("com.russhwolf:multiplatform-settings-no-arg:1.1.1")

                // #2 - For custom class serialization
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
                implementation("com.russhwolf:multiplatform-settings-serialization:1.1.1")

                // #3 - For observing values as flows
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1")
                implementation("com.russhwolf:multiplatform-settings-coroutines:1.1.1")
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.activity:activity-compose:1.7.2")
                api("androidx.appcompat:appcompat:1.4.2")
                api("androidx.core:core-ktx:1.10.1")
                implementation("io.ktor:ktor-client-android:2.3.6")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation("io.ktor:ktor-client-darwin:2.3.6")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.myapplication.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}
dependencies {
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.5")
}
