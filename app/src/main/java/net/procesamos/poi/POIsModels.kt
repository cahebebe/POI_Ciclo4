package net.procesamos.poi

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class POIsModels(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("rate")
    val rate: String? = null,
    @SerializedName("picture")
    val picture: String? = null,
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null,
) : Serializable
