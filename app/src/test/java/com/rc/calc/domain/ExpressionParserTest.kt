package com.rc.calc.domain

import org.junit.Assert.*
import org.junit.Test

class ExpressionParserTest{

    private lateinit var parser: ExpressionParser

    @Test
    fun `Basic expression is properly parsed`(){
        parser = ExpressionParser("4-3*2")
        val parts = parser.parse()
        val expected = listOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(operation = Operation.Subtraction),
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(operation = Operation.Multiplication),
            ExpressionPart.Number(2.0)
        )
        assertEquals(expected, parts)
    }

    @Test
    fun `Expression with parentheses is properly parsed`(){
        parser = ExpressionParser("(4.5-3)*2")
        val parts = parser.parse()
        val expected = listOf(
            ExpressionPart.Parentheses(ParenthesesType.Opening),
            ExpressionPart.Number(4.5),
            ExpressionPart.Op(operation = Operation.Subtraction),
            ExpressionPart.Number(3.0),
            ExpressionPart.Parentheses(ParenthesesType.Closing),
            ExpressionPart.Op(operation = Operation.Multiplication),
            ExpressionPart.Number(2.0)
        )
        assertEquals(expected, parts)
    }

}