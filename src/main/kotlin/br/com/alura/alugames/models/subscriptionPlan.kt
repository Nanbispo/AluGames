package br.com.alura.alugames.models

class subscriptionPlan(
    type: String,
    val monthlyPayment: Double,
    val gamesIncluded: Int
) : Plan(type) {

    override fun getValue(rent: Rent): Double {
        val totalGamesInMonth = rent.gamer.gamesOfTheMonth(rent.period.initialDate.monthValue).size + 1

        return if (totalGamesInMonth <= 3) {
            0.0
        } else {
            super.getValue(rent)
        }
    }
}