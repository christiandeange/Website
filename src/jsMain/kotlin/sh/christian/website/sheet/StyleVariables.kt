package sh.christian.website.sheet

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSStyleVariable
import org.jetbrains.compose.web.css.StylePropertyValue
import kotlin.properties.ReadOnlyProperty

object StyleVariables {
  val mdcThemeSecondary by variable<CSSColorValue>()
  val mdcThemeOnSecondary by variable<CSSColorValue>()
}

private val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()

fun <TValue : StylePropertyValue> variable() =
  ReadOnlyProperty<Any?, CSSStyleVariable<TValue>> { _, property ->
    val name = camelRegex.replace(property.name) { "-${it.value}" }.lowercase()
    CSSStyleVariable(name)
  }
