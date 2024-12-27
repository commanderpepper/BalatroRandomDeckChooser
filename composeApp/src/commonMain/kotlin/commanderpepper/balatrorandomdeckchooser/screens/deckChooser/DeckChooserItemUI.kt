package commanderpepper.balatrorandomdeckchooser.screens.deckChooser

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import balatrorandomdeckchooser.composeapp.generated.resources.*
import commanderpepper.balatrorandomdeckchooser.models.Deck
import commanderpepper.balatrorandomdeckchooser.models.ui.DeckChooserItem
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DeckChooserItemUI(deckChooserItem: DeckChooserItem) {
    val initialCount = remember { deckChooserItem.count }
    val borderColor = remember { Animatable(Color.Black) }
    var cardRotation = remember { mutableStateOf(0f) }

    LaunchedEffect(deckChooserItem.count){
        if(deckChooserItem.count > initialCount){
            val animationDuration = 375
            launch {
                repeat(5){
                    borderColor.animateTo(Color.Yellow, animationSpec = tween(animationDuration * 2))
                    borderColor.animateTo(Color.Black, animationSpec = tween(animationDuration * 2))
                }
            }
            launch {
                animate(0f, 22.5f, animationSpec = tween(animationDuration)){ value, velocity ->
                    cardRotation.value = value
                }
                repeat(7){
                    animate(22.5f, -22.5f, animationSpec = tween(animationDuration)){ value, velocity ->
                        cardRotation.value = value
                    }
                    animate(-22.5f, 22.5f, animationSpec = tween(animationDuration)){ value, velocity ->
                        cardRotation.value = value
                    }
                }
                animate(22.5f, 0f, animationSpec = tween(animationDuration)){ value, velocity ->
                    cardRotation.value = value
                }
            }
        }
    }

    Column(
        modifier = Modifier.rotate(cardRotation.value).padding(8.dp).border(
            width = 2.dp,
            color = borderColor.value,
            shape = RoundedCornerShape(12.dp)
        ), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Text(modifier = Modifier.padding(4.dp), text = "${deckChooserItem.count}")
        Image(painter = painterResource(deckChooserItem.getImage()), contentDescription = "Deck Image")
    }
}

@Preview
@Composable
fun DeckChooserItemPreview() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        DeckChooserItemUI(DeckChooserItem(0, Deck.RED))
        DeckChooserItemUI(DeckChooserItem(0, Deck.BLUE))
        DeckChooserItemUI(DeckChooserItem(0, Deck.YELLOW))
        DeckChooserItemUI(DeckChooserItem(0, Deck.GREEN))
        DeckChooserItemUI(DeckChooserItem(0, Deck.BLACK))
        DeckChooserItemUI(DeckChooserItem(0, Deck.MAGIC))
        DeckChooserItemUI(DeckChooserItem(0, Deck.NEBULA))
        DeckChooserItemUI(DeckChooserItem(0, Deck.GHOST))
        DeckChooserItemUI(DeckChooserItem(0, Deck.ABANDONED))
        DeckChooserItemUI(DeckChooserItem(0, Deck.CHECKERED))
        DeckChooserItemUI(DeckChooserItem(0, Deck.ZODIAC))
        DeckChooserItemUI(DeckChooserItem(0, Deck.ANAGLYPH))
        DeckChooserItemUI(DeckChooserItem(0, Deck.PLASMA))
        DeckChooserItemUI(DeckChooserItem(0, Deck.ERRATIC))
    }
}

fun DeckChooserItem.getImage(): DrawableResource {
    return when (this.deck) {
        Deck.RED -> Res.drawable.Red_Deck
        Deck.BLUE -> Res.drawable.Blue_Deck
        Deck.YELLOW -> Res.drawable.Yellow_Deck
        Deck.GREEN -> Res.drawable.Green_Deck
        Deck.BLACK -> Res.drawable.Black_Deck
        Deck.MAGIC -> Res.drawable.Magic_Deck
        Deck.NEBULA -> Res.drawable.Nebula_Deck
        Deck.GHOST -> Res.drawable.Ghost_Deck
        Deck.ABANDONED -> Res.drawable.Abandoned_Deck
        Deck.CHECKERED -> Res.drawable.Checkered_Deck
        Deck.PAINTED -> Res.drawable.Painted_Deck
        Deck.ZODIAC -> Res.drawable.Zodiac_Deck
        Deck.ANAGLYPH -> Res.drawable.Anaglyph_Deck
        Deck.PLASMA -> Res.drawable.Plasma_Deck
        Deck.ERRATIC -> Res.drawable.Erratic_Deck
    }
}

