package br.com.alura.alugames.services

import br.com.alura.alugames.models.Gamer
import br.com.alura.alugames.models.InfoGamerJson
import br.com.alura.alugames.utilitys.createGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.br.com.alura.alugames.models.InfoGames
import java.lang.ProcessHandle.Info
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
    fun searchGamerJson(): List<Gamer>{
        val addres = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(addres))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()

        val gson = Gson()
        val convertTypeGamer = object: TypeToken<List<InfoGamerJson>>(){}.type
        val gamersList: List<InfoGamerJson> = gson.fromJson(json, convertTypeGamer)
        val convertGamerList = gamersList.map { infoGamerJson -> infoGamerJson.createGamer() }
        return convertGamerList
    }
}