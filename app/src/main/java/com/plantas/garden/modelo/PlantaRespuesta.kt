package com.plantas.garden.modelo

import com.google.gson.annotations.SerializedName

data class PlantaRespuesta(
    @SerializedName("data") val plantas: List<Plantas>
)