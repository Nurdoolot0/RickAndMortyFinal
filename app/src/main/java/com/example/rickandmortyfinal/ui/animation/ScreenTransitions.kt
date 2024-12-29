package com.example.rickandmortyfinal.ui.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween

object ScreenTransitions {

    val enterFromRight: EnterTransition
        get() = slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = tween(durationMillis = 300)
        ) + fadeIn(animationSpec = tween(300))

    val exitToLeft: ExitTransition
        get() = slideOutHorizontally(
            targetOffsetX = { -it },
            animationSpec = tween(durationMillis = 300)
        ) + fadeOut(animationSpec = tween(300))

    val popEnterFromLeft: EnterTransition
        get() = slideInHorizontally(
            initialOffsetX = { -it },
            animationSpec = tween(durationMillis = 300)
        ) + fadeIn(animationSpec = tween(300))

    val popExitToRight: ExitTransition
        get() = slideOutHorizontally(
            targetOffsetX = { it },
            animationSpec = tween(durationMillis = 300)
        ) + fadeOut(animationSpec = tween(300))
}