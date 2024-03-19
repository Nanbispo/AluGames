package br.com.alura.alugames.models

import org.example.br.com.alura.alugames.models.Games
import java.util.*
import kotlin.random.Random

data class Gamer(
    var name: String,
    var email: String
) {
    var birthData: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (internalId.isNullOrBlank()){
                createInternalId()
            }
        }
    var internalId: String? = null
        private set

    val gamesSearched = mutableListOf<Games?>()

    constructor(name: String, email: String, birthData: String, user: String) :
            this(name, email) {
                this.birthData = birthData
                this.user = user
                createInternalId()
    }

    init {
        if (name.isNullOrBlank()){
            throw IllegalArgumentException("Nome não pode estar em branco.")
        }
        this.email = validateEmail()
    }
    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birthData=$birthData, user=$user, internalId=$internalId)"
    }

    fun createInternalId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)
        internalId = "$user#$number"
    }

    fun validateEmail():String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)){
            return email
        } else {
            throw IllegalArgumentException("Email inválido.")
        }
    }
    companion object{
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