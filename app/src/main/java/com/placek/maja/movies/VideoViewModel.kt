package com.placek.maja.movies

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player

class VideoViewModel(
    movies: List<Movie>,
    var player: Player
) : ViewModel(){

    var videoItems = movies.map { movie ->
        VideoItem(
            contentUri = movie.trailerUri,
            mediaItem = MediaItem.fromUri(movie.trailerUri),
            title = movie.title
        )
    }

    init {
        player.prepare()
        player.addMediaItems(videoItems.map { it.mediaItem })
    }

    fun playVideo(contentUri: Uri, playern: Player) {
        player = playern
        val mediaItem = MediaItem.fromUri(contentUri)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }
}