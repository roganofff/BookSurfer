package com.quo.booksurfer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.quo.booksurfer.presentation.navigation.BottomNavigationBarItem
import com.quo.booksurfer.presentation.navigation.MainDestinations
import com.quo.booksurfer.presentation.navigation.NavigationGraph
import com.quo.booksurfer.ui.theme.BookSurferTheme
import com.quo.booksurfer.ui.theme.SurfBlue
import com.quo.booksurfer.ui.theme.SurfGray
import com.quo.booksurfer.ui.theme.SurfWhite
import com.quo.booksurfer.ui.theme.robotoFontFamily
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
            route = MainDestinations.Search.name,
            icon = ImageVector.vectorResource(R.drawable.ic_search),
        ),
        BottomNavigationBarItem(
            title = stringResource(R.string.favorite),
            route = MainDestinations.Details.name,
            icon = ImageVector.vectorResource(R.drawable.ic_favorite),
        ),
    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    BookSurferTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize().padding(vertical = 16.dp),
            containerColor = SurfWhite,
            bottomBar = {
                NavigationBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .drawBehind {
                            drawLine(
                                color = SurfGray,
                                start = Offset(0f, 0f),
                                end = Offset(size.width, 0f),
                                strokeWidth = 1.dp.toPx()
                            )
                        },
                    containerColor = SurfWhite,
                ) {
                    navigationItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            modifier = Modifier.fillMaxSize(),
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(item.route)
                            },
                            label = {
                                Text(
                                    text = item.title,
                                    fontFamily = robotoFontFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    textAlign = TextAlign.Center,
                                    color = if (index == selectedItemIndex) {
                                        SurfBlue
                                    } else SurfGray
                                )
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    tint = if (index == selectedItemIndex) {
                                        SurfBlue
                                    } else SurfGray,
                                    contentDescription = item.title,
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.Transparent
                            ),
                        )
                    }
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
