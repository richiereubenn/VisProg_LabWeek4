package com.example.visprog_labweek4.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_labweek4.R
import com.example.visprog_labweek4.data.dummy_data
import com.example.visprog_labweek4.model.Explore
import com.example.visprog_labweek4.model.categories
import com.example.visprog_labweek4.data.DataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreIGView(explore : List<Explore>){
    var search by rememberSaveable { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(bottom = 50.dp)
        ) {
            item(span = {GridItemSpan(3)}){
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    label = {
                        Row {
                            Icon(Icons.Filled.Search, contentDescription = null, tint = Color.White)
                            Text(text = "search", color = Color.White)
                        }
                            },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.White,
                        focusedBorderColor = Color.White,
                        textColor = Color.White,
                        cursorColor = Color.White
                    )
                )
            }
            items(explore){
                ImageView(it)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(12.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(painter = painterResource(id = R.drawable.home), contentDescription = "Post", modifier = Modifier.size(27.dp))
            Image(painter = painterResource(id = R.drawable.search), contentDescription = "Post", modifier = Modifier.size(27.dp))
            Image(painter = painterResource(id = R.drawable.post), contentDescription = "Post", modifier = Modifier.size(27.dp))
            Image(painter = painterResource(id = R.drawable.reels), contentDescription = "Reels", modifier = Modifier.size(27.dp))
            Image(painter = painterResource(id = R.drawable.account), contentDescription = "Account", modifier = Modifier.size(27.dp))
        }
    }
}

@Composable
fun ImageView(explore: Explore) {
    Image(
        painter = painterResource(id = getImage(fileName = explore.image_path)),
        contentDescription = "Hai",
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxSize()
            .padding(1.dp),
        contentScale = ContentScale.FillHeight
    )
}

@Composable
fun getImage(fileName: String): Int{
    val context = LocalContext.current
    val resourceId = remember(fileName){
        context.resources.getIdentifier(
            fileName,
            "drawable",
            context.packageName
        )
    }
    return resourceId
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExploreIGPreview(){
    ExploreIGView(DataSource().loadExplore())
}