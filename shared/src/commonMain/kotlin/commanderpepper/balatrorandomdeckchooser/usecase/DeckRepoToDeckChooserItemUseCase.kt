package commanderpepper.balatrorandomdeckchooser.usecase

import commanderpepper.balatrorandomdeckchooser.models.Deck
import commanderpepper.balatrorandomdeckchooser.models.repo.DeckRepo
import commanderpepper.balatrorandomdeckchooser.models.ui.DeckChooserItem

class DeckRepoToDeckChooserItemUseCase(){
    operator fun invoke(deckRepo: DeckRepo): DeckChooserItem {
        val deck = getDeck(deckRepo.name)
        if(deck != null){
            return DeckChooserItem(count = deckRepo.count, deck = deck)
        }
        else{
            throw IllegalStateException("DeckRepoToDeckChooserItemUseCase $deck does not have a name that corresponds to a Deck")
        }
    }

    private fun getDeck(deckName: String): Deck? {
        return when(deckName){
            "red" -> Deck.RED
            "blue" -> Deck.BLUE
            "green" -> Deck.GREEN
            "yellow" -> Deck.YELLOW
            "black" -> Deck.BLACK
            "magic" -> Deck.MAGIC
            "nebula" -> Deck.NEBULA
            "ghost" -> Deck.GHOST
            "abandoned" -> Deck.ABANDONED
            "checkered" -> Deck.CHECKERED
            "zodiac" -> Deck.ZODIAC
            "painted" -> Deck.PAINTED
            "anaglyph" -> Deck.ANAGLYPH
            "plasma" -> Deck.PLASMA
            "erratic" -> Deck.ERRATIC
            else -> null
        }
    }
}