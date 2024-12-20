package commanderpepper.balatrorandomdeckchooser.screens.deckChooser

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DeckChooserSwirlingBackground(modifier: Modifier = Modifier.fillMaxSize()) {
    var currentRotation by remember { mutableStateOf(0f) }
    val outerRotation = remember { Animatable(currentRotation) }

    LaunchedEffect(Unit) {
        while (true) {
            outerRotation.animateTo(
                targetValue = currentRotation + 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(3000, easing = FastOutSlowInEasing),
                    repeatMode = RepeatMode.Restart
                )
            ) {
                currentRotation = value
            }
        }
    }

    val brush = Brush.linearGradient(listOf(Color.Red, Color.Blue, Color.Red, Color.Blue, Color.Red))
    Box(modifier = modifier.background(brush).rotate(outerRotation.value).background(brush), contentAlignment = Alignment.Center) {

        Canvas(
            modifier = Modifier.fillMaxSize().rotate(outerRotation.value),
            onDraw = {
                drawCircle(brush)
            }
        )
    }
}

@Preview
@Composable
fun DeckChooserSwirlingBackgroundPreview(){
    DeckChooserSwirlingBackground()
}