package commanderpepper.balatrorandomdeckchooser

import android.app.Application
import commanderpepper.balatrorandomdeckchooser.network.di.networkModule
import commanderpepper.balatrorandomdeckchooser.repo.di.repoModule
import commanderpepper.balatrorandomdeckchooser.screens.deckChooser.di.deckChooserScreenModule
import commanderpepper.balatrorandomdeckchooser.usecase.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(repoModule, networkModule, useCaseModule, deckChooserScreenModule))
        }
    }
}