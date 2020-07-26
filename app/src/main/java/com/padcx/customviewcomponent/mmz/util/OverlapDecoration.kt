package com.padcx.customviewcomponent.mmz.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
class OverlapDecoration : RecyclerView.ItemDecoration() {
    private val horizontalOverlap = -90
    private var itemPosition:Int=0
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        itemPosition= parent.getChildAdapterPosition(view);
        if (itemPosition == 0) { return; }
        outRect.set(horizontalOverlap, 0, 0, 0);
      // super.getItemOffsets(outRect, view, parent, state)
    }
}