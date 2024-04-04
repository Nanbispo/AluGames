package br.com.alura.alugames.repositories

interface Recommendable {
    val average: Double
    fun toRecommend(note: Int)
}