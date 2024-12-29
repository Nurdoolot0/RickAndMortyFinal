package com.example.rickandmortyfinal.data.repository

import com.example.rickandmortyfinal.data.models.Episode

interface EpisodesRepository {
    suspend fun getNextPageEpisodes(): List<Episode>
}