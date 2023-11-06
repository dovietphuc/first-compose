package com.example.firstcompose.data

import com.example.firstcompose.api.NewsService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(private val newsService: NewsService) {
    fun getAllNews() = flow {
        emit(newsService.getAllNews())
    }
}