package com.example.news.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF37339A))
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

                SearchBar()


                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Outlined.Tune,
                        contentDescription = "filter",
                        tint = Color(0xFF37339A),
                        modifier = Modifier
                            .background(Color.White, shape = RoundedCornerShape(percent = 10))
                            .size(55.dp)
                            .rotate(-90f),
                    )
                }
            }
        }
    }
}

@Composable
fun SearchBar() {
    var result by remember {
        mutableStateOf("")
    }


    TextField(
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(percent = 15)),
        value = result,
        onValueChange = {
            result = it
        },
        leadingIcon = {
            IconButton(
                onClick = {

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
        )

    )
}