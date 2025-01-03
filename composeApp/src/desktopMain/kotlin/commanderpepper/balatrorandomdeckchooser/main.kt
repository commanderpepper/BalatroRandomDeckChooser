package commanderpepper.balatrorandomdeckchooser

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import commanderpepper.balatrorandomdeckchooser.network.di.networkModule
import commanderpepper.balatrorandomdeckchooser.repo.di.repoModule
import commanderpepper.balatrorandomdeckchooser.screens.deckChooser.di.deckChooserScreenModule
import commanderpepper.balatrorandomdeckchooser.usecase.di.useCaseModule
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(listOf(repoModule, networkModule, useCaseModule, deckChooserScreenModule))
    }
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Balatro Random Deck Chooser",
        ) {
            App()
        }
    }
}