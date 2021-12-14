package com.gmail.eamosse.imdb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gmail.eamosse.idbdata.data.Category
import com.gmail.eamosse.idbdata.data.MoviesList
import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.MoviesListItemBinding

class MoviesListAdapter(private val items: List<MoviesList>,private val thirdPage: OnPagesListener2) :
    RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {
    class OnPagesListener2(val thirdPage: (meme: MoviesList) -> Unit) {
        fun onClick(meme: MoviesList) = thirdPage(meme)
    }
    inner class ViewHolder(private val binding: MoviesListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MoviesList) {
            val context = binding.moviesListImg
            binding.item = item
            Glide.with(context)
                .load(item.poster_path)
                .into(context)
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