package com.quo.booksurfer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.rememberNavController
import com.quo.booksurfer.presentation.navigation.BottomNavigationBarItem
import com.quo.booksurfer.presentation.navigation.NavigationGraph
import com.quo.booksurfer.ui.theme.BookSurferTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { App() }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    val navigationItems = listOf(
        BottomNavigationBarItem(
            title = stringResource(R.string.search),
            selectedItem = ImageVector.vectorResource(R.drawable.ic_search_selected),
            unselectedItem = ImageVector.vectorResource(R.drawable.ic_search_unselected),
        ),
        BottomNavigationBarItem(
            title = stringResource(""),
            selectedItem = ImageVector.vectorResource(R.drawable.ic_search_selected),
            unselectedItem = ImageVector.vectorResource(R.drawable.ic_search_unselected),
        ),
    )
    BookSurferTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White,
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    NavigationBar {

                    }
                }
            ) { innerPadding ->
                NavigationGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }

}
}