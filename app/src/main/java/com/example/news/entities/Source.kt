package com.example.news.entities

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
)
