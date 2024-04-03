import br.com.alura.alugames.models.users.Gamer

fun main (){
    val gamer1 = Gamer("Maria", "maria@gmail.com")
    println(gamer1)

    val gamer2 = Gamer(
        "Renan",
        "renan@gmail.com",
        "06/01/2005",
        "renanzin"
    )
    println(gamer2)


    gamer1.let {
        it.birthData = "18/09/1976"
        it.user = "mariazinha"
    }.also {
        println(gamer1)
    }

    gamer1.user = "gigi"
    println(gamer1)
}