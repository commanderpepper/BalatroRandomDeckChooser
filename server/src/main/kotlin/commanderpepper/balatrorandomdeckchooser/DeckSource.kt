package commanderpepper.balatrorandomdeckchooser

import commanderpepper.balatrorandomdeckchooser.models.network.DeckNetwork

interface DeckSource {
    suspend fun getAllDecks(): List<DeckNetwork>

    suspend fun updateDeck(deckNetwork: DeckNetwork)

    fun saveDeck()
}