package com.rc.calc.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.rc.calc.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)
    lateinit var viewModel: CalculatorViewModel

    @Before
    fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun enterExpression_correctResultAppears() {
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("x").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("=").performClick()
        composeRule.onNodeWithText("7.0").assertIsDisplayed()
    }
}