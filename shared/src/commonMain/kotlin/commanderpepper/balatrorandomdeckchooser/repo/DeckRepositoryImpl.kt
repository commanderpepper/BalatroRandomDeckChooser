package commanderpepper.balatrorandomdeckchooser.repo

import commanderpepper.balatrorandomdeckchooser.models.repo.DeckRepo
import commanderpepper.balatrorandomdeckchooser.network.DeckDataSource
import commanderpepper.balatrorandomdeckchooser.usecase.DeckNetworkToDeckRepoUseCase
import commanderpepper.balatrorandomdeckchooser.usecase.DeckRepoToDeckNetworkUseCase

class DeckRepositoryImpl(
    private val deckDataSource: DeckDataSource,
    private val deckNetworkToDeckRepoUseCase: DeckNetworkToDeckRepoUseCase,
    private val deckRepoToDeckNetworkUseCase: DeckRepoToDeckNetworkUseCase) : DeckRepository {
    override suspend fun getDecks(): List<DeckRepo> {
        return deckDataSource.getDecks().map { deckNetworkToDeckRepoUseCase(it) }
    }

    override suspend fun updateDeck(deck: DeckRepo) {
        val deckNetwork = deckRepoToDeckNetworkUseCase(deck)
        deckDataSource.updateDeck(deckNetwork)
    }
}