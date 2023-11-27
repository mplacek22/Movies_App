package com.placek.maja.movies

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

data class Movie (
    val title: String,
    val posterResId: Int,
    val year: Int,
    val genre: String,
    val description: String,
    val actors: List<String>,
    val scenesResIds: List<Int>,
    val trailerUris: List<Uri>
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
                R.drawable.interstellar_scene_03,
                R.drawable.interstellar_scene_04,
                R.drawable.interstellar_scene_05,
                R.drawable.interstellar_scene_06,
                R.drawable.interstellar_scene_07,
                R.drawable.interstellar_scene_08,
                R.drawable.interstellar_scene_09,
            ),
            trailerUris = listOf(
                Uri.parse("android.resource://com.placek.maja.movies/" + R.raw.interstellar_trailer),
                Uri.parse("android.resource://com.placek.maja.movies/" + R.raw.interstellar_trailer_02),
                Uri.parse("android.resource://com.placek.maja.movies/" + R.raw.interstellar_trailer_03)
            )
        ),
        Movie(
            title = stringResource(R.string.inception_title),
            posterResId = R.drawable.inception_poster,
            year = 2010,
            genre = stringResource(R.string.sci_fi),
            description = stringResource(R.string.inception_description),
            actors = listOf(stringResource(R.string.leonardo_dicaprio),
                stringResource(R.string.joseph_gordon_levitt),
                stringResource(R.string.ellen_page)
            ),
            scenesResIds = listOf(
                R.drawable.inception_scene_01,
                R.drawable.inception_scene_02,
                R.drawable.inception_scene_03,
                R.drawable.inception_scene_04,
                R.drawable.inception_scene_05,
                R.drawable.inception_scene_06,
                R.drawable.inception_scene_07,
                R.drawable.inception_scene_08,
                R.drawable.inception_scene_09
            ),
            trailerUris = listOf(
                Uri.parse("android.resource://com.placek.maja.movies/" + R.raw.inception_trailer_01),
                Uri.parse("android.resource://com.placek.maja.movies/" + R.raw.inception_trailer_02),
                Uri.parse("android.resource://com.placek.maja.movies/" + R.raw.inception_trailer_03)
            )
        ),
        Movie(
            title = stringResource(R.string.grand_budapest_hotel_title),
            posterResId = R.drawable.grand_budapest_hotel_poster,
            year = 2014,
            genre = stringResource(R.string.comedy),
            description = stringResource(R.string.grand_budapest_hotel_description),
            actors = listOf(stringResource(R.string.ralph_fiennes),
                stringResource(R.string.f_murray_abraham),
                stringResource(R.string.mathieu_amalric)
            ),
            scenesResIds = listOf(
                R.drawable.grand_budapest_hotel_scene_01,
                R.drawable.grand_budapest_hotel_scene_02,
                R.drawable.grand_budapest_hotel_scene_03,
                R.drawable.grand_budapest_hotel_scene_04,
                R.drawable.grand_budapest_hotel_scene_05,
                R.drawable.grand_budapest_hotel_scene_06,
                R.drawable.grand_budapest_hotel_scene_07,
                R.drawable.grand_budapest_hotel_scene_08,
                R.drawable.grand_budapest_hotel_scene_09
            ),
            trailerUris = listOf(
                Uri.parse("android.resource://com.placek.maja.movies/" + R.raw.grand_budapest_hotel_trailer_01),
                Uri.parse("android.resource://com.placek.maja.movies/" + R.raw.grand_budapest_hotel_trailer_02),
                Uri.parse("android.resource://com.placek.maja.movies/" + R.raw.grand_budapest_hotel_trailer_03)
            )
        )
    )
}
