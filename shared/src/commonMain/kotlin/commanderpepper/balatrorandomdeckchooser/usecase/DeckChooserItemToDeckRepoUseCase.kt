package commanderpepper.balatrorandomdeckchooser.usecase

import commanderpepper.balatrorandomdeckchooser.models.repo.DeckRepo
import commanderpepper.balatrorandomdeckchooser.models.ui.DeckChooserItem

class DeckChooserItemToDeckRepoUseCase {
    operator fun invoke(deckChooserItem: DeckChooserItem): DeckRepo {
        return DeckRepo(name = deckChooserItem.deck.deckName, count = deckChooserItem.count)
    }
}