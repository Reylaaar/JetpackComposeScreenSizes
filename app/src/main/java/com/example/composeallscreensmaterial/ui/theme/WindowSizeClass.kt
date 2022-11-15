package com.example.composeallscreensmaterial.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

sealed class WindowsSize(val size: Int) {

    data class Small(val smallSize: Int) : WindowsSize(smallSize)
    data class Compact(val compactSize: Int) : WindowsSize(compactSize)
    data class Medium(val mediumSize: Int) : WindowsSize(mediumSize)
    data class Large(val LargeSize: Int) : WindowsSize(LargeSize)

}

data class WindowSizeClass(
    val width: WindowsSize,
    val height: WindowsSize
)

@Composable
fun rememberWindowSizeClass(): WindowSizeClass {


    val config = LocalConfiguration.current

    val width by remember(config) {
        mutableStateOf(config.screenWidthDp)
    }

    val height by remember(config) {
        mutableStateOf(config.screenHeightDp)
    }

    val windowWidthClass = when {
        width <= 360 -> WindowsSize.Small(width)
        width in 361..480 -> WindowsSize.Compact(width) // Portrait
        width in 481..720 -> WindowsSize.Compact(width)
        else -> WindowsSize.Large(width) // Landscape
    }

    val windowHeightClass = when {
        height <= 360 -> WindowsSize.Small(height)
        height in 361..480 -> WindowsSize.Compact(height)
        height in 481..720 -> WindowsSize.Compact(height)
        else -> WindowsSize.Large(height)
    }

    return WindowSizeClass(windowWidthClass, windowHeightClass)
}