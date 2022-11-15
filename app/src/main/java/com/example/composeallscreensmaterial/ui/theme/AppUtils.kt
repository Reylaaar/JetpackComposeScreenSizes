package com.example.composeallscreensmaterial.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember

@Composable
fun ProvideAppUtils(
    dimensions: Dimensions,
    orientation: Orientation,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember {
        dimensions
    }
    val orientationSet = remember {
        orientation
    }

    CompositionLocalProvider(
        LocalAppDimens provides dimensionSet,
        LocalOrientationMode provides orientationSet,
        content = content
    )
}

val LocalAppDimens = compositionLocalOf {
    smallDimensions
}

val LocalOrientationMode = compositionLocalOf {
    Orientation.Portrait
}