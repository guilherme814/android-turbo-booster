package com.seuapp.performance.monitor

import android.app.ActivityManager
import android.content.Context

class RamMonitor(private val context: Context) {

    fun getRamInfo(): RamData {
        val activityManager =
            context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        val memoryInfo = ActivityManager.MemoryInfo()
        activityManager.getMemoryInfo(memoryInfo)

        val total = memoryInfo.totalMem
        val available = memoryInfo.availMem
        val used = total - available
        val percentUsed = (used * 100 / total)

        return RamData(total, available, used, percentUsed)
    }
}

data class RamData(
    val total: Long,
    val available: Long,
    val used: Long,
    val percentUsed: Long
)