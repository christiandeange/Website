package sh.christian.website.composable

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.dom.Div
import sh.christian.website.sheet.Dots
import sh.christian.website.sheet.Dots.dotContainer

@Composable
fun Dots(
  vararg dots: Dot,
) {
  Div(attrs = { classes(dotContainer) }) {
    Style(Dots)

    dots.forEach { dot ->
      Div(
        attrs = {
          classes(Dots.dot)
          style {
            backgroundColor(dot.color)
          }
        },
      )
    }
  }
}

class Dot(val color: CSSColorValue)

object StandardDots {
  val grey = Dot(Color("#D2D2D2"))
  val blue = Dot(Color("#3696D2"))
}
