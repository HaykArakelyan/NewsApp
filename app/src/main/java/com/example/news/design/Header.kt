package com.example.news.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.news.components.SortButton
import com.example.news.constants.CATEGORIES
import com.example.news.constants.DEFAULT_DARK_BLUE_COLOR


@Composable
fun Header(
    onCategoryClickWithQ: (String, String) -> Unit,
    onCategoryClick: (String) -> Unit,
    onSearchWithQ: (String) -> Unit
) {

    var searchBarContent by remember {
        mutableStateOf<String>("")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(DEFAULT_DARK_BLUE_COLOR)
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "News",
                modifier = Modifier.padding(bottom = 16.dp),
                style = MaterialTheme.typography.h3,
                color = Color.White
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                SearchBar(
                    searchBarContent,
                    onSearchBarUpdate = { it: String ->
                        searchBarContent = it
                    },
                    onSearchWithQ = onSearchWithQ
                )



                SortButton(
                    CATEGORIES,
                    searchBarContent,
                    onCategoryClick,
                    onCategoryClickWithQ
                )
            }
        }
    }
}

@Composable
fun SearchBar(
    searchBarContent: String,
    onSearchBarUpdate: (String) -> Unit,
    onSearchWithQ: (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(percent = 15)),
        value = searchBarContent,
        onValueChange = {
            onSearchBarUpdate(it)
        },
        leadingIcon = {
            IconButton(
                onClick = {
                    onSearchWithQ(searchBarContent)
                }
            ) {
                Icon(
                    Icons.Outlined.Search,
                    contentDescription = "search"
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearchWithQ(searchBarContent)
            }
        )
    )
}