package com.quo.booksurfer.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationBarItem(
    val title: String,
    val selectedItem: ImageVector,
    val unselectedItem: ImageVector
)
