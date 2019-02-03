package com.maxdupecher.kpi

import com.jakewharton.fliptables.FlipTable
import com.maxdupecher.Device

class CostPerClickCalculator: KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        val headers = arrayOf("Cout par clic", "Nombre de clics")
        val count = devices.filter { it.clics > 0 }.count()
        val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]
        devices.filter { it.clics > 0 }.forEachIndexed { index, device ->
            val row = data[index]
            row[0] = "${device.cost / device.clics}"
            row[1] = "${device.clics}"
        }
        println(FlipTable.of(headers, data))
        println()
    }
}