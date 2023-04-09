package com.example.news.rest

import com.example.news.entities.NewsResponse

class DataSource {

    suspend fun loadAllNews(key: String): NewsResponse{
        return RetrofitHelper.getInstance().create(NewsApiService::class.java).fetchAllNews(key)
    }

    suspend fun loadNewsByCountry(country: String): NewsResponse{
        return RetrofitHelper.getInstance().create(NewsApiService::class.java).fetchNewsByCountry(country)
    }
}