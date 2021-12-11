package com.gmail.eamosse.imdb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.MoviesList
import com.gmail.eamosse.imdb.databinding.MoviesListItemBinding

class MoviesListAdapter(private val items: List<MoviesList>) :
    RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

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
        holder.bind(items[position])
    }
}