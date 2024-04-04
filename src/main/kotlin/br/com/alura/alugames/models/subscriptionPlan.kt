package br.com.alura.alugames.models

class subscriptionPlan(
    type: String,
    val monthlyPayment: Double,
    val gamesIncluded: Int): Plan(type) {

}