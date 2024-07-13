package com.example.routetask.presentation.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.routetask.databinding.ProductItemBinding
import com.example.routetask.domain.model.Product

class ProductsAdapter(var productsList: List<Product?>?): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    class ViewHolder(val item: ProductItemBinding): RecyclerView.ViewHolder(item.root){
        fun bind(product: Product?){
            item.product = product
            item.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ProductItemBinding
            .inflate(LayoutInflater.from(parent.context) , parent , false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = productsList?.size?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productsList!![position]
        holder.bind(item)
    }



    fun bindProducts(list: List<Product?>?) {
        productsList = list
        notifyDataSetChanged()
    }



}