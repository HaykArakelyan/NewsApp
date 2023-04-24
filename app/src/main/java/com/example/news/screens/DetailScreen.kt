package com.example.news.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.news.constants.*
import com.example.news.entities.ArticleResponse


@Composable
fun DetailScreen(navController: NavController, article: ArticleResponse) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = DEFAULT_DARK_BLUE_COLOR,
            ) {
                Row(horizontalArrangement = Arrangement.Start) {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Go Back",
                            tint = Color.White
                        )
                    }
                }
            }
        },
    ) {
        it
        Column(modifier = Modifier.padding(8.dp)) {
            Column {
                Text(text = "Source: ${article.source?.name}")
                Text(text = "Author: ${article.author}")
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                ) {
                    AsyncImage(
                        // FIXME I was trying to use the images of the article, but it wasn't working well
//                    model = if (article.urlToImage.isNullOrEmpty()) article.urlToImage else DEFAULT_IMAGE_URL,
                        model = DEFAULT_IMAGE_URL,
                        contentDescription = "article image",
                        modifier = Modifier
                            .height(200.dp)
                            .offset(y = 18.dp)
                            .zIndex(1.0f),
                    )

                    Box(
                        modifier = Modifier
                            .background(Color.LightGray, RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .padding(top = 20.dp, bottom = 20.dp),
                        contentAlignment = Alignment.Center,

                        ) {
                        // NOTE instead of the title of the article, I am getting the name of the author
                        Text(
                            text = "${article.title}",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                    }

                    Box(modifier = Modifier.padding(top = 30.dp)) {
                        if (article.content != "null") {
                            Text(
                                text = "${article.content}",
                                style = MaterialTheme.typography.body1
                            )
                        }
                    }
                }
            }
        }
    }
}