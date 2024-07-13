package com.example.routetask.domain.repo

import com.example.routetask.domain.model.Product

interface ProductsRepository {

    suspend fun getAllProducts(): List<Product?>?
}