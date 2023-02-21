package sh.christian.website.composable

import androidx.compose.runtime.Composable
import dev.petuska.kmdc.fab.MDCFab
import dev.petuska.kmdc.fab.MDCFabType
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement
import sh.christian.website.icon.PrintIcon

@Composable
fun Icons(
  attrs: AttrBuilderContext<HTMLElement>? = null,
  onClick: (IconType) -> Unit,
) {
  Div(attrs) {
    MDCFab(
      type = MDCFabType.Mini,
      attrs = {
        onClick { onClick(IconType.Print) }
      }
    ) {
      PrintIcon()
    }
  }
}

enum class IconType {
  Print,
}
