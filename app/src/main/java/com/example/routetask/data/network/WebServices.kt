package com.example.routetask.data.network

import com.example.routetask.data.dto.ProductsResponse
import retrofit2.http.GET

interface WebServices {
    @GET("products")
    suspend fun getAllProducts(): ProductsResponse
}