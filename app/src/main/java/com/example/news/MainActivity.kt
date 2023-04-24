package com.example.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.news.entities.ArticleResponse
import com.example.news.entities.Source
import com.example.news.navigation.Screens
import com.example.news.screens.DetailScreen
import com.example.news.screens.HomeScreen
import com.example.news.viewmodels.NewsViewModel
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


class MainActivity : ComponentActivity() {

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getDefaultData()
        viewModel.news.observe(this) { news ->
            setContent {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screens.HomeScreen.route
                ) {

                    composable(route = Screens.HomeScreen.route) {
                        HomeScreen(
                            navController = navController,
                            news = news.articles,
                            getNewsBySearchAndCategory = { first, second ->
                                viewModel.getNewsBySearchAndCategory(first, second)
                            },
                            getNewsByCategory = {
                                viewModel.getNewsByCategory(it)
                            },
                            getNewsByQ = {
                                viewModel.getNewsByQ(it)
                            },
                            onRefresh = viewModel::getDefaultData
                        )
                    }

                    composable(
                        route = Screens.DetailScreen.route +
                                "/{id}" +
                                "/{name}" +
                                "/{author}" +
                                "/{title}" +
                                "/{description}" +
                                "/{url}" +
                                "/{url_to_image}" +
                                "/{published_at}" +
                                "/{content}",
                        arguments = listOf(
                            navArgument("id") { type = NavType.StringType },
                            navArgument("name") { type = NavType.StringType },
                            navArgument("author") { type = NavType.StringType },
                            navArgument("title") { type = NavType.StringType },
                            navArgument("description") { type = NavType.StringType },
                            navArgument("url") { type = NavType.StringType },
                            navArgument("url_to_image") { type = NavType.StringType },
                            navArgument("published_at") { type = NavType.StringType },
                            navArgument("content") { type = NavType.StringType }
                        )
                    ) {

                        DetailScreen(
                            navController = navController,
                            article = ArticleResponse(
                                source = Source(
                                    id = it.arguments?.getString("id"),
                                    name = it.arguments?.getString("name")
                                ),
                                author = it.arguments?.getString("author"),
                                title = it.arguments?.getString("author"),
                                description = it.arguments?.getString("description"),
                                url = URLDecoder.decode(
                                    it.arguments?.getString("url"),
                                    StandardCharsets.UTF_8.toString()
                                ),
                                urlToImage = URLDecoder.decode(
                                    it.arguments?.getString("url_to_image"),
                                    StandardCharsets.UTF_8.toString()
                                ),
                                publishedAt = it.arguments?.getString("published_at"),
                                content = it.arguments?.getString("content"),
                            )
                        )
                    }
                }
            }
        }
    }
}