package com.example.news.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.entities.ArticleResponse
import com.example.news.entities.NewsResponse
import com.example.news.rest.DataSource
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val _news = MutableLiveData<NewsResponse>()
    val news: LiveData<NewsResponse> = _news

    //TODO In the future these logs will be removed
    fun getNews(key: String) {
        viewModelScope.launch {
            try {
                val response = DataSource().loadAllNews(key)
                _news.postValue(response)
            } catch (e: Exception) {
                Log.d("mydata", e.message.toString())
            }
        }
    }

    fun getNewsByCountry(country: String){
        viewModelScope.launch {
            try {
                val response = DataSource().loadNewsByCountry(country)
                _news.postValue(response)
            } catch (e: Exception) {
                Log.d("mydata", e.message.toString())
            }
        }
    }

}