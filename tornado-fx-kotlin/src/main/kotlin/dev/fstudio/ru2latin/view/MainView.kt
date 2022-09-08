package dev.fstudio.ru2latin.view

import dev.fstudio.ru2latin.util.MainLogic
import javafx.scene.control.TextArea
import javafx.scene.layout.Priority
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
                isEditable = false
            }
            fitToParentHeight()
        }
        button {
            text = "Convert"
            fitToParentWidth()
            action {
                setOnMouseClicked {
                    outputTextArea.text = MainLogic.translateTextToLatin(inputTextArea.text)
                }
            }
            vboxConstraints {
                marginBottom = 8.0
                marginLeftRight(8.0)
                vgrow = Priority.ALWAYS
            }
        }
    }
}