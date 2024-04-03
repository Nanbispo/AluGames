package org.example.br.com.alura.alugames.main

import br.com.alura.alugames.models.users.Gamer
import br.com.alura.alugames.services.ApiConsumption
import org.example.br.com.alura.alugames.models.Games
import turnsIntoAge
import java.util.*

fun main() {
    val reading = Scanner(System.`in`)
    val gamer = Gamer.createGamer(reading)
    println("Cadastro concluído com sucesso.")
    println("Infos:\n $gamer")
    println("O gamer tem ${gamer.birthData?.turnsIntoAge()} anos")

    do {
        println("Id para buscar jogo:")
        val search = reading.nextLine()

        val searchApi = ApiConsumption()
        val infoGame = searchApi.searchGame(search)


        var myGame: Games? = null
        var result = runCatching {
            myGame = Games(
                infoGame.info.title,
                infoGame.info.thumb
            )

        }
        result.onFailure {
            println("Jogo inexistente. Tente outro Id.")
        }

        result.onSuccess {
            println("Deseja incluir uma descrição personalizada? S/N")
            val option = reading.nextLine()
            if (option.equals("s", true)) {
                println("Descrição personalizada: ")
                val personalizedDescription = reading.nextLine()
                myGame?.description = personalizedDescription
            } else {
                myGame?.description = myGame?.title
            }
            gamer.gamesSearched.add(myGame)
        }
        println("Deseja buscar novo jogo? S/N")
        val response = reading.nextLine()
    }while (response.equals("s",true))

    println("Jogos buscados: \n ${gamer.gamesSearched}")
    println("Jogos em ordem alfabetica: ")

    gamer.gamesSearched.sortBy {
        it?.title
    }

    gamer.gamesSearched.forEach{
        println("Título: " + it?.title)
    }

    val filterGames = gamer.gamesSearched.filter {
        it?.title?.contains("batman", true)?: false
    }
    println("Jogos filtrados")
    println(filterGames)


    println("Deseja excluir algum jogo da lista principal? S/N")
    val option = reading.nextLine()
    if (option.equals("s", true)){
        println(gamer.gamesSearched)
        println("Qual a posição do jogo?")
        val position = reading.nextInt()
        gamer.gamesSearched.removeAt(position)

    }
    println("Lista atualizada:\n ${gamer.gamesSearched}")




    println("Busca finalizada com sucesso!")
}