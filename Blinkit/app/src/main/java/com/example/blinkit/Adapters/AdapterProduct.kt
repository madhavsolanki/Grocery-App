package com.example.blinkit.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.models.SlideModel
import com.example.blinkit.classes.FilteringProduct
import com.example.blinkit.databinding.ItemViewProductBinding
import com.example.blinkit.models.Product


class AdapterProduct(
    val onAddBtnClick: (Product, ItemViewProductBinding) -> Unit,
    val onIncrementClick: (Product, ItemViewProductBinding) -> Unit,
    val onDecrementClick: (Product, ItemViewProductBinding) -> Unit
) : RecyclerView.Adapter<AdapterProduct.ViewHolder>(), Filterable{
    class ViewHolder(val binding: ItemViewProductBinding): RecyclerView.ViewHolder(binding.root){

    }

    val diffUtil = object : DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.productId == newItem.productId
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemViewProductBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = differ.currentList[position]

        holder.binding.apply {
            val imageList = ArrayList<SlideModel>()

            val productImage = product.productImageUris

            for(i in 0 until productImage?.size!!){
                imageList.add(SlideModel(product.productImageUris!![i].toString()))
            }

            ivImageSlider.setImageList(imageList)

            tvProductTitle.text = product.productName

            val quantity = product.productQuantity.toString() + product.productUnit
            tvProductQuantity.text = quantity

            tvProductPrice.text = "₹"+product.productPrice

            if(product.itemCount!! > 0){
                tvProductCount.text = product.itemCount.toString()
                tvAdd.visibility = View.GONE
                llProductCount.visibility = View.VISIBLE
            }else{
                tvAdd.visibility = View.VISIBLE
                llProductCount.visibility = View.GONE
            }

            tvAdd.setOnClickListener{
                onAddBtnClick(product, this)
            }

            tvIncrementCount.setOnClickListener{
                onIncrementClick(product, this)
            }

            tvDecrementCount.setOnClickListener{
                onDecrementClick(product, this)
            }
        }

    }

    val filter: FilteringProduct? = null
    var originalList = ArrayList<Product>()

    override fun getFilter(): Filter {
        if(filter==null) return FilteringProduct(this, originalList)
        else return filter
    }
}