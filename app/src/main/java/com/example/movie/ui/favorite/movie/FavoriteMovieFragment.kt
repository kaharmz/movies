package com.example.movie.ui.favorite.movie


import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.databinding.FragmentFavoriteMovieBinding
import com.example.movie.ui.favorite.FavoriteViewModel
import com.example.movie.ui.other.SpaceItemDecoration
import com.example.movie.ui.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteMovieFragment : DaggerFragment() {

    private lateinit var favoriteMovieBinding: FragmentFavoriteMovieBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var favoriteMovieAdapter: FavoriteMovieAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        favoriteMovieBinding =
            FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return favoriteMovieBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemTouchHelper.attachToRecyclerView(favoriteMovieBinding.rvFavMovie)
        if (activity != null) {
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
            favoriteMovieAdapter = FavoriteMovieAdapter()
            favoriteMovieBinding.progressBar.visibility = View.VISIBLE
            viewModel.getListFavoriteMovie().observe(this, { favoriteMovie ->
                if (favoriteMovie != null) {
                    favoriteMovieBinding.progressBar.visibility = View.GONE
                    favoriteMovieAdapter.submitList(favoriteMovie)
                }
            })
            with(favoriteMovieBinding.rvFavMovie) {
                val space = resources.getDimensionPixelSize(R.dimen.space_margin)
                val decoration = SpaceItemDecoration(2, space, true, 0)
                when (this.resources.configuration?.orientation) {
                    Configuration.ORIENTATION_PORTRAIT -> this.layoutManager =
                        GridLayoutManager(context, 2)
                    else -> this.layoutManager = GridLayoutManager(context, 4)
                }
                favoriteMovieBinding.rvFavMovie.addItemDecoration(decoration)
                setHasFixedSize(true)
                adapter = favoriteMovieAdapter
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
        ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder,
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipePosition = viewHolder.adapterPosition
                val favoriteMovie = favoriteMovieAdapter.getSwipedData(swipePosition)
                favoriteMovie?.let { viewModel.setFavoriteMovie(it) }
                val snackbar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) {
                    favoriteMovie?.let { viewModel.setFavoriteMovie(it) }
                }
                snackbar.show()
            }
        }
    })
}