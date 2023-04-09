package com.example.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import com.example.news.design.Header
import com.example.news.design.NewsCards
import com.example.news.viewmodels.NewsViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewModel.getNews("bitcoin")
//        viewModel.getNewsByCountry("us")
        viewModel.news.observe(this) { news ->
            setContent {
                Column {
                    Header()
                    when (news.articles?.isNotEmpty()) {
                        true -> NewsCards(articles = news.articles)
                        else -> Text(text = "Loading...")
                    }
                }
            }
        }
    }
//        viewModel.getNewsByCountry("us")
}