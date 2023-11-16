package com.placek.maja.movies

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

data class Movie (
    val title: String,
    val posterResId: Int,
    val year: Int,
    val genre: String,
    val description: String,
    val actors: List<String>,
    val scenesResIds: List<Int>
)

data class Actor(
    val name: String,
    val photoResId: Int,
)

@Composable
fun getMovies() : List<Movie>{
    return listOf (
        Movie(
            title = stringResource(R.string.interstellar_title),
            posterResId = R.drawable.interstellar_poster,
            year = 2014,
            genre = stringResource(R.string.sci_fi),
            description = stringResource(R.string.interstellar_description),
            actors = listOf(stringResource(R.string.matthew_mcconaughey_name),
                stringResource(R.string.anne_hathaway_name),
                stringResource(R.string.jessica_chastain_name)
            ),
            scenesResIds = listOf(
                R.drawable.interstellar_scene_01,
                R.drawable.interstellar_scene_02,
                R.drawable.interstellar_scene_03
            )
        ),
        Movie(
            title = stringResource(R.string.inception_title),
            posterResId = R.drawable.inception_poster,
            year = 2010,
            genre = stringResource(R.string.sci_fi),
            description = stringResource(R.string.inception_description),
            actors = listOf("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"),
            scenesResIds = listOf(
                R.drawable.inception_scene_01,
                R.drawable.inception_scene_02,
                R.drawable.inception_scene_03
            )
        ),
        Movie(
            title = stringResource(R.string.grand_budapest_hotel_title),
            posterResId = R.drawable.grand_budapest_hotel_poster,
            year = 2014,
            genre = stringResource(R.string.comedy),
            description = stringResource(R.string.grand_budapest_hotel_description),
            actors = listOf("Ralph Fiennes", "F. Murray Abraham", "Mathieu Amalric"),
            scenesResIds = listOf(
                R.drawable.grand_budapest_hotel_scene_01,
                R.drawable.grand_budapest_hotel_scene_02,
                R.drawable.grand_budapest_hotel_scene_03
            )
        )
    )
}
