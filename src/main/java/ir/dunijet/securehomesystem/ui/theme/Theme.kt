package ir.dunijet.securehomesystem.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(

    onBackground = Color.White,

    primary = DarkPrimary,
    primaryVariant = DarkBackground,

    secondary = DarkInputColor ,
    secondaryVariant = DarkButtonSelected,

    background = DarkBackgroundMain ,

    onPrimary = DarkTextSelected ,
    onSecondary = DarkTextNotSelected ,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(

    primary = LightPrimary,
    primaryVariant = Color.White,

    secondary = LightInputColor ,
    secondaryVariant = LightButtonSelected,

    background = LightBackgroundMain ,

    onPrimary = LightTextSelected ,
    onSecondary = LightTextNotSelected ,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

// new
@Composable
fun SecureHomeSystemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}