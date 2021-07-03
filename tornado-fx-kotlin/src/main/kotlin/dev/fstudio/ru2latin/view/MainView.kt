package dev.fstudio.ru2latin.view

import javafx.scene.control.TextArea
import javafx.scene.layout.Priority
import tornadofx.*

class MainView : View() {

    private var inputTextArea: TextArea by singleAssign()
    private var outputTextArea: TextArea by singleAssign()

    private val upperCaseWords = mutableMapOf(
        "А" to "A",
        "Б" to "D",
        "В" to "B",
        "Г" to "L",
        "Д" to "Z",
        "Е" to "E",
        "Ё" to "É",
        "Ж" to "V",
        "З" to "3",
        "И" to "N",
        "Й" to "Ń",
        "К" to "K",
        "Л" to "S",
        "М" to "M",
        "Н" to "H",
        "О" to "O",
        "П" to "U",
        "Р" to "P",
        "С" to "C",
        "Т" to "T",
        "У" to "Q",
        "Ф" to "Y",
        "Х" to "X",
        "Ц" to "ẞ",
        "Ч" to "J",
        "Ш" to "W",
        "Щ" to "Ę",
        "Ъ" to "Ż",
        "Ы" to "FI",
        "Ь" to "F",
        "Э" to "G",
        "Ю" to "Ź",
        "Я" to "R",
    )
    private val lowerCaseWords = mutableMapOf(
        "а" to "a",
        "б" to "d",
        "в" to "ß",
        "г" to "r",
        "д" to "g",
        "е" to "e",
        "ё" to "é",
        "ж" to "w",
        "з" to "h",
        "и" to "u",
        "й" to "ü",
        "к" to "k",
        "л" to "n",
        "м" to "m",
        "н" to "ń",
        "о" to "o",
        "п" to "b",
        "р" to "p",
        "с" to "c",
        "т" to "t",
        "у" to "y",
        "ф" to "♫",
        "х" to "x",
        "ц" to "ę",
        "ч" to "z",
        "ш" to "s",
        "щ" to "q",
        "ъ" to "ź",
        "ы" to "łl",
        "ь" to "ł",
        "э" to "ć",
        "ю" to "v",
        "я" to "ä"
    )

    override val root = vbox {
        hbox {
            inputTextArea = textarea {
                hboxConstraints {
                    marginLeft = 8.0
                    marginRight = 4.0
                    marginTopBottom(8.0)
                    hgrow = Priority.ALWAYS
                }
            }
            outputTextArea = textarea {
                hboxConstraints {
                    marginLeft = 4.0
                    marginRight = 8.0
                    marginTopBottom(8.0)
                    hgrow = Priority.ALWAYS
                }
            }
            fitToParentHeight()
        }
        button {
            text = "Translate"
            fitToParentWidth()
            action {
                setOnMouseClicked {
                    outputTextArea.text = translateTextToLatin(inputTextArea.text)
                }
            }
            vboxConstraints {
                marginBottom = 8.0
                marginLeftRight(8.0)
                vgrow = Priority.ALWAYS
            }
        }
    }

    private fun translateTextToLatin(string: String): String {

        var out = string

        lowerCaseWords.mapEach {
            out = out.replace(key, value)
        }

        upperCaseWords.mapEach {
            out = out.replace(key, value)
        }

        return out
    }
}