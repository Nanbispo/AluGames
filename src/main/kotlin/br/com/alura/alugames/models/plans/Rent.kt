package br.com.alura.alugames.models.plans

import br.com.alura.alugames.models.plans.Period
import br.com.alura.alugames.models.users.Gamer
import org.example.br.com.alura.alugames.models.Games


data class Rent(
    val gamer: Gamer,
    val game: Games,
    val period: Period
){
    val rentalValue = gamer.plan.getValue(this)
    override fun toString(): String {
        return "${game.title} foi alugado por ${gamer.name} por R$$rentalValue"
    }
}
