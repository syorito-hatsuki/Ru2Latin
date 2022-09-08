package dev.fstudio.ru2latin.util

import tornadofx.mapEach

object MainLogic {
    fun translateTextToLatin(string: String): String {
        var temp = string

//        DictionaryManager.lowerCaseWords.mapEach {
//            temp = temp.replace(key, value)
//        }
//
//        DictionaryManager.upperCaseWords.mapEach {
//            temp = temp.replace(key, value)
//        }

        return temp
    }
}

