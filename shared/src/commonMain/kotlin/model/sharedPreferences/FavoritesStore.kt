package model.sharedPreferences

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import model.data.Favorites


class FavoritesStore {
    // #2 - Custom type
    private val settings: Settings by lazy { Settings() }

    fun add(school: String, major: String, years: String){
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
}