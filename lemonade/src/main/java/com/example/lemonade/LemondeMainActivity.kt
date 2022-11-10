package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.TrainingIntroTheme

class LemondeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingIntroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier){
    var imageResource by remember {
        mutableStateOf(R.drawable.lemon_tree)
    }

    var desc by remember {
        mutableStateOf(R.string.lemon_tree_desc)
    }

    var tapCounter by remember {
        mutableStateOf(0)
    }

    var maxTap by remember {
        mutableStateOf(2)
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        if (desc == 0) {
            Text(text = "Unknown")
        } else {
            Text(text = stringResource(id = desc))
        }
        Spacer(modifier = Modifier.height(16.dp))
        /*Button(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
            , onClick = { *//*TODO*//* }) {
            Image(
                painter = painterResource(id = R.drawable.lemon_tree),
                contentDescription = stringResource(id = R.string.lemon_tree),
                modifier = Modifier.wrapContentSize(Alignment.Center).background(color = Color.White)
            )
        }*/
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(id = R.string.lemon_tree),
            modifier = Modifier
                .clickable {
                    imageResource = when(imageResource){
                        R.drawable.lemon_tree -> {
                            maxTap = (2..4).random()
                            R.drawable.lemon_squeeze
                        }
                        R.drawable.lemon_squeeze -> {
                            if (tapCounter == maxTap){
                                tapCounter = 0
                                R.drawable.lemon_drink
                            }else{
                                tapCounter++
                                R.drawable.lemon_squeeze
                            }
                        }
                        R.drawable.lemon_drink -> R.drawable.lemon_restart
                        else -> R.drawable.lemon_tree
                    }
                    desc = when(imageResource){
                        R.drawable.lemon_tree -> R.string.lemon_tree_desc
                        R.drawable.lemon_squeeze -> R.string.squeeze_lemon_desc
                        R.drawable.lemon_drink -> R.string.lemonade_desc
                        R.drawable.lemon_restart -> R.string.empity_glass_desc
                        else -> 0
                    }
                }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrainingIntroTheme {
        LemonadeApp(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        )
    }
}