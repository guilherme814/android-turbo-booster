package com.seuapp.performance.monitor

import java.io.RandomAccessFile

class CpuMonitor {

    fun getCpuUsage(): Float {
        try {
            val reader = RandomAccessFile("/proc/stat", "r")
            val load = reader.readLine()
            val toks = load.split(" ")

            val idle1 = toks[4].toLong()
            val cpu1 = toks[1].toLong() + toks[2].toLong() + toks[3].toLong()

            Thread.sleep(360)

            reader.seek(0)
            val load2 = reader.readLine()
            reader.close()

            val toks2 = load2.split(" ")

            val idle2 = toks2[4].toLong()
            val cpu2 = toks2[1].toLong() + toks2[2].toLong() + toks2[3].toLong()

            return ((cpu2 - cpu1).toFloat() /
                    ((cpu2 + idle2) - (cpu1 + idle1)) * 100.0f)

        } catch (e: Exception) {
            return 0f
        }
    }
}