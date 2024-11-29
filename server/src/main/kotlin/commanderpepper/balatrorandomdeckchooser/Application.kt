package commanderpepper.balatrorandomdeckchooser

import commanderpepper.balatrorandomdeckchooser.models.network.DeckNetwork
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.JsonConvertException
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationStopped
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json

private val deckSource: DeckSource = DeckSourceImpl()

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
        .application.monitor.subscribe(ApplicationStopped){
            deckSource.saveDeck()
        }
}

fun Application.module() {
    install(ContentNegotiation){
        json(
            Json {
                prettyPrint = true
                isLenient = true
            }
        )
    }
    routing {
        get("/") {
            call.respondText("Ktor: ${Greeting().greet()}")
        }
        get("/decks") {
            val decks = deckSource.getAllDecks()
            call.respond(decks)
        }
        post("/deck") {
            try {
                val deckNetwork = call.receive<DeckNetwork>()
                deckSource.updateDeck(deckNetwork)
                call.respond(HttpStatusCode.NoContent)
            } catch (ex: IllegalStateException) {
                call.respond(HttpStatusCode.BadRequest)
            } catch (ex: JsonConvertException) {
                call.respond(HttpStatusCode.BadRequest)
            }
        }
    }
}