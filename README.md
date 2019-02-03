iim.rattrapage.kotlin Maxime Dupêcher

Design Pattern utilisés:

- Pattern Strategy:
    KpiCalculator, KpiStrategy + classes avec "Calculator" = l'implémentation de ce pattern
- Pattern Singleton:
    KpiFactory: ligne object KpiFactory
- Pattern Factory Method:
    KpiFactory: method getKpi(kpiType: KpiType)

!Important! Pour avoir le résultat affiché comme prévu, le plug-in Fliptables est nécessaire
 (il est implémenté directement dans le build.gradle)
 