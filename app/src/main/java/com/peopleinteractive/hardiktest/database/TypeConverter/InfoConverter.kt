package com.peopleinteractive.hardiktest.database.TypeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.peopleinteractive.hardiktest.model.User

class InfoConverter {

    @TypeConverter
    fun fromString(value: String?): User.Info {
        val listType = object :
            TypeToken<User.Info?>() {}.type
        return Gson().fromJson(
            value,
            listType
        )
    }

    @TypeConverter
    fun fromBody(list: User.Info?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}