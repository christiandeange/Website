package sh.christian.website.sheet

import org.jetbrains.compose.web.css.CSSMediaQuery.MediaType
import org.jetbrains.compose.web.css.CSSMediaQuery.MediaType.Enum.Print
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.CSSUnitValueTyped
import org.jetbrains.compose.web.css.DisplayStyle.Companion.None
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.mediaMinWidth
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.overflow
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.plus
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.width

object ResumeApp : StyleSheet() {

  val myResume by style {
    width(100.percent - 64.px)
    height(100.percent)
    padding(0.px, 32.px)
    property("margin", "${0.px} $auto")

    media(mediaMinWidth((8.5.inches) + 64.px)) {
      self style {
        width(8.5.inches)
      }
    }

    media(MediaType(Print)) {
      self style {
        width(inherit)
        maxWidth("$inherit")
        maxHeight("$inherit")
        property("margin", "${0.px} $auto")
        overflow("$visible")
        position(Position.Absolute)
        top(0.px)
      }
    }
  }

  val icons by style {
    padding(32.px)
    position(Position.Fixed)

    media(MediaType(Print)) {
      self style {
        display(None)
      }
    }

    style(selector(".mdc-fab")) {
      padding(8.px)
    }
  }
}

private val Number.inches
  get(): CSSSizeValue<CSSUnit.px> = CSSUnitValueTyped(96 * this.toFloat(), CSSUnit.px)
