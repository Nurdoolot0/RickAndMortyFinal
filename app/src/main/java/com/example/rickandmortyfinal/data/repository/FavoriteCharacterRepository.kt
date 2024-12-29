package com.example.rickandmortyfinal.data.repository

import com.example.rickandmortyfinal.data.local.dao.FavoriteCharacterDao
import com.example.rickandmortyfinal.data.local.entities.FavoriteCharacter
import kotlinx.coroutines.flow.Flow

class FavoriteCharacterRepository(private val favoriteCharacterDao: FavoriteCharacterDao) {

    fun getFavoriteCharacters(): Flow<List<FavoriteCharacter>> {
        return favoriteCharacterDao.getFavoriteCharacters()
    }

    suspend fun addFavorite(character: FavoriteCharacter) {
        favoriteCharacterDao.addToFavorites(character)
    }

    suspend fun removeFavorite(characterId: Int) {
        favoriteCharacterDao.removeFromFavorites(characterId)
    }
}