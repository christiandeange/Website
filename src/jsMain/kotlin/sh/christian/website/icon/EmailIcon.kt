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
fun EmailIcon() {
  Svg(attrs = {
    viewBox("0 0 24 24")
  }) {
    Title("Email")
    Path(
      d = "M20 4H4c-1.1 0-1.99.9-1.99 2L2 18c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2zm0 4l-8 5-8-5V6l8 5 8-5v2z",
      attrs = {
        fill("#000000")
      },
    )
  }
}
