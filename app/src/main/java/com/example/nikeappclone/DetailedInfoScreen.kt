package com.example.nikeappclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailedInfoScreen(
    navController: NavController
) {
    Box{
        Image(
            painter = painterResource(id = R.drawable.running),
            contentDescription = "Home Page Background Image",
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .alpha(0.2f),
            contentScale = ContentScale.Crop,
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp,
                alignment = Alignment.CenterVertically
            ),
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            Text(
                text = "Tell us about yourself".uppercase(),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Row (
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(horizontal = 24.dp)
                    ){
                Text(
                    "Male".uppercase(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            navController.navigate(route = Screen.LocationScreen.route)
                        }
                )
                Text(
                    "Female".uppercase(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .weight(0.5f)
                        .height(40.dp)
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            navController.navigate(route = Screen.LocationScreen.route)
                        }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailedInfoScreenPreview() {
    DetailedInfoScreen(navController = rememberNavController())
}
