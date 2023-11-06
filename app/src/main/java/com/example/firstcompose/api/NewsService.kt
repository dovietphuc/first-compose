package com.example.firstcompose.api

import com.example.firstcompose.data.NewsListResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("/2.3/questions?order=desc&sort=creation&site=stackoverflow")
    suspend fun getAllNews(): NewsListResponse

    companion object {
        private const val BASE_URL = "https://api.stackexchange.com/"

        fun create(): NewsService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsService::class.java)
        }
    }
}