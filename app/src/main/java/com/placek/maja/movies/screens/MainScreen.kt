package com.placek.maja.movies.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.placek.maja.movies.Movie
import com.placek.maja.movies.R
import com.placek.maja.movies.getMovies


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController){
    Column {
        TopAppBar(
            title = { Text(text = stringResource(R.string.movies_app_title)) }
        )
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
)  {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(movieList) { movie ->
                MovieRow(movie = movie, onMovieClick =  { movie ->
                    navController.navigate(route = Screen.DetailsScreen.withArgs(movie.title))
                })
            }
        }
    }
}

@Composable
fun MovieRow(movie: Movie, onMovieClick: (Movie) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .clickable { onMovieClick(movie) }
                .padding(16.dp)
        ) {
            Text(
                text = movie.title.uppercase(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )
            Image(
                painter = painterResource(id = movie.posterResId),
                contentDescription = stringResource(R.string.movie_poster),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(R.string.year_genre, movie.year, movie.genre),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
            )
        }
    }
}

