package commanderpepper.balatrorandomdeckchooser.repo

import commanderpepper.balatrorandomdeckchooser.models.repo.DeckRepo

interface DeckRepository {
    suspend fun getDecks(): List<DeckRepo>

    suspend fun updateDeck(deck: DeckRepo)
}