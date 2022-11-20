package com.dcode.challangechapter6.network

import com.dcode.challangechapter6.model.responseProductItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfullAPI {
    @GET("products.json?rating_less_than=3.7")
    fun getAllCar(): Call<List<responseProductItem>>

    @GET("products.json?rating_greater_than=4.5")
    fun favoriteCar(): Call<List<responseProductItem>>
}