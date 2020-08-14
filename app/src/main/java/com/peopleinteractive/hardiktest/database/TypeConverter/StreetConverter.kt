package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class StreetConverter {

    @TypeConverter
    fun fromString(value: String?): User.Street {
        val listType = object :
            TypeToken<User.Street?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Street?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}