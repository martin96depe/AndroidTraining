package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.TrainingIntroTheme

class ComposeQuadrantMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingIntroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Row (Modifier.weight(1f)){
                            BaseComponent(
                                title = stringResource(id = R.string.title_top_left),
                                body = stringResource(id = R.string.text_top_left),
                                color = Color.Green,
                                weight = 1f
                            )
                            BaseComponent(
                                title = stringResource(id = R.string.title_top_right),
                                body = stringResource(id = R.string.text_top_right),
                                color = Color.Yellow,
                                weight = 1f
                            )
                        }
                        Row (Modifier.weight(1f)){
                            BaseComponent(
                                title = stringResource(id = R.string.title_bottom_left),
                                body = stringResource(id = R.string.text_bottom_left),
                                color = Color.Cyan,
                                weight = 1f
                            )
                            BaseComponent(
                                title = stringResource(id = R.string.title_bottom_right),
                                body = stringResource(id = R.string.text_bottom_right),
                                color = Color.LightGray,
                                weight = 1f
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RowScope.BaseComponent(
    title: String,
    body: String,
    color: Color,
    weight: Float
) {
    Box(
        Modifier
            .weight(weight)
            .background(color)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(text = body, textAlign = TextAlign.Justify, color = Color.Black)
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    TrainingIntroTheme {
        Column {
            Row (Modifier.weight(1f)){
                BaseComponent(
                    title = stringResource(id = R.string.title_top_left),
                    body = stringResource(id = R.string.text_top_left),
                    color = Color.Green,
                    weight = 1f
                )
                BaseComponent(
                    title = stringResource(id = R.string.title_top_right),
                    body = stringResource(id = R.string.text_top_right),
                    color = Color.Yellow,
                    weight = 1f
                )
            }
            Row (Modifier.weight(1f)){
                BaseComponent(
                    title = stringResource(id = R.string.title_bottom_left),
                    body = stringResource(id = R.string.text_bottom_left),
                    color = Color.Cyan,
                    weight = 1f
                )
                BaseComponent(
                    title = stringResource(id = R.string.title_bottom_right),
                    body = stringResource(id = R.string.text_bottom_right),
                    color = Color.LightGray,
                    weight = 1f
                )
            }
        }

    }
}