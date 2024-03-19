package org.example.br.com.alura.alugames.main

import br.com.alura.alugames.services.ApiConsumption
import org.example.br.com.alura.alugames.models.Games
import java.util.*

fun main() {
    val reading = Scanner(System.`in`)
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
        println(myGame)
    }
}


    //Solução feita para tratar um erro que não abordado no curso por conta de uma atualização da API que foi utilizada.
    // Erro de Json que retornava vazio.

//    var meuInfoJogo: InfoGames = InfoGames(InfoApiShark("", ""))
//    val resultadoMeuInfoJogo = runCatching {
//        meuInfoJogo = gson.fromJson(json, InfoGames::class.java)
//    }
//
//    resultadoMeuInfoJogo.onFailure {
//        println("Retorno Inválido. Tente outro id.")
//    }
//
//    resultadoMeuInfoJogo.onSuccess {
//        var meuJogo: Games
//        val resultado = runCatching {
//            meuJogo = Games(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
//
//            println(meuJogo)
//        }
//
//        resultado.onFailure {
//            println("Jogo inexistente. Tente outro id.")
//        }
//
//        resultado.onSuccess {
//            println("Deseja inserir uma descrição personalizada? S/N")
//            val opcao = reading.nextLine()
//            if (opcao.equals("s", true)) {
//                println("Insira a descrição personalizada para o jogo:")
//                val descricao = reading.nextLine()
//                println("sua descrição: $descricao")
//            } else {
//                println("sem descrição")
//            }
//
//        }
//    }
//}