package com.gmail.eamosse.idbdata.api.service

import com.gmail.eamosse.idbdata.api.response.CategoryResponse
import com.gmail.eamosse.idbdata.api.response.MoviesListResponse
import com.gmail.eamosse.idbdata.api.response.TokenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MovieService {
    @GET("authentication/token/new")
    suspend fun getToken(): Response<TokenResponse>
    @GET("genre/movie/list")
    suspend fun getCategories(): Response<CategoryResponse>
    @GET("movie/{id}/lists")
    suspend fun getMoviesLists( @Path(value = "id", encoded = false) key: Int): Response<MoviesListResponse>


}