package br.com.alura.alugames.models

interface recommendable {
    val average: Double
    fun toRecommend(note: Int)
}