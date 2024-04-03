package br.com.alura.alugames.main

import br.com.alura.alugames.services.ApiConsumption

fun main (){
    val consume = ApiConsumption()
    val gamersList = consume.searchGamerJson()
    println(gamersList)
}