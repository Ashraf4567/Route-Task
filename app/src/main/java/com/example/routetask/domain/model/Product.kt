package com.example.routetask.domain.model

data class Product(
	val images: List<String?>? = null,
	val thumbnail: String? = null,
	val minimumOrderQuantity: Int? = null,
	val rating: Double? = null,
	val returnPolicy: String? = null,
	val description: String? = null,
	val weight: Int? = null,
	val warrantyInformation: String? = null,
	val title: String? = null,
	val tags: List<String?>? = null,
	val discountPercentage: Double? = null,
	val reviews: List<ReviewsItem?>? = null,
	val price: Double? = null,
	val meta: Meta? = null,
	val shippingInformation: String? = null,
	val id: Int? = null,
	val availabilityStatus: String? = null,
	val category: String? = null,
	val stock: Int? = null,
	val sku: String? = null,
	val brand: String? = null,
	val dimensions: Dimensions? = null
)

data class Dimensions(
	val depth: Double? = null,
	val width: Double? = null,
	val height: Double? = null
)

data class Meta(
	val createdAt: String? = null,
	val qrCode: String? = null,
	val barcode: String? = null,
	val updatedAt: String? = null
)

data class ReviewsItem(
	val date: String? = null,
	val reviewerName: String? = null,
	val reviewerEmail: String? = null,
	val rating: Int? = null,
	val comment: String? = null
)

