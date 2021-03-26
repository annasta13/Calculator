package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorMain : AppCompatActivity() {
    private var numberToCount: ArrayList<String> = ArrayList()
    private var shouldClear: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun joinNumber() {
        val buffer = StringBuilder()
        for (element in numberToCount) {
            buffer.append(element)
        }
        updateDisplay(buffer.toString())
    }

    fun clearClick(view: View) {
        numberToCount.clear()
        updateDisplay("");
    }

    fun calculate() {
        val calculator = StringCalculator()
        val answer = calculator.formulateCalculation(numberToCount)
        updateDisplay(answer)
        shouldClear = true
    }


    fun equalsClick(view: View) {
        calculate()
    }

    fun numberClick(view: View) {
        if (shouldClear) {
            numberToCount.clear()
        }
        shouldClear = false
        val button = view as Button
        val value = button.text.toString()
        numberToCount.add(value)
        joinNumber()
    }

    fun updateDisplay(display: String) {
        val mainTextView = findViewById<TextView>(R.id.textView)
        mainTextView.text = display
    }
}