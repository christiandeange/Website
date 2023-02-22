package sh.christian.website.composable

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement
import sh.christian.website.icon.PrintIcon
import sh.christian.website.sheet.ResumeApp.iconButton

@Composable
fun Icons(
  attrs: AttrBuilderContext<HTMLElement>? = null,
  onClick: (IconType) -> Unit,
) {
  Div(attrs) {
    Div(attrs = {
      classes(iconButton)
      onClick { onClick(IconType.Print) }
    }) {
      PrintIcon()
    }
  }
}

enum class IconType {
  Print,
}
