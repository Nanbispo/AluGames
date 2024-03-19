package br.com.alura.alugames.services

import com.google.gson.Gson
import org.example.br.com.alura.alugames.models.InfoGames
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiConsumption {
    fun searchGame(id: String): InfoGames{
        val addres = "https://www.cheapshark.com/api/1.0/games?id=$id"


        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(addres))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()
        val gson = Gson()
        val myInfoGaming = gson.fromJson(json, InfoGames::class.java)
        return myInfoGaming
    }
}