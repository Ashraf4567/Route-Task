package com.example.routetask.data.dto

import com.example.routetask.domain.model.Product

fun ProductDto.toDomain(): Product {
    return Product(
        images = this.images,
        thumbnail = this.thumbnail,
        minimumOrderQuantity = this.minimumOrderQuantity,
        rating = this.rating,
        returnPolicy = this.returnPolicy,
        description = this.description,
        weight = this.weight,
        warrantyInformation = this.warrantyInformation,
        title = this.title,
        tags = this.tags,
        discountPercentage = this.discountPercentage,
        reviews = this.reviews?.map { it?.toDomain() },
        price = this.price,
        meta = this.meta?.toDomain(),
        shippingInformation = this.shippingInformation,
        id = this.id,
        availabilityStatus = this.availabilityStatus,
        category = this.category,
        stock = this.stock,
        sku = this.sku,
        brand = this.brand,
        dimensions = this.dimensions?.toDomain()
    )
}

fun Dimensions.toDomain(): com.example.routetask.domain.model.Dimensions {
    return com.example.routetask.domain.model.Dimensions(
        depth = this.depth,
        width = this.width,
        height = this.height
    )
}

fun Meta.toDomain(): com.example.routetask.domain.model.Meta {
    return com.example.routetask.domain.model.Meta(
        createdAt = this.createdAt,
        qrCode = this.qrCode,
        barcode = this.barcode,
        updatedAt = this.updatedAt
    )
}

fun ReviewsItem.toDomain(): com.example.routetask.domain.model.ReviewsItem {
    return com.example.routetask.domain.model.ReviewsItem(
        date = this.date,
        reviewerName = this.reviewerName,
        reviewerEmail = this.reviewerEmail,
        rating = this.rating,
        comment = this.comment
    )
}