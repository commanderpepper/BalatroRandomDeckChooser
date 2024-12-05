package commanderpepper.balatrorandomdeckchooser.repo

import commanderpepper.balatrorandomdeckchooser.models.repo.DeckRepo
import kotlinx.coroutines.flow.Flow

interface DeckRepository {

    fun getDecks(): Flow<List<DeckRepo>>

    suspend fun chooseRandomDeck()

    suspend fun chooseLeastRandomDeck()
}