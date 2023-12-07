package com.yugamitech.eventmanager.presentation.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
fun ScannerScreenBackgroundLayer(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Black.copy(alpha = 0.4f),
    scannerColor: Color = Color.Transparent,
    boundaryColor: Color = Color.White,
    boundaryWidth: Dp = 2.dp,
    cornerRadius: Float = 40f
) {

    BoxWithConstraints(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            val configuration = this
            Canvas(modifier = Modifier.fillMaxSize()) {

                val canvasHeight = this.size.height
                val canvasWidth = this.size.width
                val canvasCenter = this.size.center

                val scannerPath = Path().apply {
                    addRoundRect(
                        roundRect = RoundRect(
                            rect = Rect(
                                center = Offset(x = canvasCenter.x, y = canvasCenter.y),
                                radius = min(
                                    configuration.maxWidth.value,
                                    configuration.maxHeight.value
                                )
                            ),
                            cornerRadius = CornerRadius(cornerRadius)
                        )
                    )
                    fillType = PathFillType.EvenOdd
                    close()
                }

                val backgroundPath = Path().apply {
                    moveTo(0f, 0f)
                    lineTo(0f, canvasHeight)
                    lineTo(canvasWidth, canvasHeight)
                    lineTo(canvasWidth, 0f)
                    fillType = PathFillType.EvenOdd
                    addPath(scannerPath)
                    close()
                }

                drawPath(path = backgroundPath, color = backgroundColor)
                drawPath(path = scannerPath, color = scannerColor)
                drawPath(
                    path = scannerPath,
                    color = boundaryColor,
                    style = Stroke(width = boundaryWidth.toPx())
                )
            }
        }
    )
}
