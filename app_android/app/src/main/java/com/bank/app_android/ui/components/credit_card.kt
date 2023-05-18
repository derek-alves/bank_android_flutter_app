package com.bank.app_android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bank.app_android.R

@Composable
fun CreditCard(cardNumber: String, name: String, value: String?, modifier: Modifier = Modifier) {
    val hideValue = remember { mutableStateOf(true) }

    Column(horizontalAlignment = Alignment.End) {
        if (value?.isNotEmpty() == true) Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(
                    vertical = 2.dp, horizontal = 20.dp
                )
                .clickable {
                    hideValue.value = !hideValue.value
                }
        ) {
            Image(
                painter = painterResource(id = if (hideValue.value) R.drawable.eye else R.drawable.hide_eye),
                contentDescription = "Bank images"
            )
            Spacer(modifier = modifier.width(4.dp))
            Text(
                "Balance",
                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Light)
            )
        }
        Box() {
            Image(
                painter = painterResource(id = R.drawable.card_2),
                contentDescription = "Bank images"
            )
            Text(
                cardNumber,
                style = MaterialTheme.typography.body1.copy(letterSpacing = 4.sp),
                modifier = modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 34.dp)
            )

            Column(
                modifier = modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 34.dp, bottom = 16.dp)
            ) {
                Row() {
                    Text(
                        "Card Holder ",
                        style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Light)
                    )
                    if (!hideValue.value) {
                        Text(
                            "• $ $value",
                            style = MaterialTheme.typography.body2
                        )
                    }
                }

                Text(name, style = MaterialTheme.typography.body1)
            }
        }
    }

}
