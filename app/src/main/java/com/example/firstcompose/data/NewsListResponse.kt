package com.example.firstcompose.data

import com.google.gson.annotations.SerializedName

data class NewsListResponse(@field:SerializedName("items") val results: List<News>)