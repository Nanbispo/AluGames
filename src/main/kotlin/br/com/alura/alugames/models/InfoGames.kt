package org.example.br.com.alura.alugames.models

data class InfoGames(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}