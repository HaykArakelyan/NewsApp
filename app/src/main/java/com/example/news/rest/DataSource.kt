package com.example.news.rest

import com.example.news.entities.NewsResponse

class DataSource {

    suspend fun loadAllNewsByQ(key: String): NewsResponse{
        return RetrofitHelper.getInstance().create(NewsApiService::class.java).fetchAllNewsByQ(key)
    }

    suspend fun loadNewsByCountry(country: String): NewsResponse{
        return RetrofitHelper.getInstance().create(NewsApiService::class.java).fetchNewsByCountry(country)
    }

    suspend fun loadNewsByCategory(category: String): NewsResponse{
        return RetrofitHelper.getInstance().create(NewsApiService::class.java).fetchNewsByCategory(category)
    }

    suspend fun loadNewsBySearchAndCategory(q: String, category: String): NewsResponse{
        return RetrofitHelper.getInstance().create(NewsApiService::class.java).fetchNewsBySearchAndCategory(q, category)
    }
}