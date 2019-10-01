package com.strongbulb.fixheaderhorizontalscrollrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by JeonGuKang on 2019-10-01.
 */

class CustomAdpater : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val itemScrollData = ItemScrollData()
    val arrayList = arrayListOf<Item>()

    data class Item(val index: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemContentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false), itemScrollData)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemContentViewHolder).bindView(arrayList[position])
    }

    fun setList(arrayList: ArrayList<Item>){
        this.arrayList.addAll(arrayList)
        notifyDataSetChanged()
    }
}