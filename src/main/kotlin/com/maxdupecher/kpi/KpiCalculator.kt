package com.maxdupecher.kpi

import com.maxdupecher.Device

class KpiCalculator(private val strategy: KpiStrategy, private val devices: List<Device>) {

    fun computeKpi() {
        strategy.computeKpi(devices)
    }
}