package br.com.alura.alugames.main

import br.com.alura.alugames.models.Period
import br.com.alura.alugames.models.subscriptionPlan
import br.com.alura.alugames.services.ApiConsumption
import java.time.LocalDate

fun main() {
    val consume = ApiConsumption()
    val gamersList = consume.searchGamer()
    val gamesJson = consume.searchGameJson()

    //println(gamersList)
    //println(gamesList)
    //println(gamesJson)

    val jogador = gamersList.get(3)
    val jogo = gamesJson.get(10)
    val jogo2 = gamesJson.get(3)
    val jogo3 = gamesJson.get(13)


    val periodo1 = Period(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Period(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Period(LocalDate.now(), LocalDate.now().plusDays(10))

    jogador.rentGame(jogo, periodo1)
    jogador.rentGame(jogo2, periodo2)
    jogador.rentGame(jogo3, periodo3)


    println(jogador.rentendGames)

    val jogadora = gamersList.get(5)
    jogadora.plan = subscriptionPlan("PRATA", 9.90, 3, 0.15)
    jogadora.rentGame(jogo, periodo1)
    jogadora.rentGame(jogo2, periodo2)
    jogadora.rentGame(jogo3, periodo3)
    jogadora.rentGame(jogo3, periodo3)



    jogadora.toRecommend(10)
    jogadora.toRecommend(8)
    jogadora.toRecommend(7)
    println(jogadora)
    println(jogadora.rentendGames)
    //jogadora.rentGame(jogo, periodo1)
    println(jogadora.rentendGames)


}
