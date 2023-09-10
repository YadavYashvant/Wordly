package com.example.wordly

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation

@Composable
@Preview
fun LottieAnimator() {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.splash))
    LottieAnimation(composition = composition,
        modifier = Modifier.fillMaxSize(),
        iterations = Int.MAX_VALUE
        )
    //not in use till now!
}