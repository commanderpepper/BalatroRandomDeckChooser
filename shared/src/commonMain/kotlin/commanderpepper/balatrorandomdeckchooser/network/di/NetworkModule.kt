package commanderpepper.balatrorandomdeckchooser.network.di

import commanderpepper.balatrorandomdeckchooser.network.DeckDataSource
import commanderpepper.balatrorandomdeckchooser.network.DeckDataSourceImpl
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single<DeckDataSource> { DeckDataSourceImpl(client = get()) }
    single {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            explicitNulls = false
            prettyPrint = true
        }
    }
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(get())
            }
            install(HttpCache)
            install(Logging) {
                level = LogLevel.ALL
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTP
//                    host = "10.0.2.2:8080" // Android
                    host = "127.0.0.1:8080" // desktop
                    path("/")
                }
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }
}