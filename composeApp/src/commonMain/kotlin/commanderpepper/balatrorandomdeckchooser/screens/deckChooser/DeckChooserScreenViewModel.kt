package commanderpepper.balatrorandomdeckchooser.screens.deckChooser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import commanderpepper.balatrorandomdeckchooser.models.ui.DeckChooserItem
import commanderpepper.balatrorandomdeckchooser.repo.DeckRepository
import commanderpepper.balatrorandomdeckchooser.usecase.DeckChooserItemToDeckRepoUseCase
import commanderpepper.balatrorandomdeckchooser.usecase.DeckRepoToDeckChooserItemUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DeckChooserScreenViewModel(
    private val deckChooserItemToDeckRepoUseCase: DeckChooserItemToDeckRepoUseCase,
    private val deckRepoToDeckChooserItemUseCase: DeckRepoToDeckChooserItemUseCase,
    private val deckRepository: DeckRepository
) : ViewModel() {

    val uiState = deckRepository.getDecks().map { decks ->
        if(decks.isNotEmpty()){
            DeckChooserScreenState.Success(decks.map { deckRepoToDeckChooserItemUseCase(it) })
        }
        else {
            DeckChooserScreenState.Error
        }
    }.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000L), DeckChooserScreenState.Loading
    )


    fun chooseLeastPlayedRandomDeck() {
        viewModelScope.launch {
            deckRepository.chooseLeastRandomDeck()
        }
    }

    fun chooseRandomDeck() {
        viewModelScope.launch {
            deckRepository.chooseRandomDeck()
        }
    }
}

sealed class DeckChooserScreenState {
    data object Loading : DeckChooserScreenState()
    data object Error : DeckChooserScreenState()
    data class Success(val decks: List<DeckChooserItem>): DeckChooserScreenState()
}