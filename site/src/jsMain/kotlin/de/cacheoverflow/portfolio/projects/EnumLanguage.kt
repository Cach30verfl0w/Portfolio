package de.cacheoverflow.portfolio.projects

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color

enum class EnumLanguage(private val literal: String, val color: CSSColorValue) {
    JAVA("Java", Color.brown),
    CPP("C++", Color.blue),
    KOTLIN("Kotlin", Color.darkblue),
    RUST("Rust", Color.orange);
    
    override fun toString(): String = literal
}
