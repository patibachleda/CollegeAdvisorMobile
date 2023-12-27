package model.sharedPreferences

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import model.data.Favorites


class FavoritesStore {
    private val settings: Settings = Settings()

    fun add(school: String, major: String, code: String) {
        settings.putString("SCHOOL_$school$major", school)
        settings.putString("MAJOR_$school$major", major)
        settings.putString("CODE_$school$major", code)
    }

    fun get(school: String, major: String): Favorites {
        val savedSchool = settings["SCHOOL_$school$major"] ?: "null"
        val savedMajor = settings["MAJOR_$school$major"] ?: "null"
        val savedCode = settings["CODE_$school$major"] ?: "null"

        return Favorites(savedSchool, savedMajor, savedCode)
    }

    fun getAll(): MutableList<Favorites> {
        val keys = settings.keys
        val favoritesList = mutableListOf<Favorites>()

        for (key in keys){
            if (key.contains("SCHOOL_")){
                val keyString = key.substringAfterLast("SCHOOL_")
                val savedSchool = settings["SCHOOL_$keyString"] ?: "null"
                val savedMajor = settings["MAJOR_$keyString"] ?: "null"
                val savedCode = settings["CODE_$keyString"] ?: "null"

                favoritesList.add(Favorites(savedSchool, savedMajor, savedCode))
            }
        }
        return favoritesList
    }

    fun remove(school: String, major: String): MutableList<Favorites>{
        settings.remove("SCHOOL_$school$major")
        settings.remove("MAJOR_$school$major")
        settings.remove("CODE_$school$major")

        return getAll()
    }
}