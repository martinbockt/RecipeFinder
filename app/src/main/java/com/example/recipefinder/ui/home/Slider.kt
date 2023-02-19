package com.example.recipefinder.ui.home

import android.animation.TypeConverter
import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.recipefinder.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipefinder.data.RecipeModel
import com.example.recipefinder.ui.components.Hero
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Slider(sliderList: List<RecipeModel>, navigateTo: (String) -> Unit) {
    val pagerState = rememberPagerState(initialPage = 0)

//    val coroutineScope = rememberCoroutineScope()
//
//    DisposableEffect(Unit) {
//        val tickerChannel = ticker(delayMillis = 500, initialDelayMillis = 0)
//        val tickerJob = coroutineScope.launch {
//            for (event in tickerChannel) {
//                if (pagerState.currentPage == 2) {
//                    pagerState.scrollToPage(pagerState.currentPage + 1)
//                } else {
//                    pagerState.scrollToPage(pagerState.currentPage + 1)
//                }
//            }
//        }
//
//        onDispose {
//            tickerJob.cancel()
//            tickerChannel.cancel()
//        }
//    }


    Box {
        HorizontalPager(
            pageCount = sliderList.size,
            state = pagerState
            ) {page ->
//            animatableState.value = page - 1f
            Box(
                modifier = Modifier.clickable {
                    navigateTo("recipe/${sliderList[page].id}")
                }
            ) {
                Hero(sliderList[page])
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(R.drawable.logo_simple),
                contentDescription = "Logo",
                modifier = Modifier.width(30.dp)
            )
            Row() {
                CustomLoadingBar((pagerState.currentPage + 1).toFloat())
                Spacer(modifier = Modifier.width(4.dp))
                CustomLoadingBar((pagerState.currentPage).toFloat())
                Spacer(modifier = Modifier.width(4.dp))
                CustomLoadingBar((pagerState.currentPage - 1).toFloat())
            }
        }
    }
}

@Composable
fun CustomLoadingBar(
    targetProgress: Float,
    barColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = Color.LightGray
) {
    val progress = remember { Animatable(0f) }
    LaunchedEffect(targetProgress) {
        progress.animateTo(targetProgress, animationSpec = tween(100))
    }

    Box(
        modifier = Modifier
            .width(20.dp)
            .height(3.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(backgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progress.value)
                .height(4.dp)
                .background(barColor)
                .clip(shape = RoundedCornerShape(20.dp))
        )
    }
}
