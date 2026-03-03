package com.seuapp.performance.monitor

import android.content.Context
import android.os.BatteryManager

class TemperatureMonitor(private val context: Context) {

    fun getBatteryTemperature(): Float {
        val batteryManager =
            context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

        val temp =
            batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_TEMPERATURE)

        return temp / 10f
    }
}