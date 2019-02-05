iim.rattrapage.kotlin Maxime Dupêcher

Design Pattern utilisés:

- Pattern Strategy:
    KpiCalculator, KpiStrategy + classes avec "Calculator" = implémentation de ce pattern
- Pattern Singleton:
    KpiFactory: ligne object KpiFactory
- Pattern Factory Method:
    KpiFactory: method getKpi(kpiType: KpiType)

!Important! Pour avoir le résultat affiché comme prévu, le plug-in Fliptables est nécessaire
 (il est implémenté directement dans le build.gradle)
 
KPI Details :
- Le chiffre d’affaires par mois par année = TurnoverPerMonthPerYearCalculator
- Le chiffre d’affaires par appareil = TurnoverPerDeviceCalculator
- Le panier moyen : Chiffre d’affaires / Commandes = AverageBasketCalculator
- Le coût par clic : Coût / Clics = CostPerClickCalculator
- Le taux de clic : (Clics /impression) * 100 = RatePerClickCalculator
- Le ROI : CA Total / Coût  = ROICalculator
- Le ROI segmenté par appareil et par mois (uniquement sur 2017) = ROIPerDevicePerMonthCalculator

Le menu et les résultats s'affichent dans le Terminal de commande.

Bonne Datanalyse ;) 

Maxime Dupêcher - IIM A3 DW