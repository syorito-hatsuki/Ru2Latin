package dev.fstudio.ru2latin

import dev.fstudio.ru2latin.dto.DictionaryConfig
import dev.fstudio.ru2latin.view.MainView
import javafx.stage.Stage
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import tornadofx.*
import java.io.File

fun main() {
    launch<Application>()
}

class Application : App(MainView::class) {
    private val json = Json { ignoreUnknownKeys = true; prettyPrint = true; encodeDefaults = true }

    override fun start(stage: Stage) {

        File("dict.json").apply {
            createNewFile()
            writeText(json.encodeToString(DictionaryConfig()))
        }

        stage.isResizable = false
        stage.width = 640.0
        stage.height = 260.0

        super.start(stage)
    }
}