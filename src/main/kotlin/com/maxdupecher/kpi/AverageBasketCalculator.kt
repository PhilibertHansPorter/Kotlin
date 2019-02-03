package com.maxdupecher.kpi

import com.jakewharton.fliptables.FlipTable
import com.maxdupecher.Device

class AverageBasketCalculator : KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        val headers = arrayOf("Panier Moyen", "Nombre de commandes")
        val count = devices.filter { it.commande > 0 }.count()
        val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]
        devices.filter { it.commande > 0 }.forEachIndexed { index, device ->
            val row = data[index]
            row[0] = "${device.ca / device.commande}"
            row[1] = "${device.commande}"
        }
        println(FlipTable.of(headers, data))
        println()
    }
}