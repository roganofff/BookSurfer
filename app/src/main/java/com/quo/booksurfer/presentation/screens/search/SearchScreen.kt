package com.quo.booksurfer.presentation.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quo.booksurfer.R
import com.quo.booksurfer.ui.theme.SurfBlack
import com.quo.booksurfer.ui.theme.SurfGray
import com.quo.booksurfer.ui.theme.SurfLightGray
import com.quo.booksurfer.ui.theme.SurfRed
import com.quo.booksurfer.ui.theme.robotoFontFamily

@Composable
fun SearchScreen(
    modifier: Modifier,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val state by searchViewModel.uiState.collectAsStateWithLifecycle()

    val errorMessage = state.errorMessage

    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .background(SurfLightGray, shape = RoundedCornerShape(8.dp))
                    .weight(1f)
            ) {
                SearchTextField()
            }
            Spacer(
                modifier = Modifier.width(8.dp),
            )
            FilterButton()
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 55.dp)
                .padding(top = 222.dp),
            text = stringResource(R.string.search_placeholder),
            textAlign = TextAlign.Center,
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = 18.sp * 1.2f,
            letterSpacing = 0.sp,
            color = SurfBlack
        )
    }
}

@Composable
fun SearchTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Center,
            color = SurfBlack,
        ),
        placeholder = {
            Text(
                text = stringResource(R.string.search),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Center,
                color = SurfGray,
            )
        },
        maxLines = 1,
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                tint = SurfGray,
                contentDescription = stringResource(R.string.search),
            )
        }
    )
}

@Composable
fun FilterButton() {
    Button(
        modifier = Modifier
            .size(48.dp),
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        colors = ButtonColors(
            containerColor = SurfLightGray,
            contentColor = SurfGray,
            disabledContainerColor = SurfLightGray,
            disabledContentColor = SurfGray
        ),
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = ImageVector.vectorResource(R.drawable.ic_filter),
            tint = SurfGray,
            contentDescription = stringResource(R.string.filter)
        )
    }
}