package com.maxdupecher


import com.maxdupecher.kpi.KpiCalculator
import com.maxdupecher.kpi.KpiFactory
import com.maxdupecher.kpi.KpiType
import java.util.*

fun main() {
    val dataFileReader = DataFileReader()

    val devices = dataFileReader.readFile()
        .filter { it.commande + it.impressions + it.clics + it.cost + it.pm + it.ca > 0 } // Supprime les lignes vides (cad les lignes avec que des 0)

    val kpiToCalculators = mapOf(
        KpiType.AVERAGE_BASKET to KpiCalculator(KpiFactory.getKpi(KpiType.AVERAGE_BASKET), devices),
        KpiType.COST_PER_CLICK to KpiCalculator(KpiFactory.getKpi(KpiType.COST_PER_CLICK), devices),
        KpiType.RATE_PER_CLICK to KpiCalculator(KpiFactory.getKpi(KpiType.RATE_PER_CLICK), devices),
        KpiType.ROI to KpiCalculator(KpiFactory.getKpi(KpiType.ROI), devices),
        KpiType.ROI_PER_DEVICE to KpiCalculator(KpiFactory.getKpi(KpiType.ROI_PER_DEVICE), devices),
        KpiType.TURNOVER_PER_DEVICE to KpiCalculator(KpiFactory.getKpi(KpiType.TURNOVER_PER_DEVICE), devices),
        KpiType.TURNOVER_PER_MONTH_PER_YEAR to KpiCalculator(
            KpiFactory.getKpi(KpiType.TURNOVER_PER_MONTH_PER_YEAR),
            devices
        )
    )

    displayMenu()

}
fun displayMenu() {
    println("Afficher les KPI:")
    println("1. Le chiffre d’affaires par mois par année")
    println("2. Le chiffre d’affaires par appareil")
    println("3. Le panier moyen : Chiffre d’affaires / Commandes")
    println()
}