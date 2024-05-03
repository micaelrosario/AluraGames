package br.com.alura.aluragames.modelo

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
    val jogosBuscados = mutableListOf<Jogo>()


    constructor(nome:String, email:String, dataNascimento: String, usuario: String): this(nome, email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
            criarIdInterno()
    }

    init{
        if(nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome está em branco")
        }
        this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer:\n" +
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

}