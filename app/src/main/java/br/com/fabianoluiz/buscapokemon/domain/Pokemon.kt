package br.com.fabianoluiz.buscapokemon.domain

data class Pokemon(

    val nome: String,
    val height: Int,
    val weight: Int,
    val imagesUrl: List<String>,
    val principalImage: String?
)
