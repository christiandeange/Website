package sh.christian.website.sheet

import org.jetbrains.compose.web.css.CSSKeywordValue
import org.jetbrains.compose.web.css.keywords.CSSAutoKeyword

inline val inherit: CSSAutoKeyword
  get() = CSSKeywordValue("inherit").unsafeCast<CSSAutoKeyword>()

inline val visible: CSSAutoKeyword
  get() = CSSKeywordValue("visible").unsafeCast<CSSAutoKeyword>()
