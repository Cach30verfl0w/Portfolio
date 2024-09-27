package de.cacheoverflow.portfolio.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import de.cacheoverflow.portfolio.background
import de.cacheoverflow.portfolio.projects.EnumLanguage
import de.cacheoverflow.portfolio.projects.Project
import de.cacheoverflow.portfolio.toColorScheme
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProjectEntry(project: Project) {
    val palette = ColorMode.current.toColorScheme()
    Box(Modifier.background(palette.secondary).fillMaxWidth().borderRadius(10.px).maxWidth(500.px)
        .boxShadow(BoxShadow.of(blurRadius = 3.px)).onClick {
            if (project.url != null) {
                window.location.href = project.url
            }
        }) {
        Column(Modifier.padding(10.px).gap(1.cssRem).height(200.px)) {
            Row(modifier = Modifier.gap(0.25.cssRem), verticalAlignment = Alignment.CenterVertically) {
                if (project.icon != null) {
                    Image(
                        src = project.icon,
                        alt = "${project.name} Project Icon",
                        modifier = Modifier.width(20.px).height(20.px)
                    )
                }
                Text(project.name)
            }
            Text(project.description)
        }
    }
}

@Composable
fun ProjectList() {
    val projects = listOf(
        Project(
            name = "Krypton",
            icon = "/krypton.png",
            url = "https://git.karmakrafts.dev/kk/evince-project/krypton",
            languages = listOf(EnumLanguage.KOTLIN),
            description = "Library that implements the cryptographic primitives into Kotlin Multiplatform"
        ),
        Project(
            name = "kstd-platform",
            icon = "/karma.png",
            url = "https://github.com/karmakrafts/kstd-platform",
            languages = listOf(EnumLanguage.CPP),
            description = "OS abstractions for various purposes like memory mapping for C++17/20"
        ),
        Project(
            name = "socket-library",
            icon = null,
            url = "https://github.com/Cach30verfl0w/socket-library",
            languages = listOf(EnumLanguage.CPP),
            description = "This is my try to develop a own socket library with C++ for learning purposes"
        ),
        Project(
            name = "Cash3Fl0w",
            icon = null,
            url = "https://github.com/Cach30verfl0w/cash3fl0w",
            languages = listOf(EnumLanguage.KOTLIN),
            description = "Cash3Fl0w is a discontinued finance software based on KMP with support for German banking"
        ),
        Project(
            name = "Portfolio",
            icon = null,
            url = "https://git.karmakrafts.dev/cach30verfl0w/portfolio",
            languages = listOf(EnumLanguage.KOTLIN),
            description = "Portfolio website written in Kotlin with Kobweb and Compose"
        ),
        Project(
            name = "react-native-rust-plugin",
            icon = null,
            url = "https://github.com/Cach30verfl0w/react-native-rust-plugin",
            languages = listOf(EnumLanguage.JAVA),
            description = "Gradle Plugin for compatibility between Rust Code and TypeScript Code for Android"
        )
    )
    val breakpoint = rememberBreakpoint()
    if (breakpoint >= Breakpoint.MD) {
        Row(Modifier.gap(1.cssRem)) {
            for (project in projects) {
                ProjectEntry(project)
            }
        }
    } else {
        Column(Modifier.gap(1.cssRem)) {
            for (project in projects) {
                ProjectEntry(project)
            }
        }
    }
}
