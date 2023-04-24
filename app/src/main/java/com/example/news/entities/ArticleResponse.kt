package com.example.news.entities

import com.google.gson.annotations.SerializedName

data class ArticleResponse (
    @SerializedName("source")
    var source: Source?,
    @SerializedName("author")
    var author: String? = "",
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("description")
    var description: String? = "",
    @SerializedName("url")
    var url: String? = "",
    @SerializedName("urlToImage")
    var urlToImage: String? = "",
    @SerializedName("publishedAt")
    var publishedAt: String? = "",
    @SerializedName("content")
    var content: Any? = ""

)
