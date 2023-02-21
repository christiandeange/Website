package sh.christian.website.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import sh.christian.website.composable.StandardDots.blue
import sh.christian.website.composable.StandardDots.grey
import sh.christian.website.sheet.MyResume.job
import sh.christian.website.sheet.MyResume.point
import sh.christian.website.sheet.MyResume.skill

@Composable
fun Skill(
  name: String,
  skillLevel: Int,
) {
  Div(attrs = { classes(job, point) }) {
    Div(attrs = { classes(skill) }) { Text(name.lowercase()) }

    val dots = remember(skillLevel) {
      Array(5) { i ->
        if (i >= skillLevel) {
          grey
        } else {
          blue
        }
      }
    }
    Dots(*dots)
  }
}
