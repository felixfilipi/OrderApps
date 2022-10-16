package com.example.dbm1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class saladbowl  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val price = intent.getStringExtra("price")
        val foodName = intent.getStringExtra("foodName")
        val counter = intent.getBundleExtra("counter")
        val description = intent.getStringExtra("description")

        setContentView(R.layout.activity_saladbowl)
        val food_desc = findViewById<TextView>(R.id.food_desc)
        val food_image = findViewById<ImageView>(R.id.food_image)
        val food_name = findViewById<TextView>(R.id.food_name)
        val food_price = findViewById<TextView>(R.id.food_price)

        food_desc.text = description
        food_name.text = foodName
        food_price.text = price

        if(foodName == "Nasi Goreng"){
            food_image.setImageResource(R.drawable.nasigoreng)
        }else if(foodName == "Salad Bowl"){
            food_image.setImageResource(R.drawable.gettyimages_1293479617)
        }else if(foodName == "Burger"){
            food_image.setImageResource(R.drawable.burger)
        }else if(foodName == "Aqua"){
            food_image.setImageResource(R.drawable.aqua)
        }else if(foodName == "Tea"){
            food_image.setImageResource(R.drawable.liptontea)
        }

        val back = findViewById<TextView>(R.id.back_button)
        back.setOnClickListener{
            val intent = Intent(this, MainActivity()::class.java)
            intent.putExtra("prevState",counter)
            startActivity(intent)
        }

    }

}