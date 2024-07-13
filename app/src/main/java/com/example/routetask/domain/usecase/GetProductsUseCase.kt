package com.example.routetask.domain.usecase

import com.example.routetask.domain.repo.ProductsRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductsRepository
) {
    suspend operator fun invoke() = productRepository.getAllProducts()
}