package com.example.movie.ui.favorite.tvshow


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
import com.example.movie.databinding.FragmentFavoriteTvShowBinding
import com.example.movie.ui.favorite.FavoriteViewModel
import com.example.movie.ui.other.SpaceItemDecoration
import com.example.movie.ui.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class FavoriteTvShowFragment : DaggerFragment() {

    private lateinit var favoriteTvShowBinding: FragmentFavoriteTvShowBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var favoriteTvShowAdapter: FavoriteTvShowAdapter

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        favoriteTvShowBinding =
            FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return favoriteTvShowBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemTouchHelper.attachToRecyclerView(favoriteTvShowBinding.rvFavTvShow)
        if (activity != null) {
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
            favoriteTvShowAdapter = FavoriteTvShowAdapter()
            favoriteTvShowBinding.progressBar.visibility = View.VISIBLE
            viewModel.getListFavoriteTv().observe(this, { favoriteTv ->
                if (favoriteTv != null) {
                    favoriteTvShowBinding.progressBar.visibility = View.GONE
                    favoriteTvShowAdapter.submitList(favoriteTv)
                }
            })
            with(favoriteTvShowBinding.rvFavTvShow) {
                val space = resources.getDimensionPixelSize(R.dimen.space_margin)
                val decoration = SpaceItemDecoration(4, space, true, 1)
                when (this.resources.configuration.orientation) {
                    Configuration.ORIENTATION_PORTRAIT -> this.layoutManager =
                        GridLayoutManager(context, 1)
                    else -> this.layoutManager = GridLayoutManager(context, 2)
                }
                favoriteTvShowBinding.rvFavTvShow.addItemDecoration(decoration)
                setHasFixedSize(true)
                adapter = favoriteTvShowAdapter
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
                val favoriteTv = favoriteTvShowAdapter.getSwipeData(swipePosition)
                favoriteTv?.let { viewModel.setFavoriteTv(it) }
                val snackbar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) {
                    favoriteTv?.let { viewModel.setFavoriteTv(it) }
                }
                snackbar.show()
            }
        }
    })
}