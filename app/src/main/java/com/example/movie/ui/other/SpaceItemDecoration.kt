package com.example.movie.ui.other

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecoration(
    private val spanCount: Int,
    private val spacing: Int,
    private val includeEdge: Boolean,
    private val headerNum: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        val position = parent.getChildAdapterPosition(view) - headerNum
        when {
            position >= 0 -> {
                val column = position % spanCount
                if (!includeEdge) {
                    outRect.left = column * spacing / spanCount
                    outRect.right = spacing - (column + 1) * spacing / spanCount
                    if (position >= spanCount) {
                        outRect.top = spacing
                    }
                } else {
                    outRect.left = spacing - column * spacing / spanCount
                    outRect.right = (column + 1) * spacing / spanCount
                    if (position < spanCount) {
                        outRect.top = spacing
                    }
                    outRect.bottom = spacing
                }
            }
            else -> {
                outRect.left = 0
                outRect.right = 0
                outRect.top = 0
                outRect.bottom = 0
            }
        }
    }
}