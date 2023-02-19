package com.example.recipefinder.data

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreUtil(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")

        val THEME_KEY = booleanPreferencesKey("theme")
        val COLOR_KEY = intPreferencesKey("color")
        val FOOD_KEY = stringPreferencesKey("food")
    }

    fun getTheme(isSystemDarkTheme: Boolean): Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[THEME_KEY] ?: isSystemDarkTheme
        }

    fun getThemeColor(selectedColorScheme: Int): Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[COLOR_KEY] ?: selectedColorScheme
        }

    fun getFoodPreference(food: String): Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[FOOD_KEY] ?: food
        }

    suspend fun saveTheme(isDarkThemeEnabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[THEME_KEY] = isDarkThemeEnabled
        }
    }

    suspend fun saveColorScheme(selectedColorScheme: Int) {
        context.dataStore.edit { preferences ->
            preferences[COLOR_KEY] = selectedColorScheme
        }
    }

    suspend fun saveFoodPreferences(food: String) {
        context.dataStore.edit { preferences ->
            preferences[FOOD_KEY] = food
        }
    }
}

class ThemeViewModel: ViewModel() {
    var isDarkThemeEnabled = mutableStateOf(false)
        private set

    fun setTheme(isDarkTheme: State<Boolean>) {
        isDarkThemeEnabled.value = isDarkTheme.value
    }
}