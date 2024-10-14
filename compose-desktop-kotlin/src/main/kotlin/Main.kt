
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.syoritohatuki.ru2latin.util.Convertor

fun main() = application {
    val (input, setInput) = remember { mutableStateOf("") }
    val (output, setOutput) = remember { mutableStateOf("") }

    LaunchedEffect(input) {
        setOutput(Convertor.translateTextToLatin(input))
    }

    Window(onCloseRequest = ::exitApplication, title = "Ru2Latin") {
        MaterialTheme {
            Surface(
                modifier = Modifier.padding(8.dp).fillMaxSize(),
                color = MaterialTheme.colors.surface
            ) {
                Row(modifier = Modifier.fillMaxSize()) {
                    TextField(
                        modifier = Modifier.fillMaxSize().weight(1f).padding(end = 8.dp),
                        value = input,
                        onValueChange = { setInput(it) })
                    TextField(
                        modifier = Modifier.fillMaxSize().weight(1f),
                        value = output,
                        onValueChange = {},
                        readOnly = true
                    )
                }
            }
        }
    }
}
