package com.example.wordly

import androidx.compose.runtime.Composable
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation

@Composable
@Preview
fun LottieAnimator() {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.search))
    LottieAnimation(composition = composition)
    //not in use till now!
}