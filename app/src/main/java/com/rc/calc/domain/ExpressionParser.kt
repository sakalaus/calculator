package com.rc.calc.domain

import java.lang.Character.isDigit

class ExpressionParser(private val calculation: String) {
    fun parse(): List<ExpressionPart> {
        var i = 0
        val result = mutableListOf<ExpressionPart>()
        while (i < calculation.length) {
            val currChar = calculation[i]
            when {
                currChar in operationSymbols -> result.add(
                    ExpressionPart.Op(
                        getOperationFromSymbol(
                            currChar
                        )
                    )
                )
                currChar in "()" -> parseParentheses(currChar, result)
                currChar.isDigit() -> {
                    i = parseDigit(startingIndex = i, result = result)
                    continue
                }
            }
            i++
        }
        return result
    }

    private fun parseDigit(startingIndex: Int, result: MutableList<ExpressionPart>): Int {
        var i = startingIndex
        val resultingString = buildString {
            while (i < calculation.length && calculation[i].isDigitOrDot()) {
                append(calculation[i])
                i++
            }
        }
        result.add(ExpressionPart.Number(resultingString.toDouble()))
        return i
    }

    private fun parseParentheses(currChar: Char, result: MutableList<ExpressionPart>) {
        result.add(
            ExpressionPart.Parentheses(
                type = when (currChar) {
                    '(' -> ParenthesesType.Opening
                    ')' -> ParenthesesType.Closing
                    else -> throw IllegalArgumentException("Wrong parentheses symbol")
                }
            )
        )
    }
}

private fun Char.isDigitOrDot(): Boolean = this.isDigit() || this == '.'
