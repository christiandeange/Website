package sh.christian.website.sheet

import org.jetbrains.compose.web.css.CSSMediaQuery.MediaType
import org.jetbrains.compose.web.css.CSSMediaQuery.MediaType.Enum.Print
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textDecoration
import org.jetbrains.compose.web.css.textDecorationLine
import org.jetbrains.compose.web.css.textDecorationStyle
import org.jetbrains.compose.web.css.textDecorationThickness
import org.jetbrains.compose.web.css.width

object App : StyleSheet() {
  init {
    "@page" style {
      margin(0.px)
    }

    group(type("html"), type("body")) style {
      width(100.percent)
      height(100.percent)
      margin(0.px)
      padding(0.px)
      color(Color("#333333"))
    }

    type("body") style {
      overflow("visible")
      fontFamily("Roboto", "Helvetica Neue", "Helvetica", "Arial", "sans-serif")
    }

    type("a") style {
      textDecoration("underline")
      textDecorationStyle("dashed")
      textDecorationLine("underline")
      textDecorationThickness("1px")
      property("text-underline-position", "under")
      color(Color("#333333"))
    }

    media(MediaType(Print)) {
      type("a") style {
        textDecoration("none")
      }
    }
  }
}
