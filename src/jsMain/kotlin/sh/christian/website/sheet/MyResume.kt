package sh.christian.website.sheet

import org.jetbrains.compose.web.css.CSSBuilder
import org.jetbrains.compose.web.css.CSSMediaQuery.MediaType
import org.jetbrains.compose.web.css.CSSMediaQuery.MediaType.Enum.Screen
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Block
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Inline
import org.jetbrains.compose.web.css.DisplayStyle.Companion.InlineBlock
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.and
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.flex
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontStyle
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.lineHeight
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.mediaMaxWidth
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.textDecoration
import org.jetbrains.compose.web.css.width

object MyResume : StyleSheet() {

  val resumeHeader by style {
    padding(20.px, 0.px)
    height(auto)
    display(Block)

    centeredOnPhone(default = "right")
  }

  val name by style {
    width(100.percent)
    paddingTop(50.px)
    fontSize(3.em)
    fontWeight(300)
    fontFamily("Roboto Slab", "Lato", "Roboto", "Helvetica Neue", "Helvetica", "Arial", "sans-serif")

    centeredOnPhone(default = "right")
  }

  val links by style {
    margin(20.px, 0.px, 0.px, 0.px)

    centeredOnPhone(default = "right")

    style(type("svg")) {
      padding(5.px)
      marginLeft(20.px)
      marginRight(5.px)
      fontStyle("normal")
      color(Color.black)
    }

    style(selector("*")) {
      display(InlineBlock)
      height(20.px)
      property("vertical-align", "middle")
    }
  }

  val profileLink by style {
    padding(10.px, 0.px)
    display(Inline)
    onPhone {
      display(Block)
    }
  }

  val header by style {
    fontSize(1.3.em)
    textDecoration("none")
    color(Color("#555555"))
    fontWeight(300)
    marginTop(30.px)
    marginBottom(10.px)

    centeredOnPhone(default = "left")
  }

  val job by style {
    fontSize(0.8.em)
    lineHeight(1.5.em)
  }

  val skill by style {
    width(96.px)
    display(InlineBlock)
  }

  val inforow by style {
    display(Flex)

    onPhone {
      display(Block)
    }
  }

  val infocolumn by style {
    display(InlineBlock)
    property("vertical-align", "text-top")

    centeredOnPhone(default = "left")
  }

  val phoneCentered by style {
    centeredOnPhone(default = "left")
  }

  val flex1 by style { flex(1) }
  val flex2 by style { flex(2) }
  val flex3 by style { flex(3) }
  val flex4 by style { flex(4) }
  val flex5 by style { flex(5) }
  val flex6 by style { flex(6) }
  val flex7 by style { flex(7) }
  val flex8 by style { flex(8) }
  val flex9 by style { flex(9) }
  val flex10 by style { flex(10) }

  val point by style {
    display(Block)
    fontWeight(400)
  }

  val position by style {
    fontWeight(500)
    marginRight(10.px)
  }

  val date by style {
    color(Color("#595959"))
    fontStyle("italic")
  }
}

private inline fun CSSBuilder.onPhone(crossinline builder: CSSBuilder.() -> Unit) {
  media(MediaType(Screen) and mediaMaxWidth(699.px)) {
    self style {
      builder()
    }
  }
}

private fun CSSBuilder.centeredOnPhone(default: String) {
  textAlign(default)

  onPhone {
    textAlign("center")
  }
}
