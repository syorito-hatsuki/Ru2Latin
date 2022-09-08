package dev.fstudio.ru2latin.util

import dev.fstudio.ru2latin.dto.DictionaryConfig
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.nio.file.Paths

object DictionaryManager {
    private val json = Json { encodeDefaults = true; prettyPrint = true; ignoreUnknownKeys = true }
    private val configDir: File = Paths.get("", "config", "dictionary").toFile()
    private val configFile = File(configDir, "config.json")

    init {
        if (!configFile.exists()) {
            if (!configDir.exists()) configDir.mkdirs()
            configFile.apply {
                createNewFile()
                writeText(json.encodeToString(DictionaryConfig()))
            }
        } else configFile.writeText(json.encodeToString(read()))
    }

    fun read(): DictionaryConfig {
        return json.decodeFromString(configFile.readText())
    }
}