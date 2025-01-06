package com.plantas.garden.modelo

import com.google.gson.annotations.SerializedName

data class Plantas (
    @SerializedName("id") val id: Int,
    @SerializedName("common_name") val nombre: String,
    @SerializedName("default_image") val imagen: ImagenPlanta,
    @SerializedName("cycle") val tipo: String

)

data class ImagenPlanta(
    @SerializedName("original_url") val urlImagen: String
)