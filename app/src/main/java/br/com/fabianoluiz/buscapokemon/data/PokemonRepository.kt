package br.com.fabianoluiz.buscapokemon.data

import br.com.fabianoluiz.buscapokemon.data.api.PokemonAPI
import br.com.fabianoluiz.buscapokemon.domain.Pokemon

class PokemonRepository(private val api: PokemonAPI) {
    suspend fun getPokemonData(id: Int): Pokemon{
        val response = api.getPokemon(id)
        val details = "Name: ${response.name}, Weight: ${response.weight}, Height: ${response.height}"
        val officialArtWork = response.sprites.otherSprites.officialArtwork.frontDefault
        val sprites = listOfNotNull(
            response.sprites.front_default,
            response.sprites.back_default,
            response.sprites.front_shiny,
            response.sprites.back_shiny
        )
        return Pokemon(
            response.name,
            response.height,
            response.weight,
            sprites,
            officialArtWork
        )
    }
}