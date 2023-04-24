package com.example.news.design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.news.entities.ArticleResponse
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.news.constants.DEFAULT_DARK_BLUE_COLOR
import com.example.news.constants.DEFAULT_IMAGE_URL
import com.example.news.navigation.Screens
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun NewsCards(
    navController: NavController,
    articles: List<ArticleResponse>?,
) {

    when (articles?.isNotEmpty()) {
        true -> {
            LazyColumn {
                items(articles) { element ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .height(130.dp)
                            .clickable {
                                navController.navigate(
                                    Screens.DetailScreen.route +
                                            "/${element.source?.id}" +
                                            "/${element.source?.name}" +
                                            "/${element.author}" +
                                            "/${element.title}" +
                                            "/${element.description}" +
                                            "/${
                                                URLEncoder.encode(
                                                    if (element.url == null) "" else element.url,
                                                    StandardCharsets.UTF_8.toString()
                                                )
                                            }" +
                                            "/${
                                                URLEncoder.encode(
                                                    if (element.urlToImage == null) "" else element.urlToImage,
                                                    StandardCharsets.UTF_8.toString()
                                                )
                                            } " +
                                            "/${element.publishedAt}" +
                                            "/${element.content}"
                                )
                            },
                        elevation = 8.dp
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = DEFAULT_IMAGE_URL,
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .height(100.dp)
                                    .width(100.dp),
                            )
                            Column(
                                Modifier
                                    .padding(8.dp)
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "${element.source?.name}", fontSize = 12.sp)
                                Text(
                                    text = "${element.title}",
                                    fontSize = 14.sp,
                                    color = DEFAULT_DARK_BLUE_COLOR,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(text = "${element.author}", fontSize = 12.sp)
                            }
                        }
                    }
                }
            }
        }
        else -> {
            Text(
                text = "Something went wrong",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}