package com.maxdupecher.kpi

import com.maxdupecher.Device

class ROICalculator: KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        println("ROI=${devices.sumBy { it.ca } / devices.sumBy { it.cost }}")
        println()
        println()
    }
}