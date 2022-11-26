package com.rc.calc.domain

import ExpressionEvaluator
import org.junit.Assert.assertEquals
import org.junit.Test

class ExpressionEvaluatorTest{
    private lateinit var evaluator: ExpressionEvaluator

    @Test
    fun `Simple expression properly processed`(){
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(3.0),
                ExpressionPart.Op(Operation.MULTIPLY),
                ExpressionPart.Number(4.0),
                ExpressionPart.Op(Operation.SUBTRACT),
                ExpressionPart.Number(0.5),
            )
        )
        val actualValue = evaluator.evaluate()
        val expectedValue = 11.5

        assertEquals(expectedValue, actualValue, 0.0)
    }

    @Test
    fun `Expression with parentheses properly processed`(){
        evaluator = ExpressionEvaluator(
            listOf(
                ExpressionPart.Number(0.5),
                ExpressionPart.Op(Operation.MULTIPLY),
                ExpressionPart.Parentheses(ParenthesesType.Opening),
                ExpressionPart.Number(3.0),
                ExpressionPart.Op(Operation.ADD),
                ExpressionPart.Number(4.0),
                ExpressionPart.Parentheses(ParenthesesType.Closing)
            )
        )
        val actualValue = evaluator.evaluate()
        val expectedValue = 3.6 // fail on purpose

        assertEquals(expectedValue, actualValue, 0.0)
    }
}