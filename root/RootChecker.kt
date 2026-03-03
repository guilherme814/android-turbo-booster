package com.seuapp.performance.root

import java.io.File

object RootChecker {

    fun isRooted(): Boolean {
        val paths = arrayOf(
            "/system/app/Superuser.apk",
            "/sbin/su",
            "/system/bin/su",
            "/system/xbin/su",
            "/data/local/xbin/su",
            "/data/local/bin/su"
        )

        return paths.any { File(it).exists() }
    }
}