package com.soshdevelopment.stocksapp.presenter.screens.addfavouritestock.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.soshdevelopment.stocksapp.data.model.StockModel
import com.soshdevelopment.stocksapp.databinding.ItemFavouriteStockBinding
import timber.log.Timber

class AddFavouriteStockRecyclerViewAdapter : ListAdapter<StockModel, AddFavouriteStockViewHolder>(AddFavouriteStockDiffer) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddFavouriteStockViewHolder {
        return AddFavouriteStockViewHolder(
            ItemFavouriteStockBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AddFavouriteStockViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

class AddFavouriteStockViewHolder(
    private val binding: ItemFavouriteStockBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: StockModel) {
        binding.tvTitle.text = item.symbol
        Timber.d("on bind")
    }
}

object AddFavouriteStockDiffer: DiffUtil.ItemCallback<StockModel>() {
    override fun areItemsTheSame(oldItem: StockModel, newItem: StockModel): Boolean {
        return oldItem.symbol == newItem.symbol
    }

    // compare contents
    override fun areContentsTheSame(oldItem: StockModel, newItem: StockModel): Boolean {
        return oldItem == newItem
    }
}