package com.example.dbm1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter3(private val data: ArrayList<Order>): RecyclerView.Adapter<ViewHolder3>(){
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder3 {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder3(inflater, parent)
    }

    override fun onBindViewHolder(holder: ViewHolder3, position: Int) {
        holder.bind(data[position])
    }
}