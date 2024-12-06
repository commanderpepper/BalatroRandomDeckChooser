package commanderpepper.balatrorandomdeckchooser

import commanderpepper.balatrorandomdeckchooser.models.network.DeckNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Paths
import kotlin.time.Duration.Companion.minutes

class DeckSourceImpl(private val applicationScope : CoroutineScope) : DeckSource {

    private val path = Paths.get("").toAbsolutePath().toString()
    private val file = File("$path/src/main/resources/deckrecord.json")
    private val fileString = file.readText(Charset.defaultCharset())
    private val map = Json.decodeFromString<Map<String, Int>>(fileString).toMutableMap()

    init {
        applicationScope.launch {
            while (true){
                delay(5.minutes)
                saveDeck()
            }
        }
    }

    override suspend fun getAllDecks(): List<DeckNetwork> {
        return map.map { DeckNetwork(it.key, it.value) }
    }

    override suspend fun updateDeck(deckNetwork: DeckNetwork) {
        map[deckNetwork.name] = deckNetwork.count
    }

    override fun saveDeck() {
        val jsonMap = map.mapValues { (k, v) -> JsonPrimitive(v) }
        val jsonObject = JsonObject(jsonMap)
        file.writeText(jsonObject.toString())
    }

}