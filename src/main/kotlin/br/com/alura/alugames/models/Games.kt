package org.example.br.com.alura.alugames.models

import br.com.alura.alugames.repositories.Recommendable
import com.google.gson.annotations.Expose
import jdk.jfr.Description

data class Games(
    @Expose var title: String,
    @Expose var thumb: String
) : Recommendable {
    var description: String? = null
    var preco = 0.0
    private val listNotes = mutableListOf<Int>()

    override val average: Double
        get() = listNotes.average()

    override fun toRecommend(note: Int) {
        if (note < 1 || note > 10) {
            println("Nota invalida")
        }
        listNotes.add(note)
    }

    constructor(
        title: String,
        thumb: String,
        preco: Double,
        description: String
    ) : this(title, thumb) {
        this.preco = preco
        this.description = description
    }

    override fun toString(): String {
        return "\nMeu Jogo: \n" +
                "Título: $title \n" +
                "imagem: $thumb \n" +
                "descrição: $description \n" +
                "preço: $preco \n" +
                "nota $average"
    }
}