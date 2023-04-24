package com.example.news.rest

import com.example.news.constants.APIKEY
import com.example.news.entities.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService{
    @GET("v2/everything?$APIKEY")
    suspend fun fetchAllNewsByQ(@Query("q") key: String): NewsResponse


    @GET("v2/top-headlines?$APIKEY")
    suspend fun fetchNewsByCountry(@Query("country") country: String): NewsResponse

    @GET("v2/top-headlines?$APIKEY")
    suspend fun fetchNewsByCategory(@Query("category") category: String): NewsResponse

    @GET("v2/top-headlines?$APIKEY")
    suspend fun fetchNewsBySearchAndCategory(
        @Query("q") q: String,
        @Query("category") category: String
    ): NewsResponse

}