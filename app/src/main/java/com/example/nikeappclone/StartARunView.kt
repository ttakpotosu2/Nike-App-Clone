package com.example.nikeappclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.nikeappclone.uiModels.CardType
import com.example.nikeappclone.uiModels.startARunCards
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun StartARunView(
    navController: NavController,

    markerPosition: LatLng = LatLng(5.55602, -0.1969),
    cameraPositionState: CameraPositionState = rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(markerPosition, 15f)
    }
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = MapProperties(),
            uiSettings = MapUiSettings(
                zoomGesturesEnabled = true
            )
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .clip(RoundedCornerShape(8.dp)),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(startARunCards){ cardModel ->
                when (cardModel.cardType) {
                    CardType.COMMON -> {
                        ContentCard(
                            title = cardModel.title,
                            subtitle = cardModel.subtitle,
                            timeStamp = cardModel.timeStamp,
                            runType = cardModel.runType,
                            image = cardModel.image
                        )
                    }
                    CardType.VIEW_MORE -> {
                        ViewMoreCard(
                            title = cardModel.title,
                            image = cardModel.image
                        )
                    }
                }
            }
        }
        Column(
            horizontalAlignment = CenterHorizontally,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(36.dp),
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .padding(vertical = 40.dp)
            ){
                SettingButton()
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFFEB3B))
                        .clickable {
                            navController.navigate(route = Screen.LocationScreen.route)
                        }
                ) {
                    Text(
                        "Start".uppercase(),
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                        )
                    )
                }
                MusicButton()
            }
            SetAGoalButton()
            Spacer(modifier = Modifier.height(36.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartARunPreview() {
    StartARunView(navController = rememberNavController())
}

@Composable
fun SettingButton(
) {
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .clip(CircleShape)
            .size(60.dp)
            .background(Color.White, shape = CircleShape)
    ){
        Icon(
            Icons.Filled.Settings,
            contentDescription = "Start a Run Settings",
            modifier = Modifier
                .size(20.dp),
            tint = Color.Black
        )
    }
}

@Composable
fun MusicButton(
) {
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .clip(CircleShape)
            .size(60.dp)
            .background(Color.White, shape = CircleShape)
    ){
        Icon(
            Icons.Filled.MusicNote,
            contentDescription = "Music Settings",
            modifier = Modifier
                .size(20.dp),
            tint = Color.Black
        )
    }
}

@Composable
fun SetAGoalButton() {
    Button(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        colors = buttonColors(backgroundColor = Color.White),
        elevation = ButtonDefaults.elevation(4.dp)
    ) {
        Text(
            text = "Set a Goal",
            style = TextStyle(
                fontSize = 20.sp
            )
        )
    }
}

@Composable
fun ContentCard(
    title : String,
    subtitle : String,
    timeStamp : String,
    runType : String,
    image : Int,
) {
    Box (
    modifier = Modifier
        .size(320.dp, 140.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(Color.White)
        .padding(20.dp)
    ){
        Row {
            Image(
                painter = painterResource(id = image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .size(100.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    subtitle,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row{
                    Text(
                        timeStamp,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                    Text(
                        runType,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ViewMoreCard(
    title : String,
    image : Int,
) {
    Box (
        modifier = Modifier
            .size(320.dp, 140.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(20.dp)
    ){
        Row {
            Image(
                painter = painterResource(id = image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .size(100.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 25.sp
                )
            )
        }
    }
}