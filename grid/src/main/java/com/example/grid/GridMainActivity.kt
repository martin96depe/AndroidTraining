package com.example.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grid.data.DataSource
import com.example.grid.model.Topic
import com.example.grid.ui.theme.TrainingIntroTheme

class GridMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingIntroTheme {
                TopicGrid(topicList = DataSource.topics)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicGrid(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), modifier = Modifier.fillMaxWidth()) {
        items(topicList) { topic: Topic ->
            TopicCard(topic = topic)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(8.dp).height(68.dp).fillMaxWidth(), elevation = 4.dp) {
        Row {
            Image(
                painter = painterResource(id = topic.imageResId),
                contentDescription = stringResource(
                    id = topic.titleResId
                ),
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)
            )
            Column {
                Text(
                    text = stringResource(id = topic.titleResId),
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp/*,
                        end = 16.dp*/
                    ),
                    style = MaterialTheme.typography.body2
                )
                Row(
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp)
                        //colorFilter = ColorFilter.tint(Color.Black)
                    )
                    Text(
                        text = topic.topicId.toString(),
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun TopicCardPreview() {
    TopicCard(topic = Topic(R.drawable.architecture, R.string.architecture, 58))
}

@Preview
@Composable
fun TopicGridPreview() {
    TopicGrid(topicList = DataSource.topics)
}