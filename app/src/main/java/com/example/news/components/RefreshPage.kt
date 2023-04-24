package com.example.news.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.news.design.NewsCards
import com.example.news.entities.ArticleResponse
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun RefreshPage(
    defaultData: List<ArticleResponse>?,
    onRefresh: () -> Unit,
    navController: NavController
) {
    val refreshState = rememberSwipeRefreshState(isRefreshing = false)

    SwipeRefresh(
        state = refreshState,
        onRefresh = {
            onRefresh()

            refreshState.isRefreshing = true

            // NOTE instead of this dump check, the data in viewModel should be checked (updated or not)
            if(defaultData.isNullOrEmpty()){
                refreshState.isRefreshing = false
            }
        }
    ) {
        NewsCards(navController = navController, articles = defaultData)
    }

}


