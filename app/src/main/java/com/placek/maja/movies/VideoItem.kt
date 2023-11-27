package com.placek.maja.movies

import androidx.media3.common.MediaItem
import android.net.Uri

data class VideoItem(
    val contentUri: Uri,
    val mediaItem: MediaItem,
    val title: String = "no title",
    )
