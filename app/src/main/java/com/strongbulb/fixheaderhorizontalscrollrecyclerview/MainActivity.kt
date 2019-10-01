package com.strongbulb.fixheaderhorizontalscrollrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val adapter = CustomAdpater()
    val testDataSize = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setTestData()
    }

    private fun initView() {
        (main_rv as RecyclerView).apply {
            itemAnimator = null
            layoutManager = LinearLayoutManager(context)
            adapter = this@MainActivity.adapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        this@MainActivity.adapter.itemScrollData.position = -1
                    }

                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

                    }
                })
        }
    }

    fun setTestData() {
        val arrayList = arrayListOf<CustomAdpater.Item>()
        for(i in 0 until testDataSize) {
            arrayList.add(CustomAdpater.Item(i))
        }
        adapter.setList(arrayList)
    }
}
