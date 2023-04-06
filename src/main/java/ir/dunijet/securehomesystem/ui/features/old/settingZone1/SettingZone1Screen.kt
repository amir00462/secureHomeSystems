package ir.dunijet.securehomesystem.ui.features.old.settingZone1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.burnoo.cokoin.navigation.getNavController
import ir.dunijet.securehomesystem.R
import ir.dunijet.securehomesystem.ui.Zone
import ir.dunijet.securehomesystem.util.CheshmiTwoTypesStep
import ir.dunijet.securehomesystem.util.EyeTypes
import ir.dunijet.securehomesystem.util.MyScreens
import ir.dunijet.securehomesystem.util.ZoneType

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SettingZone1Screen() {

    val context = LocalContext.current
    val navigation = getNavController()

    // states
    val eye1 = remember { mutableStateOf(EyeTypes.GheirFaal) }
    val eye2 = remember { mutableStateOf(EyeTypes.Faal) }
    val eye3 = remember { mutableStateOf(EyeTypes.GheirFaal) }
    val eye4 = remember { mutableStateOf(EyeTypes.Faal) }
    val doodAtashOrEye = remember { mutableStateOf(EyeTypes.GheirFaal) }

    Scaffold(
        topBar = {

            TopAppBar(

                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(0.76f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        text = "مرحله ۱ از ۳",
                        color = MaterialTheme.colors.onSecondary,
                        textAlign = TextAlign.Center

                    )
                },

                navigationIcon = {
                    IconButton(onClick = { navigation.popBackStack() }) {
                        Icon(
                            modifier = Modifier.scale(scaleX = -1f, scaleY = 1f),
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back Button",
                            tint = MaterialTheme.colors.onSecondary
                        )
                    }
                },

                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = Color.Gray,
                elevation = 0.dp
            )

        }
    ) {

        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    text = "تنظیمات زون ها",
                    modifier = Modifier.padding(top = 22.dp, start = 16.dp)
                )

                Zone(
                    Modifier.padding(top = 24.dp),
                    "سنسور چشمی",
                    R.drawable.ic_eye,
                    ZoneType.CheshmiFourTypes,
                    CheshmiTwoTypesStep.FaalGheirFaal ,
                    eye1.value,
                ) {
                    eye1.value = it
                }

                Zone(
                    Modifier.padding(top = 16.dp),
                    "سنسور چشمی",
                    R.drawable.ic_eye,
                    ZoneType.CheshmiFourTypes,
                    CheshmiTwoTypesStep.FaalGheirFaal ,
                    eye2.value,
                ) {
                    eye2.value = it
                }

                Zone(
                    Modifier.padding(top = 16.dp),
                    "سنسور چشمی",
                    R.drawable.ic_eye,
                    ZoneType.CheshmiFourTypes,
                    CheshmiTwoTypesStep.FaalGheirFaal ,
                    eye3.value,
                ) {
                    eye3.value = it
                }

                Zone(
                    Modifier.padding(top = 16.dp),
                    "سنسور چشمی",
                    R.drawable.ic_eye,
                    ZoneType.CheshmiFourTypes,
                    CheshmiTwoTypesStep.FaalGheirFaal ,
                    eye4.value,
                ) {
                    eye4.value = it
                }

                Zone(
                    Modifier.padding(top = 16.dp),
                    "سنسور دود و آتش",
                    R.drawable.ic_eye,
                    CheshmiTwoTypesStep.FaalGheirFaal ,
                    doodAtashOrEye.value,
                    { doodAtashOrEye.value = it },
                    {

                    }
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 24.dp, bottom = 24.dp),
                    shape = MaterialTheme.shapes.large,
                    onClick = {
                        navigation.navigate(MyScreens.SettingZone2Screen.route)
                    }) {
                    Text(
                        text = "ذخیره و ارسال",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    )
                }
            }
        }

    }


}