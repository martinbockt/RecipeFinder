package com.example.recipefinder.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.recipefinder.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipefinder.model.Recipepreview
import com.example.recipefinder.ui.components.Hero

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Slider(recipepreview: Recipepreview) {
    val sliderList = listOf(recipepreview,recipepreview,recipepreview)
    val pagerState = rememberPagerState(initialPage = 1)

    Box {
        HorizontalPager(
            pageCount = sliderList.size,
            state = pagerState
            ) {page ->
            Box {
//                Hero(sliderList[page])
            }
        }
        Row(
            Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(R.drawable.logo_simple),
                contentDescription = "Logo",
                modifier = Modifier.width(30.dp)
            )
            Icon(Icons.Rounded.ShoppingCart, contentDescription = "test")
        }
    }
}