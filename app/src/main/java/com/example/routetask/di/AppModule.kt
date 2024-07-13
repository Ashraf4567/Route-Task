package com.example.routetask.di

import com.example.routetask.data.productsRepositoryImpl
import com.example.routetask.domain.repo.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideProductsRepo(repo: productsRepositoryImpl): ProductsRepository
}