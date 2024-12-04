package commanderpepper.balatrorandomdeckchooser.network

import commanderpepper.balatrorandomdeckchooser.models.network.DeckNetwork
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class DeckDataSourceImpl(private val client: HttpClient) : DeckDataSource {
    override suspend fun getDecks(): List<DeckNetwork> {
        val body = client.get("/decks").body<List<DeckNetwork>>()
        return body
    }

    override suspend fun updateDeck(deck: DeckNetwork) {
        client.post("/deck"){
            contentType(ContentType.Application.Json)
            setBody(deck)
        }
    }
}