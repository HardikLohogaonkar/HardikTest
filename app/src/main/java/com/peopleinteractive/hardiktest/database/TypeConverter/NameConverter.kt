package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class NameConverter {

    @TypeConverter
    fun fromString(value: String?): User.Name {
        val listType = object :
            TypeToken<User.Name?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Name?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}