package com.maxdupecher.kpi

import com.jakewharton.fliptables.FlipTable
import com.maxdupecher.Device

class RatePerClickCalculator: KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        val headers = arrayOf("Taux par clic", "Nombre de clics", "Nombre d'impressions")
        val count = devices.filter { it.impressions > 0 }.count()
        val data = Array(size = count) { Array(size = 3) { "" } } // String[count][3]
        devices.filter { it.impressions > 0 }.forEachIndexed { index, device ->
            val row = data[index]
            row[0] = "${(device.clics / device.impressions) * 100}"
            row[1] = "${device.clics}"
            row[2] = "${device.impressions}"
        }
        println(FlipTable.of(headers, data))
        println()
    }
}