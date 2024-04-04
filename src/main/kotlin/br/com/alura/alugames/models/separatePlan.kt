package br.com.alura.alugames.models

data class separatePlan(val type: String){
    fun getValue (rent: Rent):Double{
        return rent.game.preco * rent.period.inDays
    }
}