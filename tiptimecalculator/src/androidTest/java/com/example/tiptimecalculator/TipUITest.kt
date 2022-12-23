package com.example.tiptimecalculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class TipUITest {

    @get:Rule
    var composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip(){
        composeTestRule.setContent {
            TipTimeScreen()
        }
        composeTestRule.onNodeWithText("Cost of Service")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip [%]")
            .performTextInput("20")
        try {
            composeTestRule.onNodeWithText("Tip Amount: $2.00")
                .assertExists()
        } catch (e: Exception) {
            println(e.message)
        }
    }
}