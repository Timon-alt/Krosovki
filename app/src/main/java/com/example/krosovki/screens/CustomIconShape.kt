package com.example.krosovki.screens

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class CustomIconShape(
    private val cornerRadius: Dp = 15.dp,
    private val tipSize: Dp = 0.dp

): Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val tipSize = with(density) { tipSize.toPx() }
        val path = Path().apply {
            addRoundRect(
                RoundRect(
                    left = tipSize,
                    topLeftCornerRadius = CornerRadius(32f),
                    right = size.width,
                    top = 0f,
                    bottom = size.height - tipSize,
                    bottomRightCornerRadius = CornerRadius(32f)
                )
            )
        }
        return Outline.Generic(path)
    }
}