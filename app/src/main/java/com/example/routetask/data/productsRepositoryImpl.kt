package com.example.routetask.data

import com.example.routetask.data.dto.toDomain
import com.example.routetask.data.network.WebServices
import com.example.routetask.domain.model.Product
import com.example.routetask.domain.repo.ProductsRepository
import javax.inject.Inject

class productsRepositoryImpl @Inject constructor(private val webServices: WebServices)
    : ProductsRepository {
    override suspend fun getAllProducts(): List<Product?>? {
        return webServices.getAllProducts().products?.map {
            it?.toDomain()
        }
    }
}