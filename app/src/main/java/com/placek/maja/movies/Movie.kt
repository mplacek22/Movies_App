package com.placek.maja.movies

data class Movie (
    val title: String,
    val posterResId: Int,
    val year: Int,
    val genre: String,
    val description: String,
    val actors: List<String>
)

fun getMovies() : List<Movie>{
    return listOf (
        Movie(
            title = "Interstellar",
            posterResId = R.drawable.interstellar_poster,
            year = 2014,
            genre = "Sci-Fi",
            description = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            actors = listOf("Matthew McConaughey", "Anne Hathaway", "Jessica Chastain")
        ),
        Movie(
            title = "Inception",
            posterResId = R.drawable.inception_poster,
            year = 2010,
            genre = "Sci-Fi",
            description = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
            actors = listOf("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page")
        ),
        Movie(
            title = "Grand Budapest Hotel",
            posterResId = R.drawable.grand_budapest_hotel_poster,
            year = 2014,
            genre = "Comedy",
            description = "A writer encounters the owner of an aging high-class hotel, who tells him of his early years serving as a lobby boy in the hotel's glorious years under an exceptional concierge.",
            actors = listOf("Ralph Fiennes", "F. Murray Abraham", "Mathieu Amalric")
        )
    )
}
