package com.plantas.garden.config

import com.plantas.garden.servicio.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val URL = "https://perenual.com/api/species-list?key=sk-IyRE677af620c93278155"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}