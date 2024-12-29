package com.example.rickandmortyfinal.di

import com.example.rickandmortyfinal.data.api.ApiService
import com.example.rickandmortyfinal.data.repository.Repository
import com.example.rickandmortyfinal.data.local.database.AppDatabase
import com.example.rickandmortyfinal.data.repository.EpisodesRepository
import com.example.rickandmortyfinal.data.repository.EpisodesRepositoryImpl
import com.example.rickandmortyfinal.data.repository.FavoriteCharacterRepository
import com.example.rickandmortyfinal.ui.screens.characters.detail.CharacterDetailViewModel
import com.example.rickandmortyfinal.ui.screens.characters.CharactersViewModel
import com.example.rickandmortyfinal.ui.screens.episodes.EpisodesViewModel
import com.example.rickandmortyfinal.ui.screens.favorites.FavoriteCharacterViewModel
import com.example.rickandmortyfinal.ui.screens.locations.detail.LocationDetailViewModel
import com.example.rickandmortyfinal.ui.screens.locations.LocationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.android.ext.koin.androidContext

object AppModule {
    val module = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

        single { AppDatabase.getDatabase(androidContext()) }
        single { get<AppDatabase>().favoriteCharacterDao() }
        single { FavoriteCharacterRepository(get()) }
        single<EpisodesRepository> { EpisodesRepositoryImpl(get()) }
        single { Repository(get()) }

        viewModel { FavoriteCharacterViewModel(get()) }
        viewModel { CharactersViewModel(get(), get()) }
        viewModel { LocationsViewModel(get()) }
        viewModel { CharacterDetailViewModel(get()) }
        viewModel { LocationDetailViewModel(get()) }
        viewModel { EpisodesViewModel(get()) }
    }
}