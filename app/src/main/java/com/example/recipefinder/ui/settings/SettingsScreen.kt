package com.example.recipefinder.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipefinder.data.DataStoreUtil
import com.example.recipefinder.data.ThemeViewModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.recipefinder.data.RecipeViewModel
import kotlinx.coroutines.launch

val colors = listOf(
    Color(0xFFEF9A9A),
    Color(0xFFF48FB1),
    Color(0xFF80CBC4),
    Color(0xFFA5D6A7),
    Color(0xFFFFCC80),
    Color(0xFFFFAB91),
    Color(0xFF81D4FA),
    Color(0xFFCE93D8),
    Color(0xFFB39DDB)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    dataStoreUtil: DataStoreUtil,
    themeViewModel: ThemeViewModel,
    recipeViewModel: RecipeViewModel
) {
    val openDialog = remember { mutableStateOf(false) }
    var switchState by remember {themeViewModel.isDarkThemeEnabled }
    val coroutineScope = rememberCoroutineScope()

    if (openDialog.value) {
        DeleteAllRecipeDialog({openDialog.value = it}) {
            openDialog.value = it
            recipeViewModel.deleteAllRecipes()
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Settings", style = MaterialTheme.typography.headlineMedium)
            }
        }
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DarkmodeSwitch(switchState = switchState) {
                coroutineScope.launch {
                    dataStoreUtil.saveTheme(it)
                }
            }
            ColourButton(dataStoreUtil, colors) {
                coroutineScope.launch {
                    dataStoreUtil.saveColorScheme(it.toArgb())
                }
            }
            Text(
                text = "Diet Preference",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            FoodPreferences(dataStoreUtil) {
                coroutineScope.launch {
                    dataStoreUtil.saveFoodPreferences(it)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                Button(onClick = { openDialog.value = true }) {
                    Text("Clear liked recipes")
                }
            }
        }
    }
}