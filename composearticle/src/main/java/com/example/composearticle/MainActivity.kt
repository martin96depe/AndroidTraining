package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.TrainingIntroTheme

class MainActivity : ComponentActivity() {
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
                        HeaderImage()
                        ArticleTitle(title = stringResource(id = R.string.article_title))
                        ArticleSection1(
                            sectionText = stringResource(id = R.string.article_section_1)
                        )
                        ArticleSection2(
                            sectionText = stringResource(id = R.string.article_section_2)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderImage() {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        Modifier
            .fillMaxWidth()
    )
}

@Composable
fun ArticleTitle(title: String){
    Text(
        text = title,
        Modifier.padding(16.dp),
        fontSize = 24.sp
    )
}

@Composable
fun ArticleSection1(sectionText : String){
    Text(
        text = sectionText,
        Modifier.padding(start = 16.dp, end = 16.dp),
        textAlign = Justify
    )
}

@Composable
fun ArticleSection2(sectionText: String){
    Text(
        text = sectionText,
        Modifier.padding(16.dp),
        textAlign = Justify
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    TrainingIntroTheme {
        Column {
            HeaderImage()
            ArticleTitle(title = stringResource(id = R.string.article_title))
            ArticleSection1(
                sectionText = stringResource(id = R.string.article_section_1)
            )
            ArticleSection2(
                sectionText = stringResource(id = R.string.article_section_2)
            )
        }
        
    }
}