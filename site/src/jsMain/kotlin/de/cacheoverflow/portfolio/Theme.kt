package de.cacheoverflow.portfolio

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.color
import org.jetbrains.compose.web.css.rgb

val LightColorScheme: ColorScheme
    get() {
        return lightColorScheme(
            primary = Color(0xFF11CC1A),
            onPrimary = Color(0xFF040404),
            primaryContainer = Color(0xff5bcc60),
            onPrimaryContainer = Color(0xFF212121),
            secondary = Color(0xFFE0E6FF),
            onSecondary = Color(0xFF101010),
            secondaryContainer = Color(0xFF666666),
            onSecondaryContainer = Color(0xFFE6E6E6),
            tertiary = Color(0xFFC3C9E0),
            onTertiary = Color(0xFF040404),
            tertiaryContainer = Color(0xFF666666),
            onTertiaryContainer = Color(0xFFE6E6E6),
            error = Color(0xFF8A0D1D),
            errorContainer = Color(0xFFFFDAD6),
            onError = Color(0xFFFFFFFF),
            onErrorContainer = Color(0xFF45002),
            background = Color(0xFFFFFFFF),
            onBackground = Color(0xFF000000),
            surface = Color(0xFFFCFEFE),
            onSurface = Color(0xFF121212),
            surfaceVariant = Color(0xFF214152),
            onSurfaceVariant = Color(0xFF222222),
            outline = Color(0xFF79D07D),
            inverseOnSurface = Color(0xFFD6F6FF),
            inverseSurface = Color(0xFF00363F),
        )
    }

val DarkColorScheme: ColorScheme
    get() {
        return darkColorScheme(
            primary = Color(0xff70ee56),
            onPrimary = Color(0xFF040404),
            primaryContainer = Color(0xff5bcc60),
            onPrimaryContainer = Color(0xFFEEEEEE),
            secondary = Color(0xff2d3436),
            onSecondary = Color(0xFFFFFFFF),
            secondaryContainer = Color(0xFF666666),
            onSecondaryContainer = Color(0xFFE6E6E6),
            tertiary = Color(0xFF505D62),
            onTertiary = Color(0xFFFFFFFF),
            tertiaryContainer = Color(0xFF666666),
            onTertiaryContainer = Color(0xFFE6E6E6),
            error = Color(0xFFCE0F27),
            errorContainer = Color(0xFFFFDAD6),
            onError = Color(0xFFFFFFFF),
            onErrorContainer = Color(0xFF45002),
            background = Color(0xFF121212),
            onBackground = Color(0xFFFFFFFF),
            surface = Color(0xff02500),
            onSurface = Color(0xFFFFFFFF),
            surfaceVariant = Color(0xFF214152),
            onSurfaceVariant = Color(0xFFFFFFFF),
            outline = Color(0xFF79D07D),
            inverseOnSurface = Color(0xFF161616)
        )
    }


fun ColorMode.toColorScheme(): ColorScheme = when (this) {
    ColorMode.DARK -> DarkColorScheme
    ColorMode.LIGHT -> LightColorScheme
}

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.background = LightColorScheme.background.toKobwebColor()
    ctx.theme.palettes.light.color = LightColorScheme.onBackground.toKobwebColor()
    ctx.theme.palettes.dark.background = DarkColorScheme.background.toKobwebColor()
    ctx.theme.palettes.dark.color = DarkColorScheme.onBackground.toKobwebColor()
}

fun Color.toKobwebColor(): com.varabyte.kobweb.compose.ui.graphics.Color =
    com.varabyte.kobweb.compose.ui.graphics.Color.rgb(red, blue, green)
fun Modifier.backgroundColor(color: Color) =
    this.backgroundColor(rgb(color.red * 255, color.green * 255, color.blue * 255))
fun Modifier.background(color: Color) =
    this.background(rgb(color.red * 255, color.green * 255, color.blue * 255))
