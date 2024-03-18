package org.example

data class InfoGames(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}