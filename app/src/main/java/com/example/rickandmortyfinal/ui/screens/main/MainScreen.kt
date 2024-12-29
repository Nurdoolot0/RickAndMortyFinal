package com.example.rickandmortyfinal.ui.screens.main

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyfinal.ui.animation.ScreenTransitions
import com.example.rickandmortyfinal.ui.appBar.AppBottomBar
import com.example.rickandmortyfinal.ui.appBar.AppTopBar
import com.example.rickandmortyfinal.ui.screens.characters.CharactersScreen
import com.example.rickandmortyfinal.ui.screens.characters.detail.CharacterDetailScreen
import com.example.rickandmortyfinal.ui.screens.episodes.EpisodesScreen
import com.example.rickandmortyfinal.ui.screens.favorites.FavoriteCharacterViewModel
import com.example.rickandmortyfinal.ui.screens.favorites.FavoriteCharactersScreen
import com.example.rickandmortyfinal.ui.screens.locations.LocationsScreen
import com.example.rickandmortyfinal.ui.screens.locations.detail.LocationDetailScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { AppTopBar(navController) },
        bottomBar = { AppBottomBar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "characters"
            ) {
                composableWithTransitions("characters") { CharactersScreen(navController) }
                composableWithTransitions("locations") { LocationsScreen(navController) }
                composableWithTransitions("episodes") { EpisodesScreen(navController) }
                composableWithTransitions("character_detail/{characterId}") { backStackEntry ->
                    val characterId =
                        backStackEntry.arguments?.getString("characterId")?.toIntOrNull()
                    if (characterId != null) {
                        CharacterDetailScreen(characterId)
                    }
                }
                composableWithTransitions("location_detail/{locationId}") { backStackEntry ->
                    val locationId =
                        backStackEntry.arguments?.getString("locationId")?.toIntOrNull()
                    if (locationId != null) {
                        LocationDetailScreen(locationId)
                    }
                }
                composableWithTransitions("favorites") {
                    val viewModel: FavoriteCharacterViewModel = koinViewModel()
                    FavoriteCharactersScreen(viewModel = viewModel)
                }
            }
        }
    }
}

fun NavGraphBuilder.composableWithTransitions(
    route: String,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = route,
        enterTransition = { ScreenTransitions.enterFromRight },
        exitTransition = { ScreenTransitions.exitToLeft },
        popEnterTransition = { ScreenTransitions.popEnterFromLeft },
        popExitTransition = { ScreenTransitions.popExitToRight },
        content = content
    )
}