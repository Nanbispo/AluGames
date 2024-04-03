package br.com.alura.alugames.main

import br.com.alura.alugames.services.ApiConsumption

fun main (){
    val consume = ApiConsumption()
    val gamersList = consume.searchGamer()
    println(gamersList)

    val gamesList = consume.searchGame("151")
    println(gamesList)
}