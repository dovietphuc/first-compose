package com.example.firstcompose.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.firstcompose.data.News
import com.example.firstcompose.data.NewsListResponse
import com.example.firstcompose.data.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class NewsListViewModels @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repository: NewsRepository
) : ViewModel() {
    val newsList: LiveData<NewsListResponse> = repository.getAllNews().asLiveData()
}