package com.strongbulb.fixheaderhorizontalscrollrecyclerview

import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_content.view.*
import java.util.*

/**
 * Created by JeonGuKang on 2019-10-01.
 */

class ItemContentViewHolder(view: View, var itemScrollData: ItemScrollData) : RecyclerView.ViewHolder(view) {

    private val scrollObserver : ScrollObserver
    private var onScrollChangedListener: ViewTreeObserver.OnScrollChangedListener = ViewTreeObserver.OnScrollChangedListener {
        if (itemScrollData.position == adapterPosition) {
            itemScrollData.onScroll(itemView.item_horizontal_scroll.scrollX)
        }
    }

    init {
        this.scrollObserver = ScrollObserver()
        itemView.item_horizontal_scroll.viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener)
        this.itemScrollData.addObserver(scrollObserver)
        itemView.item_horizontal_scroll.setOnTouchListener{ _, event ->
            if (MotionEvent.ACTION_DOWN == event.action) {
                itemScrollData.position = adapterPosition
            }
            false
        }
    }

    fun bindView() {
        itemView.item_horizontal_scroll.post{ itemView.item_horizontal_scroll.scrollX = itemScrollData.scrollData.x }
    }

    inner class ScrollObserver : Observer {
        override fun update(p0: Observable?, p1: Any?) {
            itemView.item_horizontal_scroll.post{itemView.item_horizontal_scroll.scrollX = itemScrollData.scrollData.x}
        }
    }
}