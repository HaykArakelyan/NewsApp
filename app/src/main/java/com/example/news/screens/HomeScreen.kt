package com.example.news.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.news.components.LoadingIndicator
import com.example.news.components.RefreshPage
import com.example.news.design.Header
import com.example.news.entities.ArticleResponse


@Composable
fun HomeScreen(
    navController: NavController,
    news: List<ArticleResponse>?,
    getNewsBySearchAndCategory: (String, String) -> Unit,
    getNewsByCategory: (String) -> Unit,
    getNewsByQ: (String) -> Unit,
    onRefresh: () -> Unit
) {
    Column {
        Header(
            onCategoryClickWithQ = { it: String, other: String ->
                getNewsBySearchAndCategory(it, other)
            },
            onCategoryClick = {
                getNewsByCategory(it)
            },
            onSearchWithQ = {
                getNewsByQ(it)
            }
        )
        when (news?.isNotEmpty()) {
            true -> {
                RefreshPage(
                    defaultData = news,
                    onRefresh = onRefresh,
                    navController = navController
                )
            }
            else -> LoadingIndicator()
        }

    }
}
