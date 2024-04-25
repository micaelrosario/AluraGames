package br.com.alura.aluragames.modelo

data class Gamer(val nome:String, val email:String){
    var dataNascimento:String? = null
    var usuario:String? = null
    var idInterno:String? = null

    constructor(nome:String, email:String, dataNascimento: String, usuario: String): this(nome, email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
    }

    override fun toString(): String {
        return ("===========")+" Gamer "+("=============")+"\n" +
                "Nome: $nome\n" +
                "Email: $email\n" +
                "Data de Nascimento: $dataNascimento\n" +
                "Usuário: $usuario\n" +
                "ID Interno: $idInterno"
    }



}
