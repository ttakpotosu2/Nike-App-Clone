package com.example.nikeappclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(
    navController: NavController
) {
    var emailValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(36.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start

    ) {
        Image(
            painter = painterResource(id = R.drawable.nike_swoosh),
            contentDescription = null,
            modifier = Modifier
                .size(width = 80.dp, height = 80.dp)
        )
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "Enter your email to join us or sign in.",
            fontSize = 34.sp
        )
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Accra",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Text(
                "Change",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
        OutlinedTextField(
            value = emailValue,
            onValueChange = { emailValue = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Enter your email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "By continuing, I agree to Nike's\n" +
                    "Privacy Policy and Terms of Use",
            fontSize = 24.sp
        )
        LoginButton(
            buttonText = "Next",
            modifier = Modifier.fillMaxWidth(),
            navController = navController,
            onClickAction = { navController.navigate(route = Screen.LoginDetailsScreen.route) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}