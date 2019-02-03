package com.maxdupecher.kpi

import com.maxdupecher.Device

interface KpiStrategy {
    fun computeKpi(devices: List<Device>)
}