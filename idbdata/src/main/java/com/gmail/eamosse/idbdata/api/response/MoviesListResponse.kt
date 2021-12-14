package com.gmail.eamosse.idbdata.api.response


import com.gmail.eamosse.idbdata.data.MoviesList
import com.google.gson.annotations.SerializedName

data class FilmResponse(
    @SerializedName("results")
    val films: List<Movies>
)
{
    data class Movies(

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

internal fun FilmResponse.Movies.toMovies() = MoviesList(
    id = id,
    name = name ,
    description = description,
    poster_path =  "https://image.tmdb.org/t/p/original" + poster_path,
    vote_average = vote_average
)
