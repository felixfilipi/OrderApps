package com.example.dbm1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OrderDone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_done)
        val OrderNum = intent.getIntExtra("OrderNum", 0)
        val orderAgain = findViewById<TextView>(R.id.OrderAgain)
        orderAgain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("OrderNum", OrderNum + 1)
            startActivity(intent)
            finish()
        }
    }
}