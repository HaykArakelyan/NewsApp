package com.example.news.design

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.news.entities.ArticleResponse
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign


@Composable
fun NewsCards(articles: List<ArticleResponse>?){

    when (articles?.isNotEmpty()) {
        true -> {
            LazyColumn {
                items(articles) { element ->
                    Card(
                        Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    ) {
                        Column(
                            Modifier.padding(8.dp)
                        ) {
                            Text(text = "${element.title}", style = MaterialTheme.typography.h5)
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