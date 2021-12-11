package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.idbdata.data.Token
import com.gmail.eamosse.idbdata.local.entities.TokenEntity
import com.google.gson.annotations.SerializedName

internal data class CategoryResponse(
    @SerializedName("genres")
    val genres: List<Genre>
) {
    data class Genre(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    )
}

/**
 * Une classe d'extension utilisée pour convertir la réponse en objet exploitable
 * par les autres composants de l'application
 */
internal fun CategoryResponse.Genre.toCategory() = Category(
    id = id!!,
    name = name!!
)

