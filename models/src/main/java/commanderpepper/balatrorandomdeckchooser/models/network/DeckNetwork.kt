package commanderpepper.balatrorandomdeckchooser.models.network

import kotlinx.serialization.Serializable

@Serializable
data class DeckNetwork(val name: String, val count: Int)
