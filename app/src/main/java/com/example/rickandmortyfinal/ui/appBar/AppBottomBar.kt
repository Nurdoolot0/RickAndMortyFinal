package com.example.rickandmortyfinal.ui.appBar

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppBottomBar(
    navController: NavController
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar {

        val isCharactersSelected = selectedIndex == 0
        val iconSizeCharacters by animateDpAsState(
            targetValue = if (isCharactersSelected) 30.dp else 24.dp,
            animationSpec = spring(dampingRatio = 0.5f, stiffness = 1000f), label = ""
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Characters",
                    modifier = Modifier.size(iconSizeCharacters)
                )
            },
            label = { Text("Characters") },
            selected = isCharactersSelected,
            onClick = {
                selectedIndex = 0
                navController.navigate("characters") {
                    popUpTo("characters") { inclusive = true }
                    launchSingleTop = true
                }
            }
        )

        val isLocationsSelected = selectedIndex == 1
        val iconSizeLocations by animateDpAsState(
            targetValue = if (isLocationsSelected) 30.dp else 24.dp,
            animationSpec = spring(dampingRatio = 0.5f, stiffness = 1000f), label = ""
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = "Locations",
                    modifier = Modifier.size(iconSizeLocations)
                )
            },
            label = { Text("Locations") },
            selected = isLocationsSelected,
            onClick = {
                selectedIndex = 1
                navController.navigate("locations") {
                    popUpTo("locations") { inclusive = true }
                    launchSingleTop = true
                }
            }
        )

        val isEpisodesSelected = selectedIndex == 2
        val iconSizeEpisodes by animateDpAsState(
            targetValue = if (isEpisodesSelected) 30.dp else 24.dp,
            animationSpec = spring(dampingRatio = 0.5f, stiffness = 1000f), label = ""
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.AutoMirrored.Filled.List,
                    contentDescription = "Episodes",
                    modifier = Modifier.size(iconSizeEpisodes)
                )
            },
            label = { Text("Episodes") },
            selected = isEpisodesSelected,
            onClick = {
                selectedIndex = 2
                navController.navigate("episodes") {
                    popUpTo("episodes") { inclusive = true }
                    launchSingleTop = true
                }
            }
        )

        val isFavoritesSelected = selectedIndex == 3
        val iconSizeFavorites by animateDpAsState(
            targetValue = if (isFavoritesSelected) 30.dp else 24.dp,
            animationSpec = spring(dampingRatio = 0.5f, stiffness = 1000f), label = ""
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "Favorites",
                    modifier = Modifier.size(iconSizeFavorites)
                )
            },
            label = { Text("Favorites") },
            selected = isFavoritesSelected,
            onClick = {
                selectedIndex = 3
                navController.navigate("favorites") {
                    launchSingleTop = true
                }
            }
        )
    }
}