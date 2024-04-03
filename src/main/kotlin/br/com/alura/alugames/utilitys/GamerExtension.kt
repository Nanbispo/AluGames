package br.com.alura.alugames.utilitys

import br.com.alura.alugames.models.users.Gamer
import br.com.alura.alugames.models.users.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}