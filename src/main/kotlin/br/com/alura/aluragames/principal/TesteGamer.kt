import br.com.alura.aluragames.modelo.Gamer

fun main(){
    val gamer1 = Gamer("Micael", "micael@gmail.com")
    //println(gamer1)

    val gamer2 = Gamer("Micael", "micael@gmail.com", "27/27/2004", "devmicael")
    //println(gamer2)

    gamer1.let() {
        it.dataNascimento = "15/05/2004"
        it.usuario = "micaelrosario"

    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "Michael"
    println(gamer1)
}