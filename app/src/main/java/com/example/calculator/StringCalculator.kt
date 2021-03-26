package com.example.calculator

class StringCalculator {
    private var shouldJoinFirstNumber = true
    private var operation: String = ""
    private var firstNumberValue: Int = 0
    private var secondNumberValue: Int = 0
    private var firstNumber: ArrayList<String> = ArrayList()
    private var secondNumber: ArrayList<String> = ArrayList()
    private var charIndex = 0
    fun formulateCalculation(numberToCount: List<String>): String {
        numberToCount.forEach { token ->
            charIndex++
            when {
                token.equals("+")
                        || token.equals("/")
                        || token.equals("*")
                        || token.equals("-") -> {
                    shouldJoinFirstNumber = false
                    operation = token
                }
                else -> {
                    if (shouldJoinFirstNumber) {
                        firstNumber.add(token)
                        firstNumberValue = joinNumber(firstNumber)
                    } else {
                        secondNumber.add(token)
                        secondNumberValue = joinNumber(secondNumber)
                    }
                }
            }
            if (charIndex == numberToCount.size) operateCalculation()
        }
        return firstNumberValue.toString()
    }

    private fun operateCalculation() {
        when (operation) {
            "-" -> firstNumberValue -= secondNumberValue
            "/" -> firstNumberValue /= secondNumberValue
            "*" -> firstNumberValue *= secondNumberValue
            "+" -> firstNumberValue += secondNumberValue
        }
    }

    fun joinNumber(firstNumber: ArrayList<String>): Int {
        val buffer = StringBuilder()
        for (element in firstNumber) {
            buffer.append(element)
        }
        return buffer.toString().toInt()
    }
}
