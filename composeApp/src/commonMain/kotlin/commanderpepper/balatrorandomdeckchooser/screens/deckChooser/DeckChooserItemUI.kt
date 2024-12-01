package commanderpepper.balatrorandomdeckchooser.screens.deckChooser

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import balatrorandomdeckchooser.composeapp.generated.resources.*
import balatrorandomdeckchooser.composeapp.generated.resources.Blue_Deck
import balatrorandomdeckchooser.composeapp.generated.resources.Red_Deck
import balatrorandomdeckchooser.composeapp.generated.resources.Res
import balatrorandomdeckchooser.composeapp.generated.resources.Yellow_Deck
import commanderpepper.balatrorandomdeckchooser.models.Deck
import commanderpepper.balatrorandomdeckchooser.models.ui.DeckChooserItem
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.skia.Color

@Composable
fun DeckChooserItemUI(deckChooserItem: DeckChooserItem) {
    Column(
        modifier = Modifier.padding(8.dp).border(
            width = 2.dp,
            color = androidx.compose.ui.graphics.Color.Black,
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
        Deck.ZODIAC -> Res.drawable.Zodiac_Deck
        Deck.ANAGLYPH -> Res.drawable.Anaglyph_Deck
        Deck.PLASMA -> Res.drawable.Plasma_Deck
        Deck.ERRATIC -> Res.drawable.Erratic_Deck
    }
}
