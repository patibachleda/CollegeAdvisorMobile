package model.sharedPreferences

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import model.data.Favorites


class FavoritesStore {
    private val settings: Settings = Settings()

    fun add(school: String, major: String, years: String) {
        settings.putString("SCHOOL_$school$major$years", school)
        settings.putString("MAJOR_$school$major$years", major)
        settings.putString("YEARS_$school$major$years", years)
    }

    fun get(school: String, major: String, years: String): Favorites {
        val savedSchool = settings["SCHOOL_$school$major$years"] ?: "null"
        val savedMajor = settings["MAJOR_$school$major$years"] ?: "null"
        val savedYears = settings["YEARS_$school$major$years"] ?: "null"

        return Favorites(savedSchool, savedMajor, savedYears)
    }

    fun getAll(): MutableList<Favorites> {
        val keys = settings.keys
        val favoritesList = mutableListOf<Favorites>()

        for (key in keys){
            if (key.contains("SCHOOL_")){
                val keyString = key.substringAfterLast("SCHOOL_")
                val savedSchool = settings["SCHOOL_$keyString"] ?: "null"
                val savedMajor = settings["MAJOR_$keyString"] ?: "null"
                val savedYears = settings["YEARS_$keyString"] ?: "null"
                favoritesList.add(Favorites(savedSchool, savedMajor, savedYears))
            }
        }
        return favoritesList
    }
}