package com.composablecode.main_app.presentation.ui.pages.home.home_page


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bank.app_android.ui.components.CreditCard
import com.bank.app_android.ui.components.CustomCarousel
import com.bank.app_android.ui.components.DotIndicator
import com.bank.app_android.ui.theme.green
import com.composablecode.main_app.R
import com.composablecode.main_app.app.activity.flutter.FlutterFeatureLauncher
import com.composablecode.main_app.presentation.ui.components.Feature
import com.composablecode.main_app.presentation.view_model.home.HomeAction
import com.composablecode.main_app.presentation.view_model.home.HomeEvent
import com.composablecode.main_app.presentation.view_model.home.HomeState
import com.composablecode.main_app.presentation.view_model.home.HomeViewmodel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomePage(viewModel: HomeViewmodel = koinViewModel()) {
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            viewModel.submitAction(HomeAction.InitData)
        }
    }

    val state by viewModel.uiState.collectAsState(initial = HomeState())
    HomePageContent(state = state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomePageContent(state: HomeState, modifier: Modifier = Modifier) {
    val counter = remember { mutableIntStateOf(0) }
    val context = LocalContext.current
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 2 },
    )

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

    when (state.event) {

        is HomeEvent.Error -> {
            Text("Error")
        }

        HomeEvent.Success -> {
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
                                    modifier = modifier,
                                    title = {},
                                    navigationIcon = {
                                        IconButton(onClick = { println("aaaaaaaaaa") }) {
                                            Image(
                                                painter = painterResource(id = R.drawable.drawer_icon),
                                                contentDescription = "Drawer icon",
                                                contentScale = ContentScale.Fit,
                                                modifier = Modifier.padding(start = 8.dp)
                                            )
                                        }
                                    },
                                    colors = TopAppBarDefaults.topAppBarColors(
                                        containerColor = Color.Transparent
                                    )
                                )
                                Text(
                                    "Chika, Welcome Back!",
                                    style = MaterialTheme.typography.headlineLarge,
                                    modifier = modifier.padding(
                                        start = 26.dp,
                                        end = 26.dp,
                                        bottom = 26.dp
                                    )
                                )
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = modifier.padding(bottom = 26.dp)
                                ) {
                                    CustomCarousel(
                                        composable = components, state = pagerState
                                    ) {
                                        counter.intValue = it
                                    }
                                    Spacer(modifier = modifier.height(12.dp))
                                    DotIndicator(
                                        size = components.size,
                                        position = counter.intValue
                                    )
                                }

                                Row(
                                    modifier = modifier
                                        .padding(horizontal = 28.dp)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    state.features.forEach { feature ->
                                        Feature(
                                            featureModel = feature,
                                            onClick = {
                                                FlutterFeatureLauncher.pushFeature(context, feature)
                                            }
                                        )
                                    }
                                }
                            }

                            transactionsHeader(modifier = modifier)
                            transactions(modifier = modifier)
                        }
                    }

                },
            )
        }

        else -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    color = green,
                    strokeWidth = 20.dp
                )
            }

        }
    }


}

private fun LazyListScope.transactions(modifier: Modifier) {
    items(10) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 26.dp, end = 26.dp, top = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.transfer),
                contentDescription = "transfer",
            )
            Spacer(modifier = modifier.width(16.dp))
            Column() {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Column() {
                        Text("Wire Transfer")
                        Text(
                            "Josias Lois R - BCA 381400000",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Light,
                                fontSize = 10.sp
                            )
                        )
                    }
                    Text("$ 14000,00", color = green)

                }
                HorizontalDivider(thickness = 1.dp, color = Color.White.copy(alpha = 0.2f))
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
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Light)
                    )
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "arrow",
                        modifier = modifier.padding(start = 2.dp)
                    )
                }
            }
            HorizontalDivider(thickness = 1.dp, color = Color.White.copy(alpha = 0.2f))
        }

    }

}

@Composable
private fun BackgroundImage(modifier: Modifier, child: @Composable () -> Unit) {
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
