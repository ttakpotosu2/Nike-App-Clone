package com.example.nikeappclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
fun WelcomeScreen(
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
            verticalArrangement = Arrangement.spacedBy(50.dp,
                alignment = Alignment.CenterVertically
            ),
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .padding(16.dp)
        ) {
            Icon(
                Icons.Outlined.AccountCircle,
                modifier = Modifier
                    .size(100.dp),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "Welcome John, You're in!".uppercase(),
                style = TextStyle(
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "To make sure you experience with Nike Run Club is" +
                        "the best it can be, we'd like to get to know you a little" +
                        "better.",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp
            )
        }
        Button(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            onClick = {
                navController.navigate(route = Screen.LocationScreen.route)
            },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Get Started",
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}