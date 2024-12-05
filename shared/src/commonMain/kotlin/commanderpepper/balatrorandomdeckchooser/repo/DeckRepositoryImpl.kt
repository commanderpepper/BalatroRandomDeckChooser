package commanderpepper.balatrorandomdeckchooser.repo

import commanderpepper.balatrorandomdeckchooser.models.repo.DeckRepo
import commanderpepper.balatrorandomdeckchooser.network.DeckDataSource
import commanderpepper.balatrorandomdeckchooser.usecase.DeckNetworkToDeckRepoUseCase
import commanderpepper.balatrorandomdeckchooser.usecase.DeckRepoToDeckNetworkUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DeckRepositoryImpl(
    private val deckDataSource: DeckDataSource,
    private val deckNetworkToDeckRepoUseCase: DeckNetworkToDeckRepoUseCase,
    private val deckRepoToDeckNetworkUseCase: DeckRepoToDeckNetworkUseCase) : DeckRepository {

    private val decks = flow<List<DeckRepo>> {
        while (true) {
            emit(deckDataSource.getDecks().map { deckNetworkToDeckRepoUseCase(it) })
            delay(1500)
        }
    }

    override fun getDecks(): Flow<List<DeckRepo>> {
        return decks
    }

    override suspend fun chooseRandomDeck() {
        val decksToChooseFrom = deckDataSource.getDecks().map { deckNetworkToDeckRepoUseCase(it) }
        val randomDeck = decksToChooseFrom.random()
        updateDeck(randomDeck.copy(count = randomDeck.count + 1))
    }

    override suspend fun chooseLeastRandomDeck() {
        val decksToChooseFrom = deckDataSource.getDecks().map { deckNetworkToDeckRepoUseCase(it) }
        val least = decksToChooseFrom.minOf { it.count }
        val leastDecks = decksToChooseFrom.filter { it.count == least }
        val randomDeck = leastDecks.random()
        updateDeck(randomDeck.copy(count = randomDeck.count + 1))
    }

    private suspend fun updateDeck(deck: DeckRepo) {
        val deckNetwork = deckRepoToDeckNetworkUseCase(deck)
        deckDataSource.updateDeck(deckNetwork)
    }
}