package br.com.alura.alugames.models.plans

sealed class Plan(val type: String) {
    open fun getValue (rent: Rent):Double{
        return rent.game.preco * rent.period.inDays
    }
}