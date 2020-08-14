package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class IdConverter {

    @TypeConverter
    fun fromString(value: String?): User.Id {
        val listType = object :
            TypeToken<User.Id?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Id?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}