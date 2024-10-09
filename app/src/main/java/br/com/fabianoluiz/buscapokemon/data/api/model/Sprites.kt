package br.com.fabianoluiz.buscapokemon.data.api.model

import com.google.gson.annotations.SerializedName

data class Sprites(
    val front_default: String?,
    val back_default: String?,
    val front_shiny: String?,
    val back_shiny: String?,
    @SerializedName("other") val otherSprites: OtherSprites

)

data class OtherSprites(
    @SerializedName("official-artwork") val officialArtwork: OfficialArtWork
)

data class OfficialArtWork(
    @SerializedName("front_default") val frontDefault: String?
)