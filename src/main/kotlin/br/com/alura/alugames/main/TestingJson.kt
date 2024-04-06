package br.com.alura.alugames.main

import br.com.alura.alugames.models.plans.Period
import br.com.alura.alugames.models.plans.subscriptionPlan
import br.com.alura.alugames.services.ApiConsumption
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consume = ApiConsumption()
    val gamersList = consume.searchGamer()
    val gamesJson = consume.searchGameJson()

    //println(gamersList)
    //println(gamesList)
    //println(gamesJson)


    val jogo = gamesJson.get(10)
    val jogo2 = gamesJson.get(3)
    val jogo3 = gamesJson.get(13)


    val periodo1 = Period(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Period(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Period(LocalDate.now(), LocalDate.now().plusDays(10))

    val jogoResidentVillage = gamesJson.get(10)
    val jogoSpider = gamesJson.get(13)
    val jogoTheLastOfUs = gamesJson.get(2)
    val jogoDandara = gamesJson.get(5)
    val jogoAssassins = gamesJson.get(4)
    val jogoCyber = gamesJson.get(6)
    val jogoGod = gamesJson.get(7)
    val jogoSkyrim = gamesJson.get(18)



    //println(jogador.rentendGames)

    val gamerCamila = gamersList.get(5)
    gamerCamila.plan = subscriptionPlan("PRATA", 9.90, 3, 0.15)
    gamerCamila.rentGame(jogo, periodo1)
    gamerCamila.rentGame(jogo2, periodo2)
    gamerCamila.rentGame(jogo3, periodo3)
    gamerCamila.rentGame(jogo3, periodo3)





    gamerCamila.toRecommendedGame(jogoResidentVillage, 7)
    gamerCamila.toRecommendedGame(jogoTheLastOfUs, 10)
    gamerCamila.toRecommendedGame(jogoAssassins, 8)
    gamerCamila.toRecommendedGame(jogoCyber, 7)
    gamerCamila.toRecommendedGame(jogoGod, 10)
    gamerCamila.toRecommendedGame(jogoDandara, 8)
    gamerCamila.toRecommendedGame(jogoSkyrim, 8)
    gamerCamila.toRecommendedGame(jogoSpider, 6)

    val gamerCaroline = gamersList.get(3)
    gamerCaroline.toRecommend(10)
    gamerCaroline.toRecommend(8)
    gamerCamila.toRecommend(7)
    println(gamerCaroline)

    println(gamerCamila.recommendedGames)



    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialization = gson.toJson(gamerCamila.recommendedGames)
    println(serialization)

    val file = File("JogosRecomendados.json")
    file.writeText(serialization)
}
