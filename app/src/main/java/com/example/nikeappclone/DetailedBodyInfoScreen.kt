package com.example.nikeappclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckBoxOutlineBlank
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
fun DetailedBodyInfoScreen(
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
            Text(
                text = "We'd like the following information to provide more\n" +
                        "accurate results, such as run distance and pace and\n" +
                        "calories. Learn More.",
                color = Color.LightGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
            Column (
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(horizontal = 36.dp)
            ){
                Text(
                    "5'10",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
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
                    "150 lbs",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
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
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(
                    Icons.Rounded.CheckBoxOutlineBlank,
                    contentDescription = null,
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "Use Default",
                    color = Color.LightGray,
                    style = TextStyle(
                        fontSize = 16.sp,
                    )
                )
            }
            Text(
                text = "If you don't wish to enter your height and weight, select the\n" +
                        "default option and we will use a default value to perform these\n" +
                        "calculations.",
                color = Color.LightGray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailedBodyInfoScreenPreview() {
    DetailedBodyInfoScreen(navController = rememberNavController())
}
