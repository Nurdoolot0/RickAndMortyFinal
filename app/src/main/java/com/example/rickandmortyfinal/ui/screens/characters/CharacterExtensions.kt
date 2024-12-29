package com.example.rickandmortyfinal.ui.screens.characters

import com.example.rickandmortyfinal.data.local.entities.FavoriteCharacter
import com.example.rickandmortyfinal.data.models.CharacterResponse


fun CharacterResponse.Character.toFavoriteCharacter(): FavoriteCharacter {
    return FavoriteCharacter(
        id = this.id,
        name = this.name,
        species = this.species,
        image = this.image,
        status = this.status,
        isFavorite = 1
    )
}

fun FavoriteCharacter.toCharacterResponse(): CharacterResponse.Character {
    return CharacterResponse.Character(
        id = this.id,
        name = this.name,
        species = this.species,
        status = this.status,
        image = this.image
    )
}