package commanderpepper.balatrorandomdeckchooser.repo.di

import commanderpepper.balatrorandomdeckchooser.repo.DeckRepository
import commanderpepper.balatrorandomdeckchooser.repo.DeckRepositoryImpl
import org.koin.dsl.module

val repoModule = module {
    single<DeckRepository> { DeckRepositoryImpl(get(), get(), get()) }
}