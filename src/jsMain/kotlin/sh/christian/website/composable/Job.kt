package sh.christian.website.composable

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement
import sh.christian.website.sheet.MyResume.date
import sh.christian.website.sheet.MyResume.job
import sh.christian.website.sheet.MyResume.phoneCentered
import sh.christian.website.sheet.MyResume.point
import sh.christian.website.sheet.MyResume.position

@Composable
fun Job(
  place: String,
  time: String,
  content: @Composable JobContext.() -> Unit = {},
) {
  Job({ Text(place) }, time, content)
}

@Composable
fun Job(
  place: @Composable () -> Unit,
  time: String,
  content: @Composable JobContext.() -> Unit = {},
) {
  Div(attrs = { classes(phoneCentered) }) {
    Span(attrs = { classes(job, position) }) {
      place()
    }
    Span(attrs = { classes(job, date) }) {
      Text(time)
    }
  }

  with(JobContext) {
    content()
  }

  Br()
}

object JobContext {
  @Composable
  fun Point(text: String) {
    Div(attrs = { classes(job, point, phoneCentered) }) {
      Text(text)
    }
  }

  @Composable
  fun Point(content: ContentBuilder<HTMLDivElement>) {
    Div(attrs = { classes(job, point, phoneCentered) }, content)
  }
}
