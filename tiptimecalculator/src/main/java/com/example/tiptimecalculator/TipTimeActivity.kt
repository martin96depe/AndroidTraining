package com.example.tiptimecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiptimecalculator.ui.theme.TrainingIntroTheme
import java.text.NumberFormat

class TipTimeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeScreen()
        }
    }
}

@Composable
fun TipTimeScreen(){
    var amountInput by remember {
        mutableStateOf("")
    }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    var tipPercent by remember {
        mutableStateOf(15.0)
    }
    val tip = calculateTip(amount, tipPercent)
    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)  //add a space of 8dp between every composable in the column
    ) {
        Text(
            text = stringResource(id = R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        EditNumberField(
            value = amountInput,
            onValueChange = { amountInput = it }
        )
        Spacer(modifier = Modifier.height(24.dp))
        EditTipPercentage(
            tipPercent = tipPercent,
            onValueChange = { tipPercent = it.toDoubleOrNull() ?: 0.0 },
            onDecrement = { tipPercent -= 5 },
            onIncrement = { tipPercent += 5 }
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.tip_amount, tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun EditNumberField(
    value : String,
    onValueChange : (String) -> Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = R.string.cost_of_service)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun EditTipPercentage(
    tipPercent : Double,
    onValueChange: (String) -> Unit,
    onDecrement: () -> Unit,
    onIncrement: () -> Unit
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = onDecrement, modifier = Modifier.weight(1f)) {
            Text(text = stringResource(id = R.string.decrement_by_n, "5"))
        }
        OutlinedTextField(
            value = tipPercent.toString(),
            onValueChange = onValueChange,
            label = { Text(text = "Tip Percentage [%]") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.weight(2f)
        )
        Button(onClick = onIncrement, modifier = Modifier.weight(1f)) {
            Text(text = stringResource(id = R.string.increment_by_n, "5"))
        }
    }
}

private fun calculateTip(
    amount: Double,
    tipPercent: Double = 15.0
) : String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrainingIntroTheme {
        TipTimeScreen()
    }
}