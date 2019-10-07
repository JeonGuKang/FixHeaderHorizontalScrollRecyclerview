package com.strongbulb.fixheaderhorizontalscrollrecyclerview

import java.util.*

/**
 * Created by JeonGuKang on 2019-10-01.
 */
class ItemScrollData : Observable() {
    var position : Int = -1
    val scrollData: ScrollData

    data class ScrollData (var x : Int = 0)

    init {
        scrollData = ScrollData()
    }

    fun onScroll(x: Int) {
        scrollData.x = x
        setChanged()
        notifyObservers(scrollData)
    }
}