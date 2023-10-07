package com.example.visprog_labweek4.ui.theme.view

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_labweek4.R
import com.example.visprog_labweek4.data.dummy_data
import com.example.visprog_labweek4.model.Story
import com.example.visprog_labweek4.data.DataSource
import com.example.visprog_labweek4.model.Feed
import com.example.visprog_labweek4.model.Suggestion
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeIGView(story: List<Story>, feed: List<Feed>, suggestion: List<Suggestion>) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(horizontal = 10.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_dark),
                    contentDescription = "Halo"
                )
                Spacer(modifier = Modifier.width(160.dp))
                Image(painter = painterResource(id = R.drawable.like), contentDescription = "Message")
                Spacer(modifier = Modifier.width(10.dp))
                Image(painter = painterResource(id = R.drawable.dm), contentDescription = "like")
            }
            LazyRow(
                modifier = Modifier.padding(start = 5.dp),
                content = {
                    items(story) {
                        Story(it)
                    }
                }
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                    itemsIndexed(feed) { index, item ->
                        Feed(item)
                        if (index == feed.size - 1) {
                            Column {
                                Spacer(modifier = Modifier.height(75.dp))
                            }
                        }
                        if (index == 0 || (index + 1) % 7 == 0) {
                            LazyRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                            ) {
                                items(suggestion) {
                                    Suggestion(it)
                                }
                            }
                        }
                    }
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(12.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Post",
                modifier = Modifier
                    .size(27.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Home", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Post",
                modifier = Modifier
                    .size(27.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Search", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.post),
                contentDescription = "Post",
                modifier = Modifier
                    .size(27.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Upload", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.reels),
                contentDescription = "Reels",
                modifier = Modifier
                    .size(27.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Reels", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.account),
                contentDescription = "Account",
                modifier = Modifier
                    .size(27.dp)
                    .clickable {
                        Toast
                            .makeText(context, "My Account", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
        }
    }
}

@Composable
fun Feed(feed: Feed) {
    val context = LocalContext.current
    var isCaptionExpanded by remember { mutableStateOf(false) }

    val likeCount = feed.like
    val formattedLikeCount = if (likeCount > 1) {
        val numberFormat = NumberFormat.getNumberInstance(Locale.US)
        numberFormat.format(likeCount) + " likes"
    } else {
        likeCount.toString() + " like"
    }

    val dateFormat = SimpleDateFormat("yyyy", Locale.getDefault())
    val currentYear = dateFormat.format(Date())
    val formattedDate = if (feed.date.substring(0, 4) == currentYear) {
        SimpleDateFormat("MMMM d", Locale.getDefault()).format(SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(feed.date)) ?: feed.date
    } else {
        SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()).format(SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(feed.date)) ?: feed.date
    }

    val textSplit = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = Bold)){
            append(feed.name)
        }
        append("  ")
        withStyle(style = SpanStyle(fontWeight = Normal)){
            append(feed.caption)
        }
    }
    val maxLines = if (isCaptionExpanded) Int.MAX_VALUE else 2


    val like = if(feed.like_active == true){
        R.drawable.liked
    }else{
        R.drawable.like
    }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp)
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = getImage(fileName = feed.pic_path)),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(40.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = feed.name,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                )

            }
            Image(
                painter = painterResource(id = R.drawable.baseline_more_vert_24),
                contentDescription = "p"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = getImage(fileName = feed.content_path)),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
            ,
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp)
                .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = like),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Like Button", Toast.LENGTH_SHORT)
                            .show()
                    },
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.comment),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Comment Button", Toast.LENGTH_SHORT)
                            .show()
                    },
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.messanger),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Send Button", Toast.LENGTH_SHORT)
                            .show()
                    },
            )
            Spacer(modifier = Modifier.width(220.dp))
            Image(
                painter = painterResource(id = R.drawable.save),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Save Button", Toast.LENGTH_SHORT)
                            .show()
                    },
            )
        }
        Text(
            text = formattedLikeCount,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start,
                color = Color.White
            ),
            modifier = Modifier.padding(start = 13.dp, top = 8.dp, bottom = 1.dp)
        )
        Text(
            text = textSplit,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start,
                color = Color.White
            ),
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 13.dp)
                .clickable {
                    isCaptionExpanded = !isCaptionExpanded
                }
        )
        Text(
            text = formattedDate,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start,
                color = Color.Gray,
                fontSize = 13.sp
            ),
            modifier = Modifier.padding(start = 13.dp, top = 1.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun Story(story: Story) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = getImage(fileName = story.image_path)),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .border(7.dp, Color.Black, shape = CircleShape)
                    .clip(shape = CircleShape)
                    .size(35.dp),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.story),
                contentDescription = "story",
                modifier = Modifier
                    .size(130.dp)
                    .clickable {
                        Toast
                            .makeText(context, "${story.name} story", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = story.name,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        )
    }
}

@Composable
fun Suggestion(suggest: Suggestion){
    Card(
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
        border =  BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.Black)
                .padding(15.dp)
        ) {
            Box(
                contentAlignment = Alignment.TopEnd,
            ){
                Image(
                    painter = painterResource(id = getImage(fileName = suggest.pic_path)),
                    contentDescription = null,
                    modifier = Modifier
                        .background(Color.Black)
                        .clip(shape = CircleShape)
                        .size(130.dp),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = "Close"
                )
            }
            Text(
                text = suggest.name,
                modifier = Modifier.padding(vertical = 5.dp),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            )
            Button(
                onClick = {

                },
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .width(100.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1976D2)
                )
            ) {
                Text(
                    text = "Follow",
                    style = TextStyle(Color.Black),
                )

            }
        }

    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeIGPreview() {
    val storyList = DataSource().loadStory()
    val feedList = DataSource().loadFeed()
    val suggesList = DataSource().loadSuggestion()

    HomeIGView(
        story = storyList,
        feed = feedList,
        suggestion = suggesList
    )
}