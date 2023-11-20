package com.placek.maja.movies.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.placek.maja.movies.DetailsViewMode
import com.placek.maja.movies.Movie
import com.placek.maja.movies.MovieViewModel
import com.placek.maja.movies.R
import com.placek.maja.movies.getMovies

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, movieTitle: String, viewModel: MovieViewModel = remember { MovieViewModel() }) {
    val movie = getMovies().find { it.title == movieTitle }

    if (movie == null) {
        navController.popBackStack()
        return
    }

    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.medium_space))
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_space)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text(text = movieTitle) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }

        )
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            ) {
                Image(
                    painter = painterResource(id = movie.posterResId),
                    contentDescription = "Movie Poster",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(2 / 3f)
                        .fillMaxSize()
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MovieDetails(movie)
            }
        }

        Row (
            horizontalArrangement = Arrangement.Center
        ){
            ModeSelector(selectedMode = viewModel.selectedMode, updateMode = viewModel::updateMode)
        }

        Row (modifier = Modifier.fillMaxSize()){
            when (viewModel.selectedMode) {
                DetailsViewMode.Actors -> ActorsList(actorsList = movie.actors)
                DetailsViewMode.Scenes -> PhotoGrid(photoList = movie.scenesResIds)
            }
        }
    }
}

@Composable
private fun MovieDetails(movie: Movie) {
    Text(text = movie.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
    Text(text = "Year: ${movie.year}", fontSize = 16.sp)
    Text(text = "Genre: ${movie.genre}", fontSize = 16.sp)
    Divider()
    Text(text = "Description:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
    Text(text = movie.description, fontSize = 16.sp)
}


@Composable
fun PhotoGrid(photoList: List<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier.height(1000.dp)
    ) {
        items(photoList) { photoResId ->
            PhotoItem(photoResId = photoResId)
        }
    }
}

@Composable
fun ActorsList(actorsList: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.height(1000.dp)
    ) {
        items(actorsList) { actor ->
            ActorItem(actor = actor)
        }
    }
}

@Composable
fun ActorItem(actor: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.LightGray),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = actor,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}


@Composable
fun PhotoItem(photoResId: Int) {
    Card(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = RoundedCornerShape(4.dp)
    ) {
        Image(
            painter = painterResource(id = photoResId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ModeSelector(selectedMode: DetailsViewMode, updateMode: (DetailsViewMode) -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_space))) {
        DetailsViewMode.values().forEach {
            ElevatedFilterChip(
                selected = selectedMode == it,
                onClick = { updateMode(it) },
                label = {
                    Text(it.name)
                }
            )
        }
    }
}