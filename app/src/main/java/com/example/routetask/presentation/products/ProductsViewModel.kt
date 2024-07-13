package com.example.routetask.presentation.products

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routetask.domain.model.Product
import com.example.routetask.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(UiSate(false,emptyList()))
    val uiState: StateFlow<UiSate> = _uiState.asStateFlow()

    init {
        getProducts()
    }

     private fun getProducts(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _uiState.update {
                    it.copy(
                        isLoading = true
                    )
                }
                val result =  getProductsUseCase()
                Log.d("ProductsViewModel", "getProducts: $result")
                _uiState.update {
                    it.copy(
                        products = result,
                        isLoading = false
                    )
                }
            }catch (e: Exception){
                _uiState.update {
                    it.copy(
                        isLoading = false
                    )
                }
            }
        }
    }

}

data class UiSate(
    val isLoading: Boolean = false,
    val products: List<Product?>?
)