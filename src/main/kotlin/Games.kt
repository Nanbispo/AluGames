package org.example
data class Games(
    var title: String,
    var image: String
) {
    val description = ""
    override fun toString(): String {
        return "Meu Jogo \n Título: $title \n imagem: $image \n descrição: $description"
    }
}