package sh.christian.website

import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import sh.christian.website.composable.ResumeApp
import sh.christian.website.sheet.App

fun main() {
  renderComposable(rootElementId = "root") {
    Style(App)
    ResumeApp()
  }
}
