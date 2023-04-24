package com.example.news.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

    fun getDefaultData(){
        getNewsByCategory("technology")
    }


    fun getNewsByQ(key: String) {
        viewModelScope.launch {
            try {
                val response = DataSource().loadAllNewsByQ(key)
                _news.postValue(response)
            } catch (e: Exception) {
                Log.d("mydata", e.message.toString())
            }
        }
    }

    fun getNewsByCountry(country: String) {
        viewModelScope.launch {
            try {
                val response = DataSource().loadNewsByCountry(country)
                _news.postValue(response)
            } catch (e: Exception) {
                Log.d("mydata", e.message.toString())
            }
        }
    }

    fun getNewsByCategory(category: String) {
        viewModelScope.launch {
            try {
                val response = DataSource().loadNewsByCategory(category)
                _news.postValue(response)
            } catch (e: Exception) {
                Log.d("mydata", e.message.toString())
            }
        }
    }

    fun getNewsBySearchAndCategory(q: String, category: String) {
        viewModelScope.launch {
            try {
                val response = DataSource().loadNewsBySearchAndCategory(q, category)
                _news.postValue(response)
            } catch (e: Exception){
                Log.d("mydata", e.message.toString())
            }
        }
    }

}