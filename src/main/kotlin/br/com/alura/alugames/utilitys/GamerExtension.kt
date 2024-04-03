package br.com.alura.alugames.utilitys

import br.com.alura.alugames.models.Gamer
import br.com.alura.alugames.models.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}