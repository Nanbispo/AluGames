package br.com.alura.alugames.models.users

import br.com.alura.alugames.models.plans.Period
import br.com.alura.alugames.models.plans.Plan
import br.com.alura.alugames.models.plans.Rent
import br.com.alura.alugames.models.plans.separatePlan
import br.com.alura.alugames.repositories.Recommendable
import org.example.br.com.alura.alugames.models.Games
import java.util.*
import kotlin.random.Random

data class Gamer(
    var name: String,
    var email: String
): Recommendable {
    var birthData: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (internalId.isNullOrBlank()) {
                createInternalId()
            }
        }
    var internalId: String? = null
        private set

    var plan : Plan = separatePlan("BRONZE")
    val gamesSearched = mutableListOf<Games?>()
    val rentendGames = mutableListOf<Rent>()
    private val listNotes = mutableListOf<Int>()
    var recommendedGames = mutableListOf<Games>()

    override val average: Double
        get() = listNotes.average();

    override fun toRecommend(note: Int) {
        listNotes.add(note)
    }
    fun toRecommendedGame (game: Games, note: Int){
        game.toRecommend(note)
        recommendedGames.add(game)
    }

    constructor(name: String, email: String, birthData: String, user: String) :
            this(name, email) {
        this.birthData = birthData
        this.user = user
        createInternalId()
    }

    init {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException("Nome não pode estar em branco.")
        }
        this.email = validateEmail()
    }




    fun rentGame(game: Games, period: Period): Rent {

        val rent = Rent(this, game, period)
        rentendGames.add(rent)
        return rent
    }

    override fun toString(): String {
        return "Gamer (name= $name, " +
                "email= $email, " +
                "birthData= $birthData, " +
                "user= $user, " +
                "internalId= $internalId, " +
                "Reputação: $average)"
    }

    fun createInternalId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)
        internalId = "$user#$number"
    }

    fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido.")
        }
    }

    fun gamesOfTheMonth(month: Int): List<Games>{
        return rentendGames
            .filter { rent -> rent.period.initialDate.monthValue == month }
            .map { rent -> rent.game }
    }

    companion object {
        fun createGamer(reading: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val name = reading.nextLine()
            println("Digite seu e-mail:")
            val email = reading.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = reading.nextLine()

            if (option.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val birthData = reading.nextLine()
                println("Digite seu nome de usuário:")
                val user = reading.nextLine()

                return Gamer(name, email, birthData, user)
            } else {
                return Gamer(name, email)
            }
        }
    }
}