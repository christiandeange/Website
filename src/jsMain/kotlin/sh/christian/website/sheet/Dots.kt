package sh.christian.website.sheet

import org.jetbrains.compose.web.css.DisplayStyle.Companion.Inline
import org.jetbrains.compose.web.css.DisplayStyle.Companion.InlineBlock
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width

object Dots : StyleSheet() {
  val dotContainer by style {
    display(Inline)
  }

  val dot by style {
    property("-webkit-print-color-adjust", "exact")
    display(InlineBlock)
    borderRadius(50.percent)
    marginLeft(6.px)
    width(12.px)
    height(12.px)
  }
}
