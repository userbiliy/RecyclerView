package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(list: ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val mList = list

    private var createCount = 0
    private var bindCount = 0

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.v("userbiliy", "onCreateViewHolder:${++createCount}")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.v("userbiliy", "onBindViewHolder:${++bindCount} --${position+1}")
        mList[position].apply {
            holder.textView.text = this
        }
    }
}