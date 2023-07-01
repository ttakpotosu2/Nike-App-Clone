package com.example.nikeappclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
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
        ) {
            Image(
                painter = painterResource(id = R.drawable.nrc_logo),
                contentDescription = null,
                modifier = Modifier.size(width = 100.dp, height = 100.dp)
            )
            Text(
                text = "Wherever you are.\n" +
                       "Wherever you want to go to.\n" +
                       "Come run with us.",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
            )
        }
        BottomButtons(
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navController
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}

@Composable
fun BottomButtons(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = {
                navController.navigate(route = Screen.LoginScreen.route)
            },
            shape = RectangleShape,
            modifier = Modifier
                .height(60.dp)
                .weight(0.5f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        ) {
            Text(
                text = "Join now".uppercase(),
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
        Button(
            modifier = Modifier
                .height(60.dp)
                .weight(0.5f),
            onClick = {
                navController.navigate(route = Screen.LoginScreen.route)
            },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Log In".uppercase(),
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
    }
}