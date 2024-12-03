import commanderpepper.balatrorandomdeckchooser.network.DeckDataSourceImpl
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

class DeckDataSourceTest {
    @Test
    fun getDecksTest(){
        runBlocking {
            val mockEngine = MockEngine { request ->
                respond(
                    content = ByteReadChannel(
                        """
                [
                  {
                    "name": "red",
                    "count": 0
                  }
                ]
                """.trimIndent()
                    ),
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            }
            val client = HttpClient(mockEngine) {
                install(ContentNegotiation) {
                    json()
                }
            }
            val source = DeckDataSourceImpl(client)
            val decks = source.getDecks()
            assertTrue(decks.isNotEmpty())
        }
    }
}