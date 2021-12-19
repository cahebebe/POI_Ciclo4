package net.procesamos.poi

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("POIs")
    fun getPOIs(): Call<MutableList<POIsModels>>
}