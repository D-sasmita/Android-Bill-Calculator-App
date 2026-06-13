package com.example.billcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etBillNo = findViewById<EditText>(R.id.etBillNo)
        val etQuantity = findViewById<EditText>(R.id.etQuantity)
        val etPrice = findViewById<EditText>(R.id.etPrice)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        val tvServiceTax = findViewById<TextView>(R.id.tvServiceTax)
        val tvTotalPayble = findViewById<TextView>(R.id.tvTotalPayble)
        btnCalculate.setOnClickListener {
            val billNo = etBillNo.text.toString()
            val quantity = etQuantity.text.toString()
            val price = etPrice.text.toString()
            if (billNo.isEmpty() || quantity.isEmpty() || price.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else {
                val total = quantity.toDouble() * price.toDouble()
                val serviceTax = total * 0.12
                val totalPayble = total + serviceTax
                tvTotal.text = "Total Amount: $total"
                tvServiceTax.text = "Service Tax: $serviceTax"
                tvTotalPayble.text = "Total Payble: $totalPayble"
            }
        }
    }
}