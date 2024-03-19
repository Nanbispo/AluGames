package br.com.alura.alugames.models

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
}