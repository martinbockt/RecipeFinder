package com.example.recipefinder.ui.search

import androidx.compose.runtime.saveable.Saver

data class InitialSearchSettings(
    var cuisine: String? = null,
    var excludeCuisine: String? = null,
    var diet: String? = null,
    var intolerances: String? = null,
    var type: String? = null,
    var maxReadyTime: String? = null,
    var sort: String? = null,
)

fun optionalToString(value: String?): String {
    if (value != null) return value
    return " "
}

fun searchSettingsToString(value: InitialSearchSettings): String {
    var returnString = "${optionalToString(value.cuisine)};"
    returnString += "${optionalToString(value.excludeCuisine)};"
    returnString += "${optionalToString(value.diet)};"
    returnString += "${optionalToString(value.intolerances)};"
    returnString += "${optionalToString(value.type)};"
    returnString += "${optionalToString(value.maxReadyTime)};"
    returnString += optionalToString(value.sort)
    return returnString
}

fun stringToSearchSettings(value: String, number: Int): String? {
    val splitString = value.split(';')
    if (splitString[number] == " ") return null
    return splitString[number]
}

val InitialSearchSettingsSaver = Saver<InitialSearchSettings, String>(
    save = {searchSettingsToString(it)},
    restore = {
        InitialSearchSettings(
            cuisine = stringToSearchSettings(it,0),
            excludeCuisine = stringToSearchSettings(it,1),
            diet = stringToSearchSettings(it,2),
            intolerances = stringToSearchSettings(it,3),
            type = stringToSearchSettings(it,4),
            maxReadyTime = stringToSearchSettings(it,5),
            sort = stringToSearchSettings(it,6),
        )
    }
)