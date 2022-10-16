package com.example.dbm1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class Checkout : AppCompatActivity() {
    lateinit var recyclerView3: RecyclerView
    lateinit var adapter3: MyAdapter3
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val orderNum = intent.getIntExtra("OrderNum", 0)
        val totalItem = intent.getIntExtra("totalItem", 0)
        val totalAllPrice = intent.getIntExtra("totalPriceAll", 0)

        val order = findViewById<Button>(R.id.order)
        val back_btn = findViewById<TextView>(R.id.back_button)
        val show_order = findViewById<TextView>(R.id.order_num)
        show_order.text = "Pesanan No." + orderNum.toString()

        back_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        initRV()
        recyclerView3.layoutManager = LinearLayoutManager(this)
        recyclerView3.adapter = adapter3

        val a = (1..10).shuffled().last()
        val b = (1..10).shuffled().last()
        val captchaText = a.toString() + " x " + b.toString() + " = "
        val captcha = findViewById<TextView>(R.id.captcha)
        val captcha_answer = findViewById<EditText>(R.id.captcha_answer)
        captcha.text = captchaText

        val orderTotal = findViewById<TextView>(R.id.order_total)
        orderTotal.text = "Jumlah Pesanan: " + totalItem
        val priceTotal = findViewById<TextView>(R.id.price_total)
        priceTotal.text = "Rp " + totalAllPrice
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        order.setOnClickListener{
            val answer = Integer.valueOf(captcha_answer.getText().toString())
            if(answer == a*b){
                val intent = Intent(this, OrderDone::class.java)
                intent.putExtra("OrderNum", orderNum)
                startActivity(intent)
                finish()
            }
        }

    }

    private fun initRV(){
        recyclerView3 = findViewById(R.id.orderRecyclerView)

        val data = ArrayList<Order>()
        val arrayFoodName = intent.getStringArrayListExtra("arrayName")
        val arrayFoodPrice = intent.getStringArrayListExtra("arrayPrice")
        val arrayFoodTotal = intent.getStringArrayListExtra("arrayTotal")
        val size = arrayFoodPrice!!.size - 1
        for(i in 0..size){
            data.add(Order(arrayFoodName!![i], arrayFoodTotal!![i].toInt(), arrayFoodPrice!![i].toInt()))
        }

        adapter3 = MyAdapter3(data)
    }
}