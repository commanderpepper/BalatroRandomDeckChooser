package commanderpepper.balatrorandomdeckchooser.usecase

import commanderpepper.balatrorandomdeckchooser.models.network.DeckNetwork
import commanderpepper.balatrorandomdeckchooser.models.repo.DeckRepo

class DeckRepoToDeckNetworkUseCase {
    operator fun invoke(deckRepo: DeckRepo): DeckNetwork {
        return DeckNetwork(
            name = deckRepo.name,
            count = deckRepo.count,
        )
    }
}