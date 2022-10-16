package com.example.dbm1

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder3(inflater: LayoutInflater, parent: ViewGroup)
    : RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_view_checkout, parent, false)) {

    private var foodTitle : TextView? = null
    private var foodPrice : TextView? = null
    private var totalItem : TextView? = null
    private var totalPrice : TextView? = null

    init{
        foodTitle = itemView.findViewById<TextView>(R.id.food_title)
        foodPrice = itemView.findViewById<TextView>(R.id.food_price)
        totalItem = itemView.findViewById<TextView>(R.id.totalItem)
        totalPrice = itemView.findViewById<TextView>(R.id.totalPrice)
    }

    fun bind(data: Order){
        foodTitle?.text = data.txtTitle
        totalItem?.text = "(x" + data.total.toString() + ")"
        foodPrice?.text = "Rp " + data.price.toString()
        totalPrice?.text = "Rp " + (data.price * data.total).toString()
    }
}