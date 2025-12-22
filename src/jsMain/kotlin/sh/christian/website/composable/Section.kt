package sh.christian.website.composable

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement
import sh.christian.website.sheet.MyResume.header

@Composable
fun Section(
  name: String,
  childAttrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: @Composable () -> Unit,
) {
  Div(attrs = { classes(header) }) { Text(name.lowercase()) }

  Div(attrs = childAttrs) {
    content()
  }
}
