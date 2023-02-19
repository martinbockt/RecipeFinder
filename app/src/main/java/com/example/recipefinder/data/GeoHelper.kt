package com.example.recipefinder.data

class GeoHelper {
    companion object {
        fun formatLocationToCuisine(location: String): String {
            when (location) {
                "United States" -> return "American"
                "Canada" -> return "American"
                "United Kingdom" -> return "British"
                "China" -> return "Chinese"
                "Poland" -> return "Eastern European"
                "Hungary" -> return "Eastern European"
                "Czech Republic" -> return "Eastern European"
                "Slovakia" -> return "Eastern European"
                "France" -> return "French"
                "Germany" -> return "German"
                "Greece" -> return "Greek"
                "India" -> return "Indian"
                "Ireland" -> return "Irish"
                "Italy" -> return "Italian"
                "Japan" -> return "Japanese"
                "South Korea" -> return "Korean"
                "Mexico" -> return "Mexican"
                "Egypt" -> return "Middle Eastern"
                "Sweden" -> return "Nordic"
                "Spain" -> return "Spanish"
                "Vietnam" -> return "Vietnamese"
                "Thailand" -> return "Thai"
                "Austria" -> return "European"
                "Switzerland" -> return "European"
                else -> return "European"

            }
        }

    }
}