package commanderpepper.balatrorandomdeckchooser.network

import commanderpepper.balatrorandomdeckchooser.models.network.DeckNetwork

interface DeckDataSource {
    suspend fun getDecks(): List<DeckNetwork>

    suspend fun updateDeck(deck: DeckNetwork)
}