package model.sharedPreferences

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get


class NameStore {
    private val settings: Settings = Settings()

    fun add(name: String){
        settings.putString("Name", name)
    }

    fun get(): String{
        return settings["Name"] ?: "Student"
    }

}