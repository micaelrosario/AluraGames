package br.com.alura.aluragames.utilitario

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun String.transformarEmIdade(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    return try {
        val dataNascimento = LocalDate.parse(this, formatter)
        val hoje = LocalDate.now()
        val idade = Period.between(dataNascimento, hoje).years

        idade
    } catch (ex: DateTimeParseException) {
        // Tratamento específico para erro de parsing da data
        println("\nErro ao fazer parsing da data de nascimento: ${ex.message}")
        0
    } catch (ex: Exception) {
        // Tratamento genérico para outros erros
        println("\nOcorreu um erro durante o cálculo da idade: ${ex.message}")
        0
    }
}