package br.com.alura.aluragames.principal

import br.com.alura.aluragames.modelo.Gamer
import br.com.alura.aluragames.modelo.Jogo
import br.com.alura.aluragames.servicos.ConsumoApi
import br.com.alura.aluragames.utilitario.transformarEmIdade
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
        println("Cadastro concluído com sucesso. Dados do gamer:")
            println(gamer)
            println("Idade do gamer: "+gamer.dataNascimento?.transformarEmIdade())

    do{
        println("Digite um código de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb)
        }

        resultado.onFailure {
            println("br.com.alura.aluragames.modelo.Jogo inexistente. Tente outro id.")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if(opcao.equals("s",true)){
                println("Insira a descrição personalizada para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            }else{
                meuJogo?.descricao = meuJogo?.titulo
            }
            gamer.jogosBuscados.add(meuJogo)
            println(meuJogo)
        }
        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()
    }while(resposta.equals("s",true))

    println("\nJOGOS BUSCADOS:")
    println(gamer.jogosBuscados)

    println("\n JOGOS ORDENADOS POR TÍTULOS:")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach{
        println("Título: "+it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman",true)?:false
    }
    println("\n Jogos filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if(opcao.equals("s",true)){
        println(gamer.jogosBuscados)
        println("Informe a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\n Lista atualizada:")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso.✅")


}