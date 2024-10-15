package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentInput: String = ""
    private var operator: String = ""
    private var firstNumber: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)
        setNumberButtonListeners()
        setOperatorButtonListeners()
    }

    // Gán sự kiện cho các nút số
    private fun setNumberButtonListeners() {
        val numberButtons = listOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
            R.id.button8, R.id.button9
        )

        val listener = { v: Button ->
            currentInput += v.text.toString()
            display.text = currentInput
        }

        for (id in numberButtons) {
            findViewById<Button>(id).setOnClickListener { listener(it as Button) }
        }
    }

    // Gán sự kiện cho các nút toán tử
    private fun setOperatorButtonListeners() {
        val operatorButtons = listOf(
            R.id.buttonPlus, R.id.buttonMinus, R.id.buttonMultiply, R.id.buttonDivide
        )

        val operatorListener = { v: Button ->
            if (currentInput.isNotEmpty()) {
                firstNumber = currentInput.toDouble()
                operator = v.text.toString()
                currentInput = ""
            }
        }

        for (id in operatorButtons) {
            findViewById<Button>(id).setOnClickListener { operatorListener(it as Button) }
        }

        // Xử lý nút "="
        findViewById<Button>(R.id.buttonEquals).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                val secondNumber = currentInput.toDouble()
                val result = calculate(firstNumber, secondNumber, operator)
                display.text = result.toString()
                currentInput = result.toString() // Lưu kết quả vào currentInput
            }
        }

        // Xử lý nút "C" để xóa hết
        findViewById<Button>(R.id.buttonClear).setOnClickListener {
            currentInput = ""
            firstNumber = 0.0
            operator = ""
            display.text = "0"
        }

        // Xử lý nút "BS" (Backspace)
        findViewById<Button>(R.id.buttonBackspace).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                currentInput = currentInput.dropLast(1)
                display.text = if (currentInput.isEmpty()) "0" else currentInput
            }
        }
    }

    private fun calculate(firstNumber: Double, secondNumber: Double, operator: String): Double {
        return when (operator) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "x" -> firstNumber * secondNumber
            "/" -> firstNumber / secondNumber
            else -> 0.0
        }
    }
}
