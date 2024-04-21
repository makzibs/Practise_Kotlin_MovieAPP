package com.example.myapplication

import PopularMovie
import Results
import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Movie
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreditCardScreen(viewModel: CreditCardViewModel) {
    val movies by viewModel.movies.observeAsState(emptyList<Results>())

    LaunchedEffect(Unit) {
        viewModel.fetchPopularMovies(
            apiKey = "c14c15c28109f082c13fc95d04b65361",

        )
    }

    // Display a loading indicator while data is being fetched
    if (movies.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        // Once data is available, display the movie titles
        MovieList(movieList = movies)
        println(movies.toString())
    }
}

@Composable
fun MovieList(movieList: List<Results>) {
    LazyColumn {
        itemsIndexed(items = movieList) { index, movie ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Movie ${index + 1}: ${movie.title ?: "Unknown Title"}")
            }
        }
    }
}

/*
@Composable
fun MovieItem(movie: PopularMovie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

    ) {
        Column(
            modifier = Modifier
                .clickable { */
/* Handle click on movie item if needed *//*
 }
                .padding(16.dp)
        ) {
            Text(
                text = movie.title ?: "Unknown Title",
                style = MaterialTheme.typography.h6,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = movie.overview ?: "No overview available",
                style = MaterialTheme.typography.body2,
                color = Color.Gray
            )
        }
    }
}*/
