package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class TimezonConverter {

    @TypeConverter
    fun fromString(value: String?): User.Timezone {
        val listType = object :
            TypeToken<User.Timezone?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Timezone?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}