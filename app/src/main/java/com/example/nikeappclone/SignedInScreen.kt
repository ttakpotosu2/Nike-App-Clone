package com.example.nikeappclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignedInScreen(
    navController : NavController
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.nike_swoosh),
            contentDescription = null,
            modifier = Modifier
                .size(width = 80.dp, height = 80.dp)
        )
        Text(
            "You have been signed in successfully.",
            style = TextStyle(
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        LoginButton(
            buttonText = "Continue",
            modifier = Modifier.fillMaxWidth(),
            navController = navController,
            onClickAction = {
                navController.navigate(route = Screen.LanguageSelectionScreen.route)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignedInScreenPreview() {
    SignedInScreen(navController = rememberNavController())
}