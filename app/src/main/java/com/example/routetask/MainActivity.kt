package com.example.routetask

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.routetask.databinding.ActivityMainBinding
import com.example.routetask.presentation.products.ProductsAdapter
import com.example.routetask.presentation.products.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ProductsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val adapter = ProductsAdapter(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.uiState.collect{
                adapter.bindProducts(it.products)

                binding.progressBar.visibility = if (it.isLoading) View.VISIBLE else View.GONE

            }
        }
    }

    private fun initViews() {
        binding.productsRecycler.adapter = adapter
    }
}