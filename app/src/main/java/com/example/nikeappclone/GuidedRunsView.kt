package com.example.nikeappclone

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GuidedRunsView() {
    val scrollState = rememberScrollState(0)
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
            .padding(vertical = 16.dp),
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {

            item { GuidedRunCardBig(
                image = painterResource(id = R.drawable.camera_digital),
                contentDescription = "5k runs",
                title = "5K Head starts",
                runSpecs = "5K",
                runType = " | Run"
            ) }
            item { GuidedRunCardBig(
                image = painterResource(id = R.drawable.band),
                contentDescription = "Thank You Run",
                title = "Thank You Run",
                runSpecs = "45 min",
                runType = " | Run"
            ) }
        }

        Column(

            modifier = Modifier.padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            GetStartedCollection()

            Spacer(modifier = Modifier.height(32.dp))

            DividerSection()

            Spacer(modifier = Modifier.height(32.dp))

            DistanceBasedRuns()

            Spacer(modifier = Modifier.height(32.dp))

            MindfulRunningPack()

            Spacer(modifier = Modifier.height(32.dp))

            AthleteStories()

            Spacer(modifier = Modifier.height(32.dp))

            ShortRuns()

            Spacer(modifier = Modifier.height(32.dp))

            TreadmillRuns()

            Spacer(modifier = Modifier.height(32.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GuidedRunsPreview() {
    GuidedRunsView()
}

@Composable
fun GuidedRunCardBig(
    image : Painter,
    contentDescription : String,
    title : String,
    runSpecs : String,
    runType : String
) {
    Column {
        Box(
            modifier = Modifier
                .size(350.dp, 200.dp)
                .clip(RoundedCornerShape(6.dp)),
        contentAlignment = Alignment.Center
        ) {
            Image(
                painter = image,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
            )
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            )
        }
        Row {
            Text(
                text = runSpecs,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = runType,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
fun GuidedRunCardSmall(
    image : Painter,
    contentDescription : String,
    title : String,
    runSpecs : String,
    runType : String
) {
    Column {
        Box(
            modifier = Modifier
                .size(180.dp, 180.dp)
                .clip(RoundedCornerShape(6.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = image,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            Text(
                text = title.uppercase(),
                style = TextStyle(
                    fontSize = 22.sp,
                    lineHeight = 19.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            )
        }
        Row {
            Text(
                text = runSpecs,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = runType,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
fun GetStartedCollection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Get Started Collection",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "All",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal
            )
        )
    }
    Text(
        text = "Explore runs to get you started",
        style = TextStyle(
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        ),
        modifier = Modifier.padding(vertical = 12.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(ScrollState(0))
            .padding(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.abstract_one),
            contentDescription = "First Run",
            title = "First Run",
            runSpecs = "20 min",
            runType = " | Run"
        )
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.abstract_two),
            contentDescription = "Next Run",
            title = "Next Run",
            runSpecs = "22 min",
            runType = " | Run"
        )
    }
}

@Composable
fun DividerSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Divider()
        Text(
            text = "Saved Runs",
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        Divider()
        Text(
            text = "Recent Runs",
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        Divider()
        Text(
            text = "Downloaded Runs",
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        Divider()
        Text(
            text = "All Runs",
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        Divider()
    }

}

@Composable
fun DistanceBasedRuns() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Distance Based Runs",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "All",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal
            )
        )
    }
    Text(
        text = "Runs based on set distance goals",
        style = TextStyle(
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        ),
        modifier = Modifier.padding(vertical = 12.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(ScrollState(0))
            .padding(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.fabric_one),
            contentDescription = "5K Head Start",
            title = "5K Head Start",
            runSpecs = "5K",
            runType = " | Run"
        )
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.fabric_two),
            contentDescription = "7K Runs",
            title = "7K Runs",
            runSpecs = "7K",
            runType = " | Run"
        )
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.fabric_two),
            contentDescription = "7K Runs",
            title = "7K Runs",
            runSpecs = "7K",
            runType = " | Run"
        )
    }
}

@Composable
fun MindfulRunningPack() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Mindful Running Pack",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "All",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal
            )
        )
    }
    Text(
        text = "Connect your mind and body with NRC Coaches and Headspace",
        style = TextStyle(
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        ),
        modifier = Modifier.padding(vertical = 12.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(ScrollState(0))
            .padding(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.fabric_one),
            contentDescription = "5K Head Start",
            title = "5K Head Start",
            runSpecs = "5K",
            runType = " | Run"
        )
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.design),
            contentDescription = "Running for More: Success",
            title = "Running for More: Success",
            runSpecs = "30 Min",
            runType = " | Run"
        )
    }
}

@Composable
fun AthleteStories() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Athlete Stories",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "All",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal
            )
        )
    }
    Text(
        text = "Great stories that will inspire and motivate you to a great run",
        style = TextStyle(
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        ),
        modifier = Modifier.padding(vertical = 12.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(ScrollState(0))
            .padding(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.fabric_one),
            contentDescription = "5K Head Start",
            title = "Running for Mental Toughness with Megan Thee Stallion",
            runSpecs = "30 Min",
            runType = " | Run"
        )
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.fabric_two),
            contentDescription = "7K Runs",
            title = "Running For Creativity",
            runSpecs = "25 Min",
            runType = " | Run"
        )
    }
}

@Composable
fun ShortRuns() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Short Runs",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "All",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal
            )
        )
    }
    Text(
        text = "Get going on runs under 30 minutes",
        style = TextStyle(
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        ),
        modifier = Modifier.padding(vertical = 12.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(ScrollState(0))
            .padding(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.design),
            contentDescription = "5K Head Start",
            title = "Need this run",
            runSpecs = "20 Min",
            runType = " | Run"
        )
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.candle),
            contentDescription = "7K Runs",
            title = "Morning Runs with Headspace",
            runSpecs = "30 Min",
            runType = " | Run"
        )
    }
}

@Composable
fun TreadmillRuns() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Treadmill Runs",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "All",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal
            )
        )
    }
    Text(
        text = "Get going with these runs specially made for the treadmill",
        style = TextStyle(
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        ),
        modifier = Modifier.padding(vertical = 12.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(ScrollState(0))
            .padding(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.fabric_one),
            contentDescription = "5K Head Start",
            title = "Don't Stop! Go!",
            runSpecs = "20 Min",
            runType = " | Treadmill Run"
        )
        GuidedRunCardSmall(
            image = painterResource(id = R.drawable.fabric_two),
            contentDescription = "7K Runs",
            title = "Big Treadmill Run",
            runSpecs = "60 Min",
            runType = " | Run"
        )
    }
}

