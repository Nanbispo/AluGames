package br.com.alura.alugames.services

import br.com.alura.alugames.models.users.Gamer
import br.com.alura.alugames.models.InfoGameJson
import br.com.alura.alugames.models.users.InfoGamerJson
import br.com.alura.alugames.utilitys.createGame
import br.com.alura.alugames.utilitys.createGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.br.com.alura.alugames.models.Games
import org.example.br.com.alura.alugames.models.InfoGames
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiConsumption {

    private fun consumeData(addres: String): String{
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(addres))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }
    fun searchGame(id: String): InfoGames{
        val addres = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consumeData(addres)
        val gson = Gson()
        val myInfoGaming = gson.fromJson(json, InfoGames::class.java)
        return myInfoGaming
    }
    fun searchGamer(): List<Gamer>{
        val addres = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consumeData(addres)
        val gson = Gson()
        val convertTypeGamer = object: TypeToken<List<InfoGamerJson>>(){}.type
        val gamersList: List<InfoGamerJson> = gson.fromJson(json, convertTypeGamer)
        val convertGamerList = gamersList.map { infoGamerJson -> infoGamerJson.createGamer() }
        return convertGamerList
    }
    fun searchGameJson(): List<Games>{
        val addres = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consumeData(addres)
        val gson = Gson()
        val convertTypeGame = object: TypeToken<List<InfoGameJson>>(){}.type
        val gamesList: List<InfoGameJson> = gson.fromJson(json, convertTypeGame)
        val convertGamerList = gamesList.map { InfoGameJson -> InfoGameJson.createGame() }
        return convertGamerList
    }
}