package commanderpepper.balatrorandomdeckchooser.screens.deckChooser

import androidx.compose.animation.Animatable
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import balatrorandomdeckchooser.composeapp.generated.resources.*
import commanderpepper.balatrorandomdeckchooser.models.Deck
import commanderpepper.balatrorandomdeckchooser.models.ui.DeckChooserItem
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DeckChooserItemUI(deckChooserItem: DeckChooserItem) {
    val initialCount = remember { deckChooserItem.count }
    val borderColor = remember { Animatable(Color.Black) }

    LaunchedEffect(deckChooserItem.count){
        if(deckChooserItem.count > initialCount){
            borderColor.animateTo(Color.Yellow, animationSpec = tween(1000))
            borderColor.animateTo(Color.Black, animationSpec = tween(1000))
        }
    }

    Column(
        modifier = Modifier.padding(8.dp).border(
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
        Deck.BLACK -> Res.drawable.Blue_Deck
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

