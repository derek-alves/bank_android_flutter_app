package com.bank.app_android.ui.components

import android.util.Log
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.distinctUntilChanged

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomCarousel(
    modifier: Modifier = Modifier,
    composable: List<@Composable () -> Unit>,

    state: PagerState = rememberPagerState(),
    positionCallback: (position: Int) -> Unit
) {
    HorizontalPager(pageCount = composable.size, state = state) {
        Log.d("components", composable.size.toString())
        composable[it]()
//        Image(
//            painter = painterResource(id = drawables[it]),
//            contentDescription = "Bank images",
//            modifier = modifier
//                .fillMaxHeight(0.5f)
//                .fillMaxWidth()
//                .graphicsLayer {
//
//                    val pageOffset = (
//                            (state.currentPage - it) + state
//                                .currentPageOffsetFraction
//                            ).absoluteValue
//
//
//                    alpha = lerp(
//                        start = 0.5f,
//                        stop = 1f,
//                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                    )
//                }
//        )
    }

    LaunchedEffect(state) {
        snapshotFlow { state.currentPage }
            .distinctUntilChanged()
            .collect { index ->
                positionCallback.invoke(index)
            }
    }
}

@Composable
fun DotIndicator(size: Int, position: Int, modifier: Modifier = Modifier) {

    LazyRow(
        modifier = modifier

            .wrapContentHeight()
    ) {
        items(size) {
            val indicatorSize by animateIntAsState(
                targetValue = if (position == it) 50 else 8,
                animationSpec = tween(500)
            )
            Row() {
                Box(
                    modifier = modifier
                        .height(8.dp)
                        .width(indicatorSize.dp)
                        .clip(CircleShape)
                        .background(if (position == it) Color.White else Color.Gray)
                )
                Spacer(modifier = modifier.width(6.dp))
            }

        }
    }
}