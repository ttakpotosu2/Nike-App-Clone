package com.example.nikeappclone.uiModels

import com.example.nikeappclone.R

data class StartARunCard(
    val image: Int,
    val title: String,
    val subtitle: String = "",
    val timeStamp: String = "",
    val runType: String = "",
    val cardType: CardType
)

enum class CardType{
    COMMON, VIEW_MORE
}

val startARunCards = listOf(
    StartARunCard(
        image = R.drawable.design,
        title = "Try a Guided Run",
        subtitle = "First Run",
        timeStamp = "20 min",
        runType = " | Run",
        cardType = CardType.COMMON
    ),
    StartARunCard(
        image = R.drawable.camera_digital,
        title = "Try a Guided Run",
        subtitle = "Next Speed Run",
        timeStamp = "25 min",
        runType = " | Intervals",
        cardType = CardType.COMMON
    ),
    StartARunCard(
        image = R.drawable.guitar,
        title = "View More Guided Runs from Nike Coaches and athletes",
        cardType = CardType.VIEW_MORE
    )
)

