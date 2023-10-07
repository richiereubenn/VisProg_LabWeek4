package com.example.visprog_labweek4.ui.theme.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_labweek4.R
import com.example.visprog_labweek4.data.dummy_data
import com.example.visprog_labweek4.model.line_chat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListChatView(chatList: List<line_chat>){
    Column(
    ) {
        NavBar()
        LazyVerticalGrid(
            columns = GridCells.Fixed(1)
        ){
            items(chatList){
                Chat(it)
            }
        }
    }

}

@Composable
fun Chat(chat:line_chat){
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 15.dp)
            .clickable {
                Toast.makeText(context, "${chat.name}, clicked", Toast.LENGTH_SHORT).show()
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = chat.chat,
            modifier = Modifier
                .size(60.dp)
        )
        Column (
            modifier = Modifier
                .weight(1f)
                .padding(start = 5.dp),
        ){
            Text(
                text = chat.name,
                fontSize = 15.sp,
                fontWeight =FontWeight.Bold
            )
            Text(
                text = chat.chat,
                fontSize = 15.sp,
                fontWeight =FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Text(
            text = chat.date,
            fontSize = 15.sp,
            fontWeight =FontWeight.Normal
        )

    }
}


@Composable
fun NavBar(){
    Column(
        modifier = Modifier.background(Color(0xFF58FF55))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Chats",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_more_vert_24),
                contentDescription = "menu",
                modifier = Modifier.size(30.dp, 30.dp),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListChatViewPreview(){
    ListChatView(dummy_data().get_data_line())
}