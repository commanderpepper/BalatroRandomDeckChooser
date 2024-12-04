package commanderpepper.balatrorandomdeckchooser.screens.deckChooser.di

import commanderpepper.balatrorandomdeckchooser.screens.deckChooser.DeckChooserScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val deckChooserScreenModule = module {
    viewModel { DeckChooserScreenViewModel(get(), get(), get()) }
}