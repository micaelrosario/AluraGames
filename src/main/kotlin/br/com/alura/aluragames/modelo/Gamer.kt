package br.com.alura.aluragames.modelo

import kotlin.random.Random

data class Gamer(val nome:String, val email:String){
    var dataNascimento:String? = null
    var usuario:String? = null
    var idInterno:String? = null

    constructor(nome:String, email:String, dataNascimento: String, usuario: String): this(nome, email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
            criarIdInterno()
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



}