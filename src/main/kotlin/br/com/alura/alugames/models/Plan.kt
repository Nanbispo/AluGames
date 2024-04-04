package br.com.alura.alugames.models

open class Plan(val type: String) {
    fun getValue (rent: Rent):Double{
        return rent.game.preco * rent.period.inDays
    }
}