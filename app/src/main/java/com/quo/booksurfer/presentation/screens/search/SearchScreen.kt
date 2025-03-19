package com.quo.booksurfer.presentation.screens.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchScreen(
    modifier: Modifier,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val state by searchViewModel.uiState.collectAsStateWithLifecycle()

    val errorMessage = state.errorMessage

    
}