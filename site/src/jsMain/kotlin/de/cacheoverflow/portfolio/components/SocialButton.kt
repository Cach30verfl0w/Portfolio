package de.cacheoverflow.portfolio.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.window
import org.jetbrains.compose.web.css.px

enum class EnumSocial(
    private val literal: String,
    internal val url: String,
    val lightIcon: String,
    val darkIcon: String
) {
    LINKEDIN(
        literal = "LinkedIn",
        url = "https://www.linkedin.com/in/cedric-hammes-007995306",
        icon = "/socials/linkedin.png"
    ),
    GITHUB(
        literal = "GitHub",
        url = "https://github.com/cach30verfl0w",
        lightIcon = "/socials/github-black.png",
        darkIcon = "/socials/github-white.png"
    ),
    GITLAB(
        literal = "GitLab",
        url = "https://git.karmakrafts.dev/cach30verfl0w",
        icon = "/socials/gitlab.png"
    );
    
    constructor(literal: String, url: String, icon: String) : this(literal, url, icon, icon)
    
    override fun toString(): String = literal
}

@Composable
fun SocialButton(social: EnumSocial) {
    val colorMode by ColorMode.currentState
    Box(Modifier.onClick { window.location.href = social.url }.padding(right = 5.px)) {
        Image(
            src = if (colorMode == ColorMode.DARK) social.darkIcon else social.lightIcon,
            alt = social.toString(),
            modifier = Modifier.width(30.px).height(30.px))
    }
}