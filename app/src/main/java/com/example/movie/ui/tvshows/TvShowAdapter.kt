package com.example.movie.ui.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movie.R
import com.example.movie.data.TvShow
import com.example.movie.databinding.ItemsTvShowBinding
import com.example.movie.ui.detail.DetailMovieActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listTvShow = ArrayList<TvShow>()

    fun setTvShow(tvShow: List<TvShow>?) {

        when (tvShow) {
            null -> return
            else -> {
                this.listTvShow.clear()

                this.listTvShow.addAll(tvShow)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding = ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {

        val tvShow = listTvShow[position]

        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size

    class TvShowViewHolder(private val binding: ItemsTvShowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TvShow) {

            with(binding) {

                tvItemTitle.text = tvShow.title

                tvItemUserScore.text = tvShow.userScore

                Glide.with(itemView.context)
                        .load(tvShow.image)
                        .centerCrop()
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_image_search)
                                .error(R.drawable.ic_broken_image_gray))
                        .into(imgTvShow)

                itemView.setOnClickListener {

                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)

                    intent.putExtra(DetailMovieActivity.EXTRA_TV, tvShow.id)

                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}