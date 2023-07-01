package com.example.nikeappclone

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TrainingPlansView() {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState(0))
            .fillMaxWidth()
            .padding(26.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TrainingPlansCard(
            image = painterResource(id = R.drawable.camera_digital),
            contentDescription = "",
            title = "Marathon Training Plan",
            subtitle = "18 week Training Plan",
            subtitle_two = "Guidance on running, recovery, strength, training and mindset to " +
                    "prepare you for the journey of a lifetime ",
            level = "All levels"
        )
        TrainingPlansCard(
            image = painterResource(id = R.drawable.fabric_one),
            contentDescription = "",
            title = "Get Started",
            subtitle = "4-Week Training plan",
            subtitle_two = "Everything you need to get started and keep going",
            level = "Beginner"
        )
        TrainingPlansCard(
            image = painterResource(id = R.drawable.running),
            contentDescription = "",
            title = "5K Training Plan",
            subtitle = "8-Week Training Plan",
            subtitle_two = "A fun, exiting combination of speed, endurance, recovery and motivation" +
                    "to get you ready to tackle a 5K.",
            level = "Beginner"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "NRC Training plans give you weekly coaching and guidance to help you reach" +
                    " your goals.",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
    }
//    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
//        item{
//            IconAndTextButton(icon = Icons.Default.FavoriteBorder, description = "Nutrition &" +
//                    " Wellness tips.")
//        }
//        item{
//            IconAndTextButton(icon = Icons.Default.Sensors, description = "Audio Guided runs" +
//                    "and music.")
//        }
//        item{
//            IconAndTextButton(icon =Icons.Default.Description, description ="Flexible Workout" +
//                    " schedules")
//        }
//        item{
//            IconAndTextButton(icon = Icons.Default.InsertComment, description = "Motivation & " +
//                    "progress updates")
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun TrainingPlansViewPreview() {
    TrainingPlansView()
}

@Composable
fun TrainingPlansCard(
    image : Painter,
    contentDescription : String,
    title : String,
    subtitle: String,
    subtitle_two : String,
    level : String
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            //.shadow(elevation = .5.dp,  shape = RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .border(width = 1.dp, Color.LightGray, shape = RoundedCornerShape(12.dp)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding()
        ){
            Image(
                painter = image,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxWidth()
            )
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            )
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = subtitle,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = subtitle_two,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    color = Color.LightGray
                )
            )
            Text(
                text = level,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(3.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
            )
        }
    }
}

@Composable
fun IconAndTextButton(
    icon: ImageVector,
    description : String
) {
    Column (
        modifier = Modifier
            .size(200.dp, 200.dp)
    ){
        Icon(icon, contentDescription = null)
        Text(text = description)
    }
}