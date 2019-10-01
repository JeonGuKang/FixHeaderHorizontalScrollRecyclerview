package com.strongbulb.fixheaderhorizontalscrollrecyclerview

import java.util.*

/**
 * Created by JeonGuKang on 2019-10-01.
 */
class ItemScrollData : Observable() {
    var position : Int = -1
    val scrollData: ScrollData
    init {
        scrollData = ScrollData()
    }

    class ScrollData {
        var x = 0
    }

    fun onScroll(x: Int) {
        scrollData.x = x
        setChanged() //Inherited from Observable()
        notifyObservers(scrollData) //Inherited from Observable()
    }

}