package com.example.news.constants

import androidx.compose.ui.graphics.Color
import com.example.news.entities.Category

//const val APIKEY = "apiKey=5ae1c6ecf0c94d69b892439ab6270ff1"
//TODO my second account API key since this dump webpage allows only limited number of requests
const val APIKEY = "apiKey=c6d6dc8198bd436181a6d76615547d3a"
val DEFAULT_DARK_BLUE_COLOR = Color(0xFF37339A)

val CATEGORIES = listOf<Category>(
    Category(0, "Business"),
    Category(1, "Entertainment"),
    Category(2, "General"),
    Category(3, "Health"),
)
const val DEFAULT_IMAGE_URL = "https://i.ibb.co/xjkHG6r/news-Copy-removebg-preview.png"