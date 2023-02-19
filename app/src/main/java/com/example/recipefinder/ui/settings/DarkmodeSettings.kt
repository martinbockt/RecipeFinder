package com.example.recipefinder.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DarkmodeSwitch(switchState: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Card() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp, 8.dp).fillMaxWidth()
        ) {
            Text(
                text = "Dark Mode",
                style = MaterialTheme.typography.titleMedium
            )
            Switch(
                checked = switchState,
                onCheckedChange = {
                    onCheckedChange(it)
                },
                thumbContent = {
                    Icon(
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                        imageVector = if (switchState) Icons.Rounded.DarkMode else Icons.Rounded.LightMode,
                        contentDescription = "Switch Icon"
                    )
                },
                colors = SwitchDefaults.colors(
                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                    checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                ),
            )
        }
    }
}