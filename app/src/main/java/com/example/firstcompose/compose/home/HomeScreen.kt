package com.example.firstcompose.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firstcompose.R
import com.example.firstcompose.data.News
import com.example.firstcompose.data.NewsListResponse
import com.example.firstcompose.viewmodels.NewsListViewModels

@Composable
fun HomeScreen(
    onNewsClick: (News) -> Unit = {},
    viewModel: NewsListViewModels = hiltViewModel()
) {
    val newsList by viewModel.newsList.observeAsState(initial = NewsListResponse(emptyList()))
    LazyColumn {
        items(
            items = newsList.results,
            key = { it.id }
        ) { news ->
            NewsListItem(news = news) {
                onNewsClick(news)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListItem(news: News, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.card_padding))
            .padding(vertical = dimensionResource(id = R.dimen.card_bottom_margin))
    ) {
        Column(modifier = Modifier
            .padding(dimensionResource(id = R.dimen.card_padding))
            .fillMaxWidth()) {
            Text(text = news.title,
                style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(6.dp))
            Row {
                Text(
                    text = "View: ${news.viewCount}",
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = news.getCreateDateString(),
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.End ,
                    modifier = Modifier
                            .fillMaxWidth()
                )
            }
        }
    }
}