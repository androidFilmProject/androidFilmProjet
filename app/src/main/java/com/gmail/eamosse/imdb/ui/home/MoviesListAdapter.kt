package com.gmail.eamosse.imdb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.idbdata.data.MoviesList
import com.gmail.eamosse.imdb.databinding.MoviesListItemBinding

class MoviesListAdapter(private val items: List<MoviesList>,private val thirdPage: OnPagesListener2) :
    RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {
    class OnPagesListener2(val thirdPage: (meme: MoviesList) -> Unit) {
        fun onClick(meme: MoviesList) = thirdPage(meme)
    }
    inner class ViewHolder(private val binding: MoviesListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MoviesList) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(MoviesListItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            thirdPage.onClick(items[position])
        }
        holder.bind(items[position])
    }
}