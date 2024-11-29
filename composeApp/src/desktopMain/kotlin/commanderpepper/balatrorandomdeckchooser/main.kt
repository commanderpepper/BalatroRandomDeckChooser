package commanderpepper.balatrorandomdeckchooser

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Balatro Random Deck Chooser",
    ) {
        App()
    }
}