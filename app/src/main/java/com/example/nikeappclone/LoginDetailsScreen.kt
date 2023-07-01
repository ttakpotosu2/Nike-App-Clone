package com.example.nikeappclone

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Autorenew
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material.icons.rounded.CheckBoxOutlineBlank
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.util.*

@Composable
fun LoginDetailsScreen(
    navController: NavController
) {
    var codeValue by remember { mutableStateOf("") }
    var firstNameValue by remember { mutableStateOf("") }
    var lastNameValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var birthdayValue by remember { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf( false) }

    val context = LocalContext.current

    val year: Int
    val month : Int
    val day : Int

    val calender = Calendar.getInstance()
    year = calender.get(Calendar.YEAR)
    month = calender.get(Calendar.MONTH)
    day = calender.get(Calendar.DAY_OF_MONTH)
    calender.time = Date()

    val date = remember { mutableStateOf("")}

    val datePickerDialog = DatePickerDialog(
        context,
        {_: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/$month/$year"
        }, year, month, day
    )

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(ScrollState(0))
            .padding(32.dp)
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
             "Now let's make you a Nike member.",
            style = TextStyle(
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
              "We've sent a code to",
            style = TextStyle(
                fontSize = 16.sp,
            )
        )
        Text(
            "nike@appclone.com",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.LightGray
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = codeValue,
            onValueChange = {codeValue = it},
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Rounded.Autorenew,
                        contentDescription = null,
                        tint = if (passwordVisibility) Color.Black else Color.LightGray
                    )
                }
            },
            label = { Text(text = "Code")},
            placeholder = { Text(text = "Code")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            "Resend in 30",
            style = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                color = Color.Gray
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Row (
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            OutlinedTextField(
                value = firstNameValue,
                onValueChange = {firstNameValue = it},
                label = { Text(text = "First Name")},
                placeholder = { Text(text = "First Name")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = lastNameValue,
                onValueChange = {lastNameValue = it},
                label = { Text(text = "Last Name")},
                placeholder = { Text(text = "Last Name")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = passwordValue,
            onValueChange = {passwordValue = it},
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        Icons.Rounded.Visibility,
                        contentDescription = null,
                        tint = if (passwordVisibility) Color.Black else Color.LightGray
                    )
                }
            },
            label = { Text(text = "Password")},
            placeholder = { Text(text = "Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            "Minimum of 8 characters\n" +
                    "Uppercase, lowercase letters, and one number",
            style = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                color = Color.Gray
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = birthdayValue,
            onValueChange = {birthdayValue = it},
            trailingIcon = {
                IconButton(onClick = {
                    datePickerDialog.show()
                }) {
                    Icon(
                        Icons.Rounded.CalendarToday,
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                }
            },
            label = { Text(text = "Date of Birth")},
            placeholder = { Text(text = "Date of Birth")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            "Get a Nike Membership card on your birthday",
            style = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                color = Color.Gray
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            Icon(
                Icons.Rounded.CheckBoxOutlineBlank,
                contentDescription = null,
                tint = Color.LightGray
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                "Sign up for emails to get updates from \n" +
                        "Nike on products, offers and your\n" +
                        "Member benefits.",
                style = TextStyle(
                    fontSize = 16.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row {
            Icon(
                Icons.Rounded.CheckBoxOutlineBlank,
                contentDescription = null,
                tint = Color.LightGray
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                "I agree to Nike's Privacy Policy and\n" +
                        "Terms of Use.",
                style = TextStyle(
                    fontSize = 16.sp,

                    )
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        LoginButton(
            modifier = Modifier.fillMaxWidth(),
            navController = navController,
            buttonText = "Create Account",
            onClickAction = {navController.navigate(route = Screen.SignedInScreen.route)}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginDetailsScreenPreview() {
    LoginDetailsScreen(navController = rememberNavController())
}

@Composable
fun LoginButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    navController: NavController,
    onClickAction: () -> Unit
) {
    Button(
        onClick = onClickAction,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White
        ),
        modifier = modifier,
        shape = RoundedCornerShape(32.dp)
    ){
        Text(
            text = buttonText,
            fontSize = 22.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}
