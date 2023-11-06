package com.example.firstcompose.data

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class News(
    @field:SerializedName("title") val title: String,
    @field:SerializedName("link") val link: String,
    @field:SerializedName("question_id") val id: Int,
    @field:SerializedName("creation_date") val createDate: Long,
    @field:SerializedName("view_count") val viewCount: Int
) {
    fun getCreateDateString() : String {
        val date = Date(createDate)
        return date.toString()
    }
}