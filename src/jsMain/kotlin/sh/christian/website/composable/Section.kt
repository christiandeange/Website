package sh.christian.website.composable

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import sh.christian.website.sheet.MyResume.header

@Composable
fun Section(
  name: String,
  content: @Composable () -> Unit,
) {
  Div(attrs = { classes(header) }) { Text(name.lowercase()) }

  content()
}
