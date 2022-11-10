package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.AndroidGreen
import com.example.businesscard.ui.theme.TrainingIntroTheme

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
                    BusinessCard()
                }
            }
        }
    }
}

// Composable fun to display the entire business card
@Composable
fun BusinessCard() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // first element composed by column[image text text] - weight 70%?
        BusinessCardHeader(
            imageResource = R.drawable.android_logo,
            fullName = "Martin De Pellegrini",
            jobTitle = "Android Developer",
            modifier = Modifier
        )
        //second element composed by column[elem1, elem2, elem3] - weight 30%? ps add separator between elements
        BusinessCardInfo(
            ic1 = R.drawable.ic_phone_black_24dp,
            info1 = "+00 111 222 3333",
            ic2 = R.drawable.ic_outdoor_grill_black_24dp,
            info2 = "professional griller",
            ic3 = R.drawable.ic_alternate_email_black_24dp,
            info3 = "grill.brother@hotgrill.com",
            modifier = Modifier
        )
    }
}

@Composable
fun ColumnScope.BusinessCardHeader(
    imageResource: Int,
    fullName: String,
    jobTitle: String,
    modifier: Modifier
) {
    val image = painterResource(id = imageResource)
    Box(modifier = modifier.weight(1f), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,
                Modifier
                    .size(136.dp)
            )
            Text(
                text = fullName,
                color = Color.White,
                fontSize = 34.sp
            )
            Text(
                text = jobTitle,
                Modifier.padding(top = 8.dp),
                color = AndroidGreen,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ColumnScope.BusinessCardInfo(
    ic1: Int,
    info1: String,
    ic2: Int,
    info2: String,
    ic3: Int,
    info3: String,
    modifier: Modifier
) {
    Column(modifier = modifier.padding(bottom = 8.dp)) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(AndroidGreen)
            .padding(8.dp))
        BaseDetailInfo(iconResource = ic1, info = info1, modifier = modifier)
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(AndroidGreen)
            .padding(8.dp))
        BaseDetailInfo(iconResource = ic2, info = info2, modifier = modifier)
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(AndroidGreen)
            .padding(8.dp))
        BaseDetailInfo(iconResource = ic3, info = info3, modifier = modifier)
    }
}

@Composable
fun BaseDetailInfo(iconResource: Int, info: String, modifier: Modifier) {
    val icon = painterResource(id = iconResource)
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Icon(painter = icon, contentDescription = null,
        tint = AndroidGreen, modifier = modifier
                .padding(top = 8.dp, bottom = 8.dp, start = 24.dp)
                .size(36.dp))
        Text(text = info, modifier = modifier
            .padding(top = 8.dp, bottom = 8.dp, end = 24.dp)
            .weight(1f), textAlign = TextAlign.End, color = Color.White)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrainingIntroTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            BusinessCard()
        }
    }
}