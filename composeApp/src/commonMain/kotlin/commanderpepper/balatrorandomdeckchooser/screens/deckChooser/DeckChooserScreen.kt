package commanderpepper.balatrorandomdeckchooser.screens.deckChooser

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import commanderpepper.balatrorandomdeckchooser.models.Deck
import commanderpepper.balatrorandomdeckchooser.models.ui.DeckChooserItem
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DeckChooserScreen(modifier: Modifier = Modifier.fillMaxSize(), decks: List<DeckChooserItem>) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { }) { Text("RANDOM DECK") }
            Button(onClick = { }) { Text("LEAST PLAYED RANDOM DECK") }
        }
        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 136.dp), contentPadding = PaddingValues(8.dp)) {
            items(decks) { deck ->
                DeckChooserItemUI(deck)
            }
        }
    }
}

@Preview
@Composable
fun DeckChooserScreenPreview(){
    DeckChooserScreen(decks = list)
}

val list = listOf(
    DeckChooserItem(0, Deck.RED),
    DeckChooserItem(0, Deck.BLUE),
    DeckChooserItem(0, Deck.YELLOW),
    DeckChooserItem(0, Deck.GREEN),
    DeckChooserItem(0, Deck.BLACK),
    DeckChooserItem(0, Deck.MAGIC),
    DeckChooserItem(0, Deck.NEBULA),
    DeckChooserItem(0, Deck.GHOST),
    DeckChooserItem(0, Deck.ABANDONED),
    DeckChooserItem(0, Deck.CHECKERED),
    DeckChooserItem(0, Deck.ZODIAC),
    DeckChooserItem(0, Deck.ANAGLYPH),
    DeckChooserItem(0, Deck.PLASMA),
    DeckChooserItem(0, Deck.ERRATIC)
)