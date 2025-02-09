package com.gmail.eamosse.imdb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.imdb.databinding.CategoryListItemBinding
import java.util.*

class CategoryAdapter(private val items: List<Category> ,private val secondPage: OnPagesListener) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class OnPagesListener(val secondPage: (meme: Category) -> Unit) {
        fun onClick(meme: Category) = secondPage(meme)
    }
    inner class ViewHolder(private val binding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CategoryListItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            secondPage.onClick(items[position])
        }
        holder.bind(items[position])

    }
}