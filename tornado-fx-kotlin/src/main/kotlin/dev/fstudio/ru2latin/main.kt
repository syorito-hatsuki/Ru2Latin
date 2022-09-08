package dev.fstudio.ru2latin

import dev.fstudio.ru2latin.view.MainView
import javafx.stage.Stage
import tornadofx.*

fun main() {
    launch<Application>()
}

class Application : App(MainView::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.minHeight = 150.0
        stage.minWidth = 150.0
    }
}