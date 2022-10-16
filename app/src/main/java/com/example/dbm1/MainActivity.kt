package com.example.dbm1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val detail1 = findViewById<TextView>(R.id.food_detail1)
        val detail2 = findViewById<TextView>(R.id.food_detail2)
        val detail3 = findViewById<TextView>(R.id.food_detail3)
        val detail4 = findViewById<TextView>(R.id.food_detail4)
        val detail5 = findViewById<TextView>(R.id.food_detail5)
        val detailList = listOf<TextView>(detail1,detail2,detail3,detail4,detail5)

        val btnMin1 = findViewById<Button>(R.id.button_minus1)
        val btnMin2 = findViewById<Button>(R.id.button_minus2)
        val btnMin3 = findViewById<Button>(R.id.button_minus3)
        val btnMin4 = findViewById<Button>(R.id.button_minus4)
        val btnMin5 = findViewById<Button>(R.id.button_minus5)
        val btnMinList = listOf<TextView>(btnMin1,btnMin2,btnMin3,btnMin4,btnMin5)

        val btnPlus1 = findViewById<Button>(R.id.button_plus1)
        val btnPlus2 = findViewById<Button>(R.id.button_plus2)
        val btnPlus3 = findViewById<Button>(R.id.button_plus3)
        val btnPlus4 = findViewById<Button>(R.id.button_plus4)
        val btnPlus5 = findViewById<Button>(R.id.button_plus5)
        val btnPlusList = listOf<TextView>(btnPlus1,btnPlus2,btnPlus3,btnPlus4,btnPlus5)

        val totalItem1 = findViewById<TextView>(R.id.totalItem1)
        val totalItem2 = findViewById<TextView>(R.id.totalItem2)
        val totalItem3 = findViewById<TextView>(R.id.totalItem3)
        val totalItem4 = findViewById<TextView>(R.id.totalItem4)
        val totalItem5 = findViewById<TextView>(R.id.totalItem5)
        val totalItemList = listOf<TextView>(totalItem1,totalItem2,totalItem3,totalItem4,totalItem5)

        val DescriptionList = listOf<String>("salad dengan dressing kacang wijen dan berbagai ingredients enak lainnya",
        "nasi goreng dengan dressing ayam dan berbagai ingredients enak lainnya",
        "burger dengan dressing ham dan berbagai ingredients enak lainnya",
        "Air putih segar yang nikmat", "Teh enak yang segar dan nikmat")

        val PriceList = listOf<Int>(55000,15000,50000,15000,15000)
        val NameList = listOf<String>("Salad Bowl", "Nasi Goreng", "Burger", "Aqua", "Tea")
        var counterList = mutableListOf<Int>(0,0,0,0,0)

        val checkout_total = findViewById<TextView>(R.id.checkouttotal)
        val total_price_all = findViewById<TextView>(R.id.total_price_all)
        var total_all_price = 0

        for(i in 0..4){
            btnMinList[i].setOnClickListener{
                var tmp_total = 0
                if(counterList[i] > 0){
                    counterList[i] = counterList[i] - 1
                    totalItemList[i].text = counterList[i].toString()
                    checkout_total.text = "Total : " + counterList.sum().toString() + " Pesanan"
                    for(i in 0..4){
                        tmp_total += counterList[i] * PriceList[i]
                    }
                    total_price_all.text = "Rp. " + tmp_total.toString()
                    total_all_price = tmp_total
                }
            }

            btnPlusList[i].setOnClickListener{
                var tmp_total = 0
                counterList[i] = counterList[i] + 1
                totalItemList[i].text = counterList[i].toString()
                checkout_total.text = "Total : " + counterList.sum().toString() + " Pesanan"
                for(i in 0..4){
                    tmp_total += counterList[i] * PriceList[i]
                }
                total_price_all.text = "Rp. " + tmp_total.toString()
                total_all_price = tmp_total
            }
            detailList[i].setOnClickListener{
                val intent = Intent(this, saladbowl()::class.java)
                intent.putExtra("description",DescriptionList[i])
                intent.putExtra("price", PriceList[i])
                intent.putExtra("foodName", NameList[i])
                intent.putExtra("totalItem", counterList[i])
                startActivity(intent)
            }
        }

        var OrderNum = intent.getIntExtra("OrderNum", 0)
        val checkout = findViewById<Button>(R.id.checkoutBtn)
        val ShowOrder = findViewById<TextView>(R.id.order_num)
        val resetOrder = findViewById<TextView>(R.id.reset_order)
        resetOrder.setOnClickListener{
            OrderNum = 0
            ShowOrder.text = OrderNum.toString()
        }
        ShowOrder.text = OrderNum.toString()
        checkout.setOnClickListener{
            var addedItem = ArrayList<String>()
            var addedName = ArrayList<String>()
            var addedPrice = ArrayList<String>()
            for(i in 0..4){
                if(counterList[i] != 0){
                    addedName.add(NameList[i])
                    addedPrice.add(PriceList[i].toString())
                    addedItem.add(counterList[i].toString())
                }
            }

            var previousState = ArrayList<String>()
            for(item in counterList){
                previousState.add(item.toString())
            }
            val intent = Intent(this, Checkout::class.java)
            intent.putExtra("OrderNum",OrderNum)
            intent.putExtra("totalItem", counterList.sum())
            intent.putExtra("totalPriceAll", total_all_price)
            intent.putStringArrayListExtra("previousState", previousState)
            intent.putStringArrayListExtra("arrayName", addedName)
            intent.putStringArrayListExtra("arrayPrice", addedPrice)
            intent.putStringArrayListExtra("arrayTotal", addedItem)
            startActivity(intent)
            finish()
        }

    }

}