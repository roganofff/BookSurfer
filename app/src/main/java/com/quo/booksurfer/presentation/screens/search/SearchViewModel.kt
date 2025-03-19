package com.quo.booksurfer.presentation.screens.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class SearchViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SearchScreenState())
    val uiState = _uiState.asStateFlow()
}
