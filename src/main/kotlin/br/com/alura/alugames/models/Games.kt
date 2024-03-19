package org.example.br.com.alura.alugames.models
data class Games(
    var title: String,
    var thumb: String
) {
    var description:String? = null
    override fun toString(): String {
        return "Meu Jogo \n Título: $title \n imagem: $thumb \n descrição: $description"
    }
}