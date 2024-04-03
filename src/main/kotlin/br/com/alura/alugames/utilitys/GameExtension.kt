package br.com.alura.alugames.utilitys

import br.com.alura.alugames.models.InfoGameJson
import org.example.br.com.alura.alugames.models.Games

fun InfoGameJson.createGame(): Games {
    return Games(
        this.titulo,
        this.capa,
        this.preco,
        this.descricao
    )
}