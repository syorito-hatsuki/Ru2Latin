package dev.fstudio.ru2latin.view

import dev.fstudio.ru2latin.util.Convertor
import javafx.scene.control.TextArea
import tornadofx.*

class MainView : View() {

    private var inputTextArea: TextArea by singleAssign()
    private var outputTextArea: TextArea by singleAssign()

    override val root = vbox {
        hbox {
            inputTextArea = textarea {
                hboxConstraints {
                    marginLeft = 8.0
                    marginRight = 4.0
                    marginTopBottom(8.0)
                }
                setOnKeyReleased { outputTextArea.text = Convertor.translateTextToLatin(inputTextArea.text) }
                isWrapText = true
            }
            outputTextArea = textarea {
                hboxConstraints {
                    marginLeft = 4.0
                    marginRight = 8.0
                    marginTopBottom(8.0)
                }
                isWrapText = true
                isEditable = false
            }
            fitToParentHeight()
        }
    }
}