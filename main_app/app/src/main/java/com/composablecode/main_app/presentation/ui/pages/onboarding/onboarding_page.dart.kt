//package com.bank.app_android.ui.pages.onboarding
//
//import androidx.compose.animation.*
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Card
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.ExperimentalTextApi
//import androidx.compose.ui.text.SpanStyle
//import androidx.compose.ui.text.buildAnnotatedString
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.withStyle
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.bank.app_android.R
//import com.bank.app_android.ui.components.CustomCarousel
//import com.bank.app_android.ui.components.DotIndicator
//import com.bank.app_android.ui.theme.orangeGradient
//
//@OptIn(
//    ExperimentalTextApi::class, ExperimentalFoundationApi::class,
//    ExperimentalAnimationApi::class
//)
//@Composable
//fun OnBoardingPage(modifier: Modifier = Modifier) {
//
//        val currentIndex = rememberSaveable { mutableStateOf(0) }
//        val phrases = listOf(
//            "Don’t worry about your payment, all process are instant and secured",
//            "Easy saving features are built to help you calculate and manage money",
//            "We provide financing products to help you utilize bills and purchases"
//        )
//        val drawables =
//            listOf(R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3)
//
//
//        Column(verticalArrangement = Arrangement.Bottom) {
//            CustomCarousel(drawables = drawables) {
//                currentIndex.value = it
//            }
//            Column(modifier = modifier.padding(24.dp)) {
//                Title()
//                Spacer(modifier = modifier.height(16.dp))
//                Descriptions(phrases= phrases,currentIndex = currentIndex.value)
//                Spacer(modifier = modifier.height(12.dp))
//                DotIndicator(
//                    size = drawables.size,
//                    position = currentIndex.value,
//                    modifier = modifier
//                )
//                Spacer(modifier = modifier.height(42.dp))
//                Buttons(modifier)
//            }
//
//        }
//
//    }
//
//
//
//@OptIn(ExperimentalAnimationApi::class)
//@Composable
//private fun Descriptions(phrases: List<String>, currentIndex:Int){
//    AnimatedContent(targetState = currentIndex, content = { index ->
//        Text(
//            phrases[index],
//            style = MaterialTheme.typography.subtitle1,
//            textAlign = TextAlign.Start
//        )
//    }, transitionSpec = {
//        slideInHorizontally(
//            animationSpec = tween(1000),
//            initialOffsetX = {
//                -it
//            }) with slideOutHorizontally(
//            animationSpec = tween(100),
//            targetOffsetX = {
//                it
//            })
//    })
//}
//@Composable
//private fun Buttons(modifier: Modifier) {
//    Card(
//        modifier = Modifier
//            .height(45.dp)
//            .fillMaxWidth()
//            .background(MaterialTheme.colors.primary)
//            .border(
//                1.dp,
//                Color.White,
//                shape = RoundedCornerShape(
//                    topEnd = 30.dp,
//                    topStart = 30.dp,
//                    bottomEnd = 30.dp,
//                    bottomStart = 30.dp
//                )
//            )
//    ) {
//        Row(
//
//            modifier = modifier
//                .fillMaxHeight()
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//
//        ) {
//            Box(
//                modifier = modifier
//                    .weight(2.8f)
//                    .height(45.dp)
//                    .width(150.dp)
//                    .clip(CircleShape)
//                    .background(Color.White)
//                    .border(1.dp, Color.White),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    "Get Started",
//                    style = MaterialTheme.typography.subtitle2.copy(color = MaterialTheme.colors.primary)
//                )
//            }
//            Text(
//                "Log In",
//                style = MaterialTheme.typography.subtitle2,
//                modifier = Modifier
//                    .weight(1f)
//                    .wrapContentWidth(Alignment.CenterHorizontally),
//            )
//        }
//
//
//    }
//}
//
//@OptIn(ExperimentalTextApi::class)
//@Composable
//private fun Title() {
//    Text(
//        buildAnnotatedString {
//            append("We’ve")
//            withStyle(
//                style = SpanStyle(brush = Brush.horizontalGradient(colorStops = orangeGradient))
//            ) {
//                append(" made\n")
//            }
//            append("it easy for you.")
//        },
//        style = MaterialTheme.typography.h3.copy(
//            lineHeight = 42.sp
//        ),
//    )
//}