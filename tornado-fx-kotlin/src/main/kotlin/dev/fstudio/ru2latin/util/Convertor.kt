package dev.fstudio.ru2latin.util

object Convertor {
    fun translateTextToLatin(inputString: String): String {
        var outputString = inputString
        DictionaryManager.read().charterDictionary.forEach { (key, value) ->
            outputString = outputString.replace(key, value)
        }
        return outputString
    }
}

