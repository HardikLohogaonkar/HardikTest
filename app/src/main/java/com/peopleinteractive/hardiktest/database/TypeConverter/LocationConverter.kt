package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class LocationConverter {

    @TypeConverter
    fun fromString(value: String?): User.Location {
        val listType = object :
            TypeToken<User.Location?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Location?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}