package com.maxdupecher.kpi

import com.jakewharton.fliptables.FlipTable
import com.maxdupecher.Device

class ROIPerDevicePerMonthCalculator : KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        val headers = arrayOf("Appareil", "ROI")
        val count = devices.groupBy { it.device }.filterValues { it.sumBy { it.cost } > 0 }.count()
        val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]

        var index = 0
        devices.groupBy { it.device }.forEach { device, items ->
            if (items.sumBy { it.cost } > 0) {
                val row = data[index]
                row[0] = "$device"
                row[1] = "${items.sumBy { it.ca } / items.sumBy { it.cost }}"
                index++
            }
        }

        println(FlipTable.of(headers, data))
        println()

        val headers2 = arrayOf("Mois", "ROI")
        val count2 = devices.groupBy { it.month }.filterValues { it.sumBy { it.cost } > 0 }.count()
        val data2 = Array(size = count2) { Array(size = 2) { "" } } // String[count2][2]

        index = 0
        devices.groupBy { it.month }.forEach { month, items ->
            if (items.sumBy { it.cost } > 0) {
                val row = data2[index]
                row[0] = "$month"
                row[1] = "${items.sumBy { it.ca } / items.sumBy { it.cost }}"
                index++
            }
        }

        println(FlipTable.of(headers2, data2))
        println()
    }
}