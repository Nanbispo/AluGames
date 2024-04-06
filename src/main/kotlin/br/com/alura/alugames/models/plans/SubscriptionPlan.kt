package br.com.alura.alugames.models.plans

import br.com.alura.alugames.models.plans.Plan
import br.com.alura.alugames.models.plans.Rent

class subscriptionPlan(
    type: String,
    val monthlyPayment: Double,
    val gamesIncluded: Int,
    val percentageDiscountReputation: Double) : Plan(type) {

    override fun getValue(rent: Rent): Double {
        val totalGamesInMonth = rent.gamer.gamesOfTheMonth(rent.period.initialDate.monthValue).size + 1

        return if (totalGamesInMonth <= gamesIncluded) {
            0.0
        } else {
            var originalValue = super.getValue(rent)
            if (rent.gamer.average > 8){
                originalValue *= percentageDiscountReputation
            }
            originalValue
        }
    }
}