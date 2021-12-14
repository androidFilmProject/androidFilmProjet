package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val movie: List<Movie>
)
{
    data class Movie(

        @SerializedName("id")
        val id: String,

        @SerializedName("original_title")
        val name: String,

        @SerializedName("overview")
        val description: String,

        @SerializedName("poster_path")
        val poster_path: String,

        @SerializedName("vote_average")
        val vote_average: Float
    )
}
internal fun MovieResponse.Movie.toMovie() = Movie(
    id = id.toInt(),
    name = name ,
    description = description,
    poster_path =  "https://image.tmdb.org/t/p/original" + poster_path,
)
