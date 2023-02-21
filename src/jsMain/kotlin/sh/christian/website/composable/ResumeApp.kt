package sh.christian.website.composable

import androidx.compose.runtime.Composable
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement
import sh.christian.website.composable.IconType.Print
import sh.christian.website.sheet.ResumeApp
import sh.christian.website.sheet.ResumeApp.icons
import sh.christian.website.sheet.ResumeApp.myResume

@Composable
fun ResumeApp(
  attrs: AttrBuilderContext<HTMLElement>? = null,
) {
  Style(ResumeApp)

  Div(attrs) {
    Icons(
      attrs = { classes(icons) },
      onClick = {
        when (it) {
          Print -> {
            window.setTimeout({ window.print() }, 420)
          }
        }
      },
    )

    MyResume(
      attrs = { classes(myResume) },
    )
  }
}
