package sh.christian.website.icon

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.svg.Path
import org.jetbrains.compose.web.svg.Svg
import org.jetbrains.compose.web.svg.Title
import org.jetbrains.compose.web.svg.fill
import org.jetbrains.compose.web.svg.viewBox

@OptIn(ExperimentalComposeWebSvgApi::class)
@Composable
fun PrintIcon() {
  Svg(attrs = {
    viewBox("0 0 24 24")
  }) {
    Title("Print")
    Path(
      d = "M0 0h24v24H0z",
      attrs = { fill("none") },
    )
    Path(
      d = "M19 8H5c-1.66 0-3 1.34-3 3v6h4v4h12v-4h4v-6c0-1.66-1.34-3-3-3zm-3 11H8v-5h8v5zm3-7c-.55 0-1-.45-1-1s.45-1 1-1 1 .45 1 1-.45 1-1 1zm-1-9H6v4h12V3z",
      attrs = { fill("#000000") },
    )
  }
}
