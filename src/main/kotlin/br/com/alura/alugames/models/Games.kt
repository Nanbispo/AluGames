package org.example.br.com.alura.alugames.models

import jdk.jfr.Description

data class Games(
    var title: String,
    var thumb: String
) {
    var description: String? = null
    var preco = 0.0

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
                "preço: $preco"
    }
}