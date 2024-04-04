package br.com.alura.alugames.models

import br.com.alura.alugames.models.users.Gamer
import org.example.br.com.alura.alugames.models.Games

data class Rent(
    val gamer: Gamer,
    val game: Games
){
    override fun toString(): String {
        return "${game.title} foi alugado por ${gamer.name}"
    }
}
