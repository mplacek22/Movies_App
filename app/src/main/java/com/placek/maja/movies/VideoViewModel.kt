package com.placek.maja.movies

import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player

class VideoViewModel(
    movie: Movie,
    var player: Player
) : ViewModel(){

    private var videoItems = movie.trailerUris.map { uri ->
        VideoItem(
            contentUri = uri,
            mediaItem = MediaItem.fromUri(uri),
            title = movie.title
        )
    }

    init {
        player.prepare()
        player.addMediaItems(videoItems.map { it.mediaItem })
    }

}