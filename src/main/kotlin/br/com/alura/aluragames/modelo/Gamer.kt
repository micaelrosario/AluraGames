package br.com.alura.aluragames.modelo

import java.util.*
import kotlin.random.Random

data class Gamer(val nome: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    var idInterno: String? = null
        private set
    val jogosBuscados = mutableListOf<Jogo?>()


    constructor(nome:String, email:String, dataNascimento: String, usuario: String): this(nome, email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
            criarIdInterno()
    }

    /*init{
        if(nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome está em branco")
        }
        this.email = validarEmail()
    }*/

    override fun toString(): String {
        return "\nGamer:\n" +
                "Nome: $nome\n" +
                "Email: $email\n" +
                "Data de Nascimento: $dataNascimento\n" +
                "Usuário: $usuario\n" +
                "ID Interno: $idInterno"
    }

    fun criarIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        return if (regex.matches(email)) {
            email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    companion object{
        fun criarGamer(leitura: Scanner): Gamer{
            println("Boas vindas ao AluraGames! Vamos fazer seu cadastro. \nDigite seu nome: ")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()
            if(opcao.equals("s", true)){
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()
                return Gamer(nome, email, nascimento, usuario)
            }else{
                return Gamer(nome, email)
            }
        }
    }

}