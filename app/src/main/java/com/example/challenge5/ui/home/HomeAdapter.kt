package com.example.challenge5.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challenge5.databinding.MovieItemBinding
import com.example.challenge5.models.Data

class HomeAdapter(private val movies: List<Data>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(private var binding: MovieItemBinding, val movies: List<Data>) :
        RecyclerView.ViewHolder(binding.root) {
        private val imageBase = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie: Data){
            binding.tvMovieTitle.text = movie.title
            binding.tvReleaseDate.text = movie.releaseDate
            binding.tvRating.text = movie.rating.toString()
            Glide.with(itemView.context).load(imageBase + movie.posterPath).into(binding.ivMoviePoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding, movies)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }
}