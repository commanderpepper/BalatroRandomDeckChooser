package commanderpepper.balatrorandomdeckchooser.usecase.di

import commanderpepper.balatrorandomdeckchooser.usecase.DeckNetworkToDeckRepoUseCase
import commanderpepper.balatrorandomdeckchooser.usecase.DeckRepoToDeckNetworkUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { DeckNetworkToDeckRepoUseCase() }
    single { DeckRepoToDeckNetworkUseCase() }
}