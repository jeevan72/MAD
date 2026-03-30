package com.example.myapplication1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val display = findViewById<TextView>(R.id.display)
        val Edt = findViewById<EditText>(R.id.editTextText)

        val btn9 = findViewById<Button>(R.id.btn9)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnEq = findViewById<Button>(R.id.btnEq)
        val btnClear = findViewById<Button>(R.id.button4)

        var op = ""
        var firstValue = 0.0
        var secondValue = 0.0
        var result = 0.0

        // Number buttons
        btn9.setOnClickListener {
            Edt.append("9")
        }

        btn8.setOnClickListener {
            Edt.append("8")
        }

        // Operator button
        btnPlus.setOnClickListener {

            if (Edt.text.toString().isNotEmpty()) {
                firstValue = Edt.text.toString().toDouble()
                op = "+"
                Edt.text.clear()
            }

        }

        // Equals button
        btnEq.setOnClickListener {

            if (Edt.text.toString().isNotEmpty()) {

                secondValue = Edt.text.toString().toDouble()

                result = when (op) {
                    "+" -> firstValue + secondValue
                    else -> 0.0
                }

                display.text = result.toString()
                Edt.text.clear()
            }
        }

        // Clear button
        btnClear.setOnClickListener {
            Edt.text.clear()
            display.text = ""
            firstValue = 0.0
            secondValue = 0.0
            result = 0.0
            op = ""
        }
    }
}
