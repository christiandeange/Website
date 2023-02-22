package sh.christian.website.composable

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement
import sh.christian.website.sheet.MyResume.profileLink

@Composable
fun Link(content: ContentBuilder<HTMLDivElement>) {
  Div(attrs = { classes(profileLink) }) {
    content()
  }
}
