package br.com.alura.alugames.models

import br.com.alura.alugames.models.users.Gamer
import org.example.br.com.alura.alugames.models.Games
import java.time.LocalDate


data class Rent(
    val gamer: Gamer,
    val game: Games,
    val period: Period){
    val rentalValue = gamer.plan.getValue(this)
    override fun toString(): String {
        return "${game.title} foi alugado por ${gamer.name} por R$$rentalValue"
    }
}
