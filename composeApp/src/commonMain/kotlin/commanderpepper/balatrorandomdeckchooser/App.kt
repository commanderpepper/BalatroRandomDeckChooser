package commanderpepper.balatrorandomdeckchooser

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import commanderpepper.balatrorandomdeckchooser.screens.deckChooser.DeckChooserScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        DeckChooserScreen()
    }
}