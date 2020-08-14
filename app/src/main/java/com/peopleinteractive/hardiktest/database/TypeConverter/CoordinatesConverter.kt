package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class CoordinatesConverter {

    @TypeConverter
    fun fromString(value: String?): User.Coordinates {
        val listType = object :
            TypeToken<User.Coordinates?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Coordinates?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}