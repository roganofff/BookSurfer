package com.quo.booksurfer.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.quo.booksurfer.presentation.screens.detail.DetailScreen
import com.quo.booksurfer.presentation.screens.search.SearchScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = MainDestinations.Search.name,
        modifier = modifier.fillMaxSize()
    ) {
        composable(
            route = MainDestinations.Search.name,
        ) {
            SearchScreen(
                modifier = modifier,
            )
        }
        composable(
            route = MainDestinations.Details.name,
        ) {
            DetailScreen(
            )
        }
    }
}