package commanderpepper.balatrorandomdeckchooser.usecase

import commanderpepper.balatrorandomdeckchooser.models.network.DeckNetwork
import commanderpepper.balatrorandomdeckchooser.models.repo.DeckRepo

class DeckNetworkToDeckRepoUseCase {
    operator fun invoke(deckNetwork: DeckNetwork): DeckRepo {
        return DeckRepo(
            name = deckNetwork.name,
            count = deckNetwork.count
        )
    }
}