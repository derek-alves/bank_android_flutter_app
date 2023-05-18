package com.bank.app_android.ui.pages.home.profile


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bank.app_android.ui.components.CreditCard
import com.bank.app_android.ui.components.CustomCarousel
import com.bank.app_android.ui.components.DotIndicator
import com.bank.app_android.ui.components.Feature
import com.bank.app_android.ui.theme.green
import com.bank.app_android.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfilePage(modifier: Modifier = Modifier) {
    val counter = remember { mutableStateOf(0) }
    val pageState = rememberPagerState()


    val components = listOf<@Composable () -> Unit>(
        {
            CreditCard(
                cardNumber = "4814 9933 2112 0400",
                value = "142.883,00",
                name = "Chika Adien Aulya",
                modifier = modifier
            )
        },
        {
            CreditCard(
                cardNumber = "4814 9933 2112 0400",
                value = "142.883,00",
                name = "Chika Adien Aulya",
                modifier = modifier
            )
        }
    )



    Scaffold(
        content = { paddingValues ->
            val scrollState = rememberScrollState()
            BackgroundImage(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = modifier.fillMaxSize()
                ) {
                    item {
                        TopAppBar(
                            modifier = modifier.padding(start = 26.dp)

                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.drawer_icon),
                                contentDescription = "aaa",
                            )

                        }
                        Text(
                            "Chika, Welcome Back!",
                            style = MaterialTheme.typography.h5.copy(color = MaterialTheme.colors.primaryVariant),
                            modifier = modifier.padding(start = 26.dp, end = 26.dp, bottom = 26.dp)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = modifier.padding(bottom = 26.dp)
                        ) {
                            CustomCarousel(
                                composable = components, state = pageState
                            ) {
                                counter.value = it
                            }
                            Spacer(modifier = modifier.height(12.dp))
                            DotIndicator(size = components.size, position = counter.value)
                        }

                        Row(
                            modifier = modifier
                                .padding(horizontal = 28.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Feature(modifier = modifier)
                            Feature(modifier = modifier)
                            Feature(modifier = modifier)
                            Feature(modifier = modifier)
                        }
                    }

                    transactionsHeader(modifier = modifier)
                    transactions(modifier = modifier)
                }
            }

        },
    )

}

private fun LazyListScope.transactions(modifier: Modifier){
    items(10){
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(start = 26.dp, end = 26.dp, top = 16.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.transfer),
                contentDescription = "transfer",
            )
            Spacer(modifier = modifier.width(16.dp))
            Column() {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.fillMaxWidth()) {
                    Column() {
                        Text("Wire Transfer")
                        Text("Josias Lois R - BCA 381400000",
                            style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Light,fontSize = 10.sp)
                        )
                    }
                    Text("$ 14000,00", color= green)

                }
                Divider(color = Color.White.copy(alpha = 0.2f), thickness = 1.dp)
            }

        }
    }
}

private fun LazyListScope.transactionsHeader(modifier: Modifier) {
    item {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 26.dp, end = 26.dp, top = 26.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)

            ) {
                Text("Recent Transaction")

                Row() {
                    Text(
                        "Open",
                        style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Light)
                    )
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = "arrow", modifier = modifier.padding(start = 2.dp))
                }
            }
            Divider(color = Color.White.copy(alpha = 0.2f), thickness = 1.dp)
        }

    }

}

@Composable
private fun BackgroundImage(modifier: Modifier, child:@Composable () -> Unit){
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_background),
            contentDescription = "aaa",
            modifier = modifier.padding(top = 16.dp)
        )
        child()
    }
}
