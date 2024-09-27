package de.cacheoverflow.portfolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import de.cacheoverflow.portfolio.components.EnumSocial
import de.cacheoverflow.portfolio.components.ProjectList
import de.cacheoverflow.portfolio.components.SocialButton
import de.cacheoverflow.portfolio.components.layouts.PageLayout
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

val nameTextStyle = CssStyle.base {
    Modifier.fontSize(2.cssRem)
}

val headerTextStyle = CssStyle.base {
    Modifier.fontSize(1.25.cssRem)
}

@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        Column(Modifier.fillMaxWidth().gap(8.cssRem)) {
            Column(Modifier.maxWidth(50.cssRem).gap(2.cssRem)) {
                Row {
                    Image(
                        src = "/me.png",
                        modifier = Modifier.borderRadius(50.percent).width(100.px).height(100.px)
                    )
                    Column(Modifier.padding(left = 25.px).fillMaxHeight()) {
                        Div(nameTextStyle.toAttrs()) {
                            Text(value = "Cedric Hammes")
                        }
                        Div(headerTextStyle.toAttrs()) {
                            Text(value = "Software Engineer")
                        }
                        Row(Modifier.padding(top = 5.px)) {
                            SocialButton(EnumSocial.LINKEDIN)
                            SocialButton(EnumSocial.GITLAB)
                            SocialButton(EnumSocial.GITHUB)
                        }
                    }
                }
                Text(
                    "Hi, I'm Cedric Hammes and I'm a software engineer from Rhineland-Palatinate with programming " +
                            "skills in Kotlin, C++ and Rust. I am also interested in software security, especially " +
                            "cryptography. I love to deal with new problems and technologies and to broaden my horizon."
                )
            }
            ProjectList()
        }
    }
}
