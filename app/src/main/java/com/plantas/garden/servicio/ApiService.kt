package com.plantas.garden.servicio

import com.plantas.garden.modelo.PlantaRespuesta
import retrofit2.http.GET

interface ApiService {


    @GET("/species-list")
    suspend fun getPlants() : PlantaRespuesta
}