package com.example.visprog_labweek4.ui.theme.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_labweek4.R
import com.example.visprog_labweek4.data.dummy_data
import com.example.visprog_labweek4.model.categories
import com.example.visprog_labweek4.model.line_chat
import com.example.visprog_labweek4.model.products

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TokopediaView(categories : List<categories>, products : List<products>){
    Column {
        NavBarTokopedia()
        Image(
            painter = painterResource(id = R.drawable.promo1),
            contentDescription = "promo",
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = "Categories",
            style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )
        LazyRow(
            modifier = Modifier.padding(start = 20.dp),
            content = {
                items(categories) {
                    Card1(it)
                }
            }
        )
        Text(
            text = "Products",
            style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )
        LazyVerticalGrid(
            modifier = Modifier.padding(horizontal = 20.dp),
            columns = GridCells.Fixed(2)
        ){
            items(products){
                Card2(it)
            }
        }
    }

}

@Composable
fun Card1(category:categories) {
    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .shadow(4.dp, shape = RoundedCornerShape(16.dp)),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            Image(
                painter = painterResource(id = category.image_path),
                contentDescription = "Movie image",
                modifier = Modifier
                    .size(100.dp)
            )
            Text(
                text = category.category_name,
                modifier = Modifier.padding(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${category.number_of_items} Produccts",
                modifier = Modifier.padding(),
            )
        }
    }
}

@Composable
fun Card2(product:products) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(horizontal = 10.dp)
            .padding(bottom = 20.dp)
            .shadow(4.dp, shape = RoundedCornerShape(16.dp)),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier.padding(15.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,

                ) {
                Image(
                    painter = painterResource(id = product.image_path),
                    contentDescription = "Movie image",
                    modifier = Modifier
                        .size(120.dp)
                )
                Text(
                    text = product.product_name,
                    modifier = Modifier.padding(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Rp. ${product.price.toString()}",
                    modifier = Modifier.padding(top = 2.dp),
                    textAlign = TextAlign.Left
                )
                Text(
                    text = product.location,
                    modifier = Modifier.padding(top = 2.dp),
                    textAlign = TextAlign.Left
                )
                Text(
                    text = "${product.sold.toString()} sold",
                    modifier = Modifier.padding(top = 2.dp),
                    textAlign = TextAlign.Left
                )
            }
        }

    }
}

@Composable
fun NavBarTokopedia(){
    Column(
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Tokopedia",
                style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_more_vert_black),
                contentDescription = "menu",
                modifier = Modifier.size(30.dp, 30.dp),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TokopediaViewPreview(){
    val categoryList = dummy_data().get_data_tokopedia_category()
    val productList = dummy_data().get_data_tokopedia_product()

    TokopediaView(
        categories = categoryList,
        products = productList
    )
}