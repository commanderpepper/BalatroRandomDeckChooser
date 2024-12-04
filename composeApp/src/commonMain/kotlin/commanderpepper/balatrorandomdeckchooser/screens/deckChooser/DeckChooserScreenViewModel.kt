package commanderpepper.balatrorandomdeckchooser.screens.deckChooser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import commanderpepper.balatrorandomdeckchooser.models.ui.DeckChooserItem
import commanderpepper.balatrorandomdeckchooser.repo.DeckRepository
import commanderpepper.balatrorandomdeckchooser.usecase.DeckChooserItemToDeckRepoUseCase
import commanderpepper.balatrorandomdeckchooser.usecase.DeckRepoToDeckChooserItemUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class DeckChooserScreenViewModel(
    private val deckChooserItemToDeckRepoUseCase: DeckChooserItemToDeckRepoUseCase,
    private val deckRepoToDeckChooserItemUseCase: DeckRepoToDeckChooserItemUseCase,
    private val deckRepository: DeckRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DeckChooserScreenState>(DeckChooserScreenState.Loading)
    val uiState: StateFlow<DeckChooserScreenState> = _uiState

    init {
        viewModelScope.launch {
            updateUI()
        }
    }

    private suspend fun updateUI() {
        val decks = deckRepository.getDecks()
        if (decks.isNotEmpty()) {
            _uiState.value = DeckChooserScreenState.Success(decks.map { deckRepoToDeckChooserItemUseCase(it) })
        } else {
            _uiState.value = DeckChooserScreenState.Error
        }
    }

    fun chooseLeastPlayedRandomDeck() {
        viewModelScope.launch {
            val decks = deckRepository.getDecks()
            val least = decks.minOf { it.count }
            val leastDecks = decks.filter { it.count == least }
            val random = Random.nextInt(0, leastDecks.size)
            val randomDeck = leastDecks[random]
            deckRepository.updateDeck(randomDeck.copy(count = randomDeck.count + 1))
            updateUI()
        }
    }

    fun chooseRandomDeck() {
        viewModelScope.launch {
            val decks = deckRepository.getDecks()
            val randomDeck = decks.random()
            deckRepository.updateDeck(randomDeck.copy(count = randomDeck.count + 1))
            updateUI()
        }
    }
}

sealed class DeckChooserScreenState {
    data object Loading : DeckChooserScreenState()
    data object Error : DeckChooserScreenState()
    data class Success(val decks: List<DeckChooserItem>): DeckChooserScreenState()
}