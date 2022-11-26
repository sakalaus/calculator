package com.rc.calc.domain

enum class Operation(val symbol: Char) {
    Addition('+'),
    Subtraction('-'),
    Multiplication('*'),
    Division('/'),
    Percentage('%')
}

val operationSymbols = Operation.values().map  { operation ->
    operation.symbol.toChar() }


fun getOperationFromSymbol(symbol: Char) = Operation.values().firstOrNull{
    it.symbol == symbol
} ?: throw IllegalArgumentException("Wrong operation symbol")
