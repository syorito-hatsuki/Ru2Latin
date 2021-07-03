package dev.fstudio.ru2latin

import dev.fstudio.ru2latin.view.MainView
import javafx.stage.Stage
import tornadofx.*

fun main() {
    launch<Application>()
}

class Application: App(MainView::class) {
    override fun start(stage: Stage) {

        stage.isResizable = false
        stage.width = 640.0
        stage.height = 260.0

        super.start(stage)
    }
}