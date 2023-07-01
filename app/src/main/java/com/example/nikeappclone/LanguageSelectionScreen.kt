package com.example.nikeappclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LanguageSelectionScreen(
    navController: NavController
) {

    var isExpanded by remember { mutableStateOf(false) }
    val languages = listOf(
        "English",
        "French",
        "Spanish",
        "German",
        "Swedish",
        "Arabic",
        "Chinese",
        "Japanese",
        "Zulu",
        "Twi"
    )
    var isSelectedText by remember { mutableStateOf("") }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }


    // Up Icon when expanded and down icon when collapsed
    val icon = if (isExpanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown

    Column(
        modifier = Modifier
            .padding(36.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.nike_swoosh),
            contentDescription = null,
            modifier = Modifier
                .size(width = 80.dp, height = 80.dp)
        )
        Text(
            "Select Your Language",
            style = TextStyle(
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            "Please update to a language supported in NRC app.",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.LightGray
            )
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Drop Down Menu
        OutlinedTextField(
            value = isSelectedText,
            onValueChange = { isSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = { Text(text = "Language") },
            placeholder = { Text(text = "Language") },
            shape = RoundedCornerShape(corner = CornerSize(32.dp)),
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        icon,
                        contentDescription = null,
                        Modifier.clickable { isExpanded = !isExpanded }
                    )
                }
            }
        )
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
        ) {
            languages.forEach { label ->
                DropdownMenuItem(onClick = {
                    isSelectedText = label
                    isExpanded = false
                }) {
                    Text(text = label)
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        LoginButton(
            buttonText = "Okay",
          modifier = Modifier.align(Alignment.CenterHorizontally),
            navController = navController,
            onClickAction = { navController.navigate(route = Screen.WelcomeScreen.route) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageSelectionScreenPreview() {
    LanguageSelectionScreen(navController = rememberNavController())
}