package br.com.alura.alugames.models

import br.com.alura.alugames.models.users.Gamer
import org.example.br.com.alura.alugames.models.Games
import java.time.LocalDate
import java.time.Period

data class Rent(
    val gamer: Gamer,
    val game: Games,
    val initialDate: LocalDate,
    val finalDate: LocalDate){
    val rentalValue = game.preco * Period.between(initialDate, finalDate).days
    override fun toString(): String {
        return "${game.title} foi alugado por ${gamer.name} por R$${game.preco}"
    }
}
