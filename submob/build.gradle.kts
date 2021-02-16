/*
 * Copyright (c) 2021 Mustafa Ozhan. All rights reserved.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    with(Plugins) {
        id(androidLibrary)
        kotlin(multiplatform)
    }
}

kotlin {

    jvm()

    android()

    ios {
        binaries {
            framework {
                baseName = "scopemob"
            }
        }
    }

    js {
        browser {
            binaries.executable()
            testTask {
                enabled = false
            }
        }
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {

        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin(Dependencies.Common.test))
                implementation(kotlin(Dependencies.Common.testAnnotations))
            }
        }

        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(kotlin(Dependencies.JVM.testJUnit))
            }
        }

        val iosMain by getting
        val iosTest by getting

        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin(Dependencies.JVM.testJUnit))
            }
        }

        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin(Dependencies.JS.test))
            }
        }
    }
}

android {
    with(ProjectSettings) {
        compileSdkVersion(projectCompileSdkVersion)

        defaultConfig {
            minSdkVersion(projectMinSdkVersion)
            targetSdkVersion(projectTargetSdkVersion)
            versionCode = getVersionCode(project)
            versionName = getVersionName(project)
        }

        // todo https://youtrack.jetbrains.com/issue/KT-43944
        configurations {
            create("testApi") {}
            create("testDebugApi") {}
            create("testReleaseApi") {}
        }

        sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
